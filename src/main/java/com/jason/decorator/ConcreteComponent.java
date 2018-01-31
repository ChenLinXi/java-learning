package com.jason.decorator;

/**
 * 创建待装饰对象
 */
public class ConcreteComponent extends Component {

    @Override
    void Operation() {
        System.out.println("具体对象的操作");
    }
}
