package com.jason.methodInvoke;

import com.jason.methodInvoke.service.impl.MainServiceImpl;

public class Main {

    public static void main(String[] args) {
        // 调用主功能
        // 1. 调用子功能
        // 2. 子功能继承抽象父类的protected方法
        MainServiceImpl mainService = new MainServiceImpl();

        System.out.println(mainService.hello("chenmeng"));
    }
}
