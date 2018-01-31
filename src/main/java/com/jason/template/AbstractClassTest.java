package com.jason.template;

/**
 * 模版
 *
 * a) 定义模版虚类
 *
 * b) 定义一些共用的方法
 *
 * c) 提供模版方法，给出逻辑的骨架
 *
 * d）共用方法由子类完成
 */
public class AbstractClassTest {

    public static void main(String[] args) {
        ConcreteAbstractClass abstractClass = new ConcreteAbstractClass();
        abstractClass.TemplateMethod();
    }
}
