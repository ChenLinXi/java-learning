package com.jason.methodInvoke.entity;

public class Adult extends Person implements Comparable<Adult> {

    private String name;

    public Adult() {
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
    public int compareTo(Adult o) {
        return super.getAge() - o.getAge();
    }
}
