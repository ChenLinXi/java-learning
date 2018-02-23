package com.jason.state.work;

public class ForenoonWorkState extends WorkState {

    @Override
    public void WriteProgram(Work work) {

        if (work.getHour() < 12) {
            System.out.println("当前时间: " + work.getHour() + "点 上午工作, 精神百倍");
        } else {
            work.setCurrent(new NoonWorkState());
            work.WriteProgram();
        }
    }
}
