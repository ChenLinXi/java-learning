package com.jason.statics;

public class StaticClass {

    static {
        // java1.6 and above
        System.out.println("hello world!");
        name = "chenmeng";
    }

    private static String name;

    private String age;

    {
        age = "12";
    }

    public static String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
