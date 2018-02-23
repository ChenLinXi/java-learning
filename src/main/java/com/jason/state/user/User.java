package com.jason.state.user;

public class User {

    private long id;
    private String realName;
    private String username;
    private String email;
    private String password;
    private String salt;
    private int loginFailedCount;
    private int type;
    private int status;
    // Date类型转换为时间戳
    private int createTime;
    private int updateTime;
    private int passwordChangedTime;
    private int lastLoginTime;

    public User() {
    }

    public User(long id, String password, String salt) {
        this.id = id;
        this.password = password;
        this.salt = salt;
    }

    public User(long id, int type, int status, int loginFailedCount) {
        this.id = id;
        this.loginFailedCount = loginFailedCount;
        this.type = type;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getLoginFailedCount() {
        return loginFailedCount;
    }

    public void setLoginFailedCount(int loginFailedCount) {
        this.loginFailedCount = loginFailedCount;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public int getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(int updateTime) {
        this.updateTime = updateTime;
    }

    public int getPasswordChangedTime() {
        return passwordChangedTime;
    }

    public void setPasswordChangedTime(int passwordChangedTime) {
        this.passwordChangedTime = passwordChangedTime;
    }

    public int getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(int lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "{" +
            "ID=" + id +
            ", RealName='" + realName + '\'' +
            ", UserName='" + username + '\'' +
            ", Email='" + email + '\'' +
            ", Password='" + password + '\'' +
            ", Salt='" + salt + '\'' +
            ", LoginFailedCount=" + loginFailedCount +
            ", Type=" + type +
            ", Status=" + status +
            ", CreateTime=" + createTime +
            ", UpdateTime=" + updateTime +
            ", PasswordChangedTime=" + passwordChangedTime +
            ", LastLoginTime=" + lastLoginTime +
            '}';
    }
}
