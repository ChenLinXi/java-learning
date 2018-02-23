package com.jason.stack;

public class StackTest {

    public static void main(String[] args) {

        // java -XX:+PrintFlagsFinal -version | grep ThreadStackSize
        // java jvm stack initial size is 1024 = 2^10
        System.out.println(calculate(10L));
    }

    private static Long calculate(Long number) {
        if (number == 0L) {
            return 0L;
        } else if (number == 1L) {
            return 1L;
        } else {
            return calculate(number - 1L) + calculate(number - 2L);
        }
    }
}
