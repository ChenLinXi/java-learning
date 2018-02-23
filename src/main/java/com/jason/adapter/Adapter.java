package com.jason.adapter;

/**
 * 适配器：将Adaptee转换成Target
 */
public class Adapter extends Target {

    // 待适配类
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    // 适配后的方法
    @Override
    public void Request() {
        adaptee.SpecificRequest();
    }
}
