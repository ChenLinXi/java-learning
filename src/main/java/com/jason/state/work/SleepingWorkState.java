package com.jason.state.work;

public class SleepingWorkState extends WorkState {

    @Override
    public void WriteProgram(Work work) {
        System.out.println("当前时间: " + work.getHour() + "点, 不行了, 睡觉了.");
    }
}
