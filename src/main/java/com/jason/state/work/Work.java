package com.jason.state.work;

public class Work {

    private WorkState current;

    private Double hour;

    private Boolean finish = false;

    public Work() {
        this.current = new ForenoonWorkState();
    }

    public WorkState getCurrent() {
        return current;
    }

    public void setCurrent(WorkState current) {
        this.current = current;
    }

    public Double getHour() {
        return hour;
    }

    public void setHour(Double hour) {
        this.hour = hour;
    }

    public Boolean getFinish() {
        return finish;
    }

    public void setFinish(Boolean finish) {
        this.finish = finish;
    }

    public void WriteProgram() {
        current.WriteProgram(this);
    }
}
