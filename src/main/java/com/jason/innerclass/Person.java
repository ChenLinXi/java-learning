package com.jason.innerclass;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void print() {
        Decorator decorator = new Decorator();
        decorator.decorate();
    }

    public class Decorator {

//        private String name;
//        private int age;
//
//        public Decorator(String name, int age) {
//            this.name = name;
//            this.age = age;
//        }

        public void decorate() {
            System.out.println("hello " + name + " and you are " + age + " years old");
        }
    }
}
