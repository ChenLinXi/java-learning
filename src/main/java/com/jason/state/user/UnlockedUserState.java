package com.jason.state.user;

public class UnlockedUserState extends UserState {

    @Override
    public void verify(UserVerify userVerify) {

        System.out.println("登陆成功");
    }
}
