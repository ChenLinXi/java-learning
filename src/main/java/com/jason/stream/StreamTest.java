package com.jason.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        String[] array = {"hello", "world"};

        Stream stream = Stream.of(array);
        System.out.println(stream.collect(Collectors.toList()));
        System.out.println(stream.collect(Collectors.toList()));

//        List<String> stem =  Arrays.stream(array).collect(Collectors.toList());
//        System.out.println(stem);
//
//        System.out.println(stem.stream().filter(s -> "hello".equals(s)).count());
//        System.out.println(stem.stream().filter(s -> "world".equals(s)).count());
    }
}
