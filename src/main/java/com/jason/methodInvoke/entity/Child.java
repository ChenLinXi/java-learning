package com.jason.methodInvoke.entity;

public class Child extends Person implements Comparable<Child> {

    private String name;

    public Child() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void introduce() {
        System.out.println("i am " + name + " and i am " + super.getAge() + " years old");
    }

    @Override
    public String toString() {
        return "{"
            + "\"name\":\"" + name + "\""
            + "}";
    }

    @Override
    public int compareTo(Child o) {
        return super.getAge() - o.getAge();
    }
}
