package com.jason.methodInvoke.service;

/**
 * 抽象功能类
 *
 * 实现protected类型，提供给子类复用
 */
public abstract class AbstractService {

    protected String hello() {
        return "hello";
    }
}
