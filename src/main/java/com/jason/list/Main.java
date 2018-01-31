package com.jason.list;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String name = "1234";
        List<String> names = Arrays.asList(name.split(","));
        System.out.println(names.get(0));
    }
}
