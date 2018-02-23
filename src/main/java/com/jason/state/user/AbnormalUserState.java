package com.jason.state.user;

public class AbnormalUserState extends UserState {

    @Override
    public void verify(UserVerify userVerify) {
        System.out.println("用户已被锁定, 请联系管理员");
    }
}
