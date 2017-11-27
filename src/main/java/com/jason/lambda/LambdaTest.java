package com.jason.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaTest {

    private static String StringCompared(String first, String second) {
        return first.length() > second.length() ? first : second;
    }

    private static void filter(List names, Predicate condition) {
        for (Object name : names) {
            if (condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }

    public static void main(String[] args) {

        String first = "first";
        String second = "second";
        System.out.println(StringCompared(first, second));
        new Thread(() -> System.out.println("hello world")).start();

        List features = Arrays.asList("hello", "world");
        features.forEach(System.out::println);
        features.forEach(n -> System.out.println(n));
        filter(features, (feature) -> true);
        filter(features, (feature) -> false);
        features.stream().map(feature -> feature + "test").forEach(System.out::println);

        List costs = Arrays.asList(123, 456, 789);
        System.out.println(costs.stream().filter(cost -> cost.toString().length() > 2).collect(Collectors.toList()));

        List<Integer> prices = Arrays.asList(123, 456, 789);
        System.out.println(prices.stream().filter((price) -> price > 123).reduce((sum, price) -> price + sum).get());
    }
}
