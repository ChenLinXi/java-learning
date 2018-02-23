package com.jason.state.work;

public class AfternoonWorkState extends WorkState {

    @Override
    public void WriteProgram(Work work) {

        if (work.getHour() < 17) {
            System.out.println("当前时间: " + work.getHour() + "点 下午状态还不错, 继续努力");
        } else {
            work.setCurrent(new EveningWorkState());
            work.WriteProgram();
        }
    }
}
