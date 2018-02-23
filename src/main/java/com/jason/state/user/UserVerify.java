package com.jason.state.user;

import java.util.Date;

public class UserVerify {

    private UserState current;

    private Integer loginFailedCount;

    private Date currentTime;

    public UserVerify() {

    }

    public UserState getCurrent() {
        return current;
    }

    public void setCurrent(UserState current) {
        this.current = current;
    }

    public Integer getLoginFailedCount() {
        return loginFailedCount;
    }

    public void setLoginFailedCount(Integer loginFailedCount) {
        this.loginFailedCount = loginFailedCount;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public void Verify() {
        this.current.verify(this);
    }
}
