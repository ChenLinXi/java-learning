package com.jason.innerclass;

public interface DefaultInterface {

    default String hello() {
        return "hello world";
    }
}
