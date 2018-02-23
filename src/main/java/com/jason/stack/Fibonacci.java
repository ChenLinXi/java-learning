package com.jason.stack;

public class Fibonacci {

    private Long number;

    public Fibonacci(Long number) {
        this.number = number;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long calculate(Long number) {
        if (number == 0L) {
            return 0L;
        } else if (number == 1L) {
            return 1L;
        } else {
            return calculate(number - 1L) + calculate(number - 2L);
        }
    }
}
