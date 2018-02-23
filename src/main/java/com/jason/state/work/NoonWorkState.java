package com.jason.state.work;

public class NoonWorkState extends WorkState {

    @Override
    public void WriteProgram(Work work) {

        if (work.getHour() < 13) {
            System.out.println("当前时间: " + work.getHour() + "点 饿了, 午饭: 犯困, 午休.");
        } else {
            work.setCurrent(new AfternoonWorkState());
            work.WriteProgram();
        }
    }
}
