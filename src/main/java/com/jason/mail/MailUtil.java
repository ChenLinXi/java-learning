package com.jason.mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;

public class MailUtil {

    private static Logger logger = Logger.getLogger(MailUtil.class);

    private String user;
    private String password;
    private String host;

    public MailUtil(String user, String password, String host) {
        this.user = user;
        this.password = password;
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    /**
     * sendMail: send mail to user
     * Default Type: text/html; Default port: 25;
     *
     * @param to      receiver
     * @param body    mail body
     * @param subject mail subject
     * @return true if mail is sent successfully
     */
    public final void sendMail(String to, String body, String subject) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        Session session = Session.getInstance(properties, null);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(user);
            message.addRecipients(Message.RecipientType.TO, to);
            message.setSubject(subject);
            message.setContent(body, "text/html");
            Transport.send(message, user, password);
        } catch (javax.mail.MessagingException ex) {
            logger.error("send mail exception, message: " + ex.getLocalizedMessage(), ex);
        }
        logger.debug("mail send success");
    }
}
