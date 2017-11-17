package com.jason.innerclass;

public class DefaultInterfaceImpl implements DefaultInterface {

    @Override
    public String hello() {
        return DefaultInterface.super.hello();
    }
}
