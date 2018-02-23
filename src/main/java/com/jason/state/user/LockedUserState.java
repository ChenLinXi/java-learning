package com.jason.state.user;

import java.util.Calendar;

public class LockedUserState extends UserState {

    @Override
    public void verify(UserVerify userVerify) {

        if ((Calendar.getInstance().getTimeInMillis() / 1e3 - userVerify.getCurrentTime().getTime()) > 7200) {
            System.out.println("用户登陆成功");
        } else {
            System.out.println("用户已被锁定, 请两小时后登陆");
        }
    }
}
