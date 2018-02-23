package com.jason.state.work;

public class RestWorkState extends WorkState {

    @Override
    public void WriteProgram(Work work) {
        System.out.println("当前时间: " + work.getHour() + "点下班回家了");
    }
}
