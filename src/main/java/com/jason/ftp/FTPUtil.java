package com.jason.ftp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

// FTP文件上下载工具
public class FTPUtil {

    private ThreadLocal<FTPClient> clientThreadLocal = new ThreadLocal<FTPClient>();
    private String hostname = null;
    private Integer port = 21;
    private String username = null;
    private String password = null;
    private String localExcelFile = null;

    public FTPUtil() {
    }

    public FTPUtil(String hostname, Integer port, String username, String password, String localExcelFile) {
        this.hostname = hostname;
        this.port = port;
        this.username = username;
        this.password = password;
        this.localExcelFile = localExcelFile;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocalExcelFile() {
        return localExcelFile;
    }

    public void setLocalExcelFile(String localExcelFile) {
        this.localExcelFile = localExcelFile;
    }

    /**
     * 下载远程文件
     */
    public Boolean download(String workDir, String fileName, OutputStream outputStream) throws Exception {
        return this.download(workDir, fileName, outputStream, true);
    }

    /**
     * 下载远程文件至本地指定文件
     */
    public Boolean download(String workDir, String fileName, String localAbsoluteFile) throws Exception {
        return this.download(workDir, fileName, localAbsoluteFile, true);
    }

    /**
     * 下载远程文件至本地指定文件
     */
    private Boolean download(String workDir, String fileName, String localAbsoluteFile, Boolean autoClose)
        throws Exception {
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(localAbsoluteFile);
            return this.download(workDir, fileName, outputStream, autoClose);
        } catch (FileNotFoundException ex) {
            throw new Exception("Local file not found.", ex);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException ex) {
                throw new Exception("Could not close FileOutputStream.", ex);
            }
        }
    }

    /**
     * 下载远程文件，处理后关闭流
     *
     * @param workDir 远程路径
     * @param fileName 文件名
     * @param outputStream 本地输出流
     * @param autoClose 关闭连接
     * @return true if file download
     * @throws Exception IOException
     */
    private Boolean download(String workDir, String fileName, OutputStream outputStream, Boolean autoClose)
        throws Exception {
        try {
            FTPClient ftpClient = this.getFTPClientFromPool();
            ftpClient.changeWorkingDirectory(workDir);
            FTPFile[] ftpFiles = ftpClient.listFiles();
            if (ftpFiles == null || ftpFiles.length == 0) {
                return false;
            }
            Boolean isExist = false;
            for (FTPFile ftpFile : ftpFiles) {
                if (ftpFile.getName().contains(fileName)) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                return false;
            }
            return ftpClient.retrieveFile(fileName, outputStream);
        } catch (IOException ex) {
            throw new Exception("Could not get file from ftp server.", ex);
        } finally {
            if (autoClose) {
                this.disConnect();
            }
        }
    }

    /**
     * 上传本地文件至服务器
     */
    public Boolean upload(String workDir, String fileName, String localAbsoluteFile) throws Exception {
        return this.upload(workDir, fileName, localAbsoluteFile, true);
    }

    /**
     * 上传本地文件至ftp服务器
     *
     * @param workDir 远程完成路径
     * @param fileName 上传文件名
     * @param localAbsoluteFile 本地文件完整路径
     * @param autoClose 是否自动关闭连接
     * @return true if file is upload
     * @throws Exception IOException
     */
    private Boolean upload(String workDir, String fileName, String localAbsoluteFile, Boolean autoClose)
        throws Exception {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(localAbsoluteFile);
            FTPClient client = this.getFTPClientFromPool();
            client.changeWorkingDirectory(workDir);
            return client.storeFile(fileName, inputStream);
        } catch (FileNotFoundException ex) {
            throw new Exception("Local file not found.", ex);
        } catch (IOException ex) {
            throw new Exception("Could not upload file to ftp server.", ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception ex) {
                throw new Exception("Could not close FileInputStream.", ex);
            }
            if (autoClose) {
                disConnect();
            }
        }
    }

    /**
     * 创建远程文件目录
     *
     * @param pathname 目录名称
     * @param workingDirectory 工作路径
     * @return true if directory is made
     * @throws Exception IOException
     */
    public Boolean mkdir(String pathname, String workingDirectory) throws Exception {
        return this.mkdir(pathname, workingDirectory, true);
    }

    /**
     * 创建目录（不支持一次创建多级目录）
     */
    private Boolean mkdir(String pathname, String workingDirectory, Boolean autoClose) throws Exception {
        try {
            this.getFTPClientFromPool().changeWorkingDirectory(workingDirectory);
            return this.getFTPClientFromPool().makeDirectory(pathname);
        } catch (IOException ex) {
            throw new Exception("Could not mkdir.", ex);
        } finally {
            if (autoClose) {
                this.disConnect();
            }
        }
    }

    /**
     * 断开ftp连接
     */
    private void disConnect() throws Exception {
        try {
            FTPClient ftpClient = this.getFTPClientFromPool();
            ftpClient.logout();
            if (ftpClient.isConnected()) {
                ftpClient.disconnect();
                ftpClient = null;
            }
        } catch (IOException ex) {
            throw new Exception("Could not disconnect from server.", ex);
        }
    }

    /**
     * 从连接池中获取ftp连接
     */
    private FTPClient getFTPClientFromPool() throws Exception {
        if (this.clientThreadLocal.get() != null && this.clientThreadLocal.get().isConnected()) {
            return this.clientThreadLocal.get();
        }
        FTPClient ftpClient = this.getFTPClient();
        this.clientThreadLocal.set(ftpClient);
        return ftpClient;
    }

    /**
     * 创建ftp连接至连接池
     */
    private FTPClient getFTPClient() throws Exception {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding("UTF-8");
        try {
            ftpClient.connect(this.hostname, this.port);
            int reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                throw new Exception("FTP server refused connection.");
            }

            if (ftpClient.login(this.username, this.password)) {
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            }
            ftpClient.enterLocalPassiveMode();
            ftpClient.setSoTimeout(6000);
        } catch (IOException ex) {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    throw new Exception("Could not disconnect from server.", e);
                }
            }
            throw new Exception("Could not connect to server.", ex);
        }
        return ftpClient;
    }
}
