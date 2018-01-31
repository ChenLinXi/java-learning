package com.jason.decorator;

/**
 * 装饰器
 */
public abstract class Decorator extends Component {

    protected Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    void Operation() {
        if (component != null) {
            component.Operation();
        }
    }
}
