package com.jason.methodInvoke.entity;

public class Person {

    private int age;

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{"
            + "\"age\":\"" + age + "\""
            + "}";
    }
}
