package com.jason.adapter;

public class Main {

    public static void main(String[] args) {
        // 期望的请求
        Target target = new Target() {
            @Override
            public void Request() {
                super.Request();
            }
        };
        target.Request();

        // 待适配的请求
        Adaptee adaptee = new Adaptee();
        adaptee.SpecificRequest();

        // 适配后的请求
        Target adapter = new Adapter(adaptee);
        adapter.Request();
    }
}
