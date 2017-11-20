package com.jason.switchcase;

/**
 * switch-case wastes more time than if-else, it's a better way to use if-else taking replace of switch-case
 */
public class SwitchTest {

    public static void main(String[] args) {
        long begin = System.nanoTime();
        int flag = 100;
        long duration = 0;
        switch (flag) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 100:
                duration = System.nanoTime() - begin;
                System.out.println(duration);
        }

        begin = System.nanoTime();
        if (flag == 1) {

        } else if (flag == 2) {

        } else if (flag == 3) {

        } else if (flag == 4) {

        } else if (flag == 5) {

        } else if (flag == 100) {
            duration = System.nanoTime() - begin;
            System.out.println(duration);
        }
    }
}
