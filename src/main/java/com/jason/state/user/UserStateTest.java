package com.jason.state.user;

import java.util.Date;

public class UserStateTest {

    public static void main(String[] args) {

        UserVerify abnormalUser = new UserVerify();
        abnormalUser.setCurrent(new AbnormalUserState());
        abnormalUser.Verify();

        UserVerify normalUser = new UserVerify();
        normalUser.setCurrent(new UnlockedUserState());
        normalUser.Verify();

        UserVerify lockedUser = new UserVerify();
        lockedUser.setCurrentTime(new Date());
        lockedUser.setCurrent(new LockedUserState());
        lockedUser.Verify();
    }
}
