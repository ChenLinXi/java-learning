package com.jason.template;

public abstract class AbstractClass {

    abstract void PrimitiveOperation();

    public void TemplateMethod() {
        PrimitiveOperation();
        System.out.println("");
    }
}
