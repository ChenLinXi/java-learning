package com.jason.decorator;

public class DecoratorTest {

    /**
     * 装饰器模式
     *
     * Steps:
     *
     * a) 实例化对象
     *
     * b) 实例化不同的装饰器
     *
     * c) 依次迭代装饰，调用Decorator的setComponent()方法
     *
     * d) 装饰结束后，调用Operation()方法
     */
    public static void main(String[] args) {
        // 实例待装饰对象
        ConcreteComponent component = new ConcreteComponent();

        // 实例不同的装饰器
        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB decoratorB = new ConcreteDecoratorB();

        // 依次装饰
        // 先用A装饰
        decoratorA.setComponent(component);
        // 在用A装饰的基础上，再用B装饰 待装饰对象
        decoratorB.setComponent(decoratorA);

        // 装饰结束，通过装饰器调用 待装饰对象的方法
        decoratorB.Operation();
    }
}
