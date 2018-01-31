package com.jason.decorator;

/**
 * 装饰方法B
 */
public class ConcreteDecoratorB extends Decorator {

    @Override
    void Operation() {
        super.Operation();
        AddedBehavior();
        System.out.println("具体装饰对象B的操作");
    }

    private void AddedBehavior() {

    }
}
