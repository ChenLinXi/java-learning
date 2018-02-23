package com.jason.state.work;

public class EveningWorkState extends WorkState {

    @Override
    public void WriteProgram(Work work) {

        if (work.getFinish()) {
            work.setCurrent(new RestWorkState());
            work.WriteProgram();
        } else {
            if (work.getHour() < 21) {
                System.out.println("当前时间: " + work.getHour() + "点 加班哦, 疲累之极");
            } else {
                work.setCurrent(new SleepingWorkState());
                work.WriteProgram();
            }
        }
    }
}
