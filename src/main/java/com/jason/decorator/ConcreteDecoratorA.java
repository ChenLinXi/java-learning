package com.jason.decorator;

/**
 * 装饰方法A
 */
public class ConcreteDecoratorA extends Decorator {

    private String addedState;

    @Override
    void Operation() {
        super.Operation();
        addedState = "new State";
        System.out.println("具体装饰对象A的操作");
    }
}
