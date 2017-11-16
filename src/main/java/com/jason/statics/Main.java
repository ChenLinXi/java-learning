package com.jason.statics;

public class Main {

    public static void main(String[] args) {
        StaticClass staticClass = new StaticClass();
        System.out.println(staticClass.getAge());


        System.out.println(StaticClass.getName());


//        System.out.println(staticClass.getAge());
    }
}
