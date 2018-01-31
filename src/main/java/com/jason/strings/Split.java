package com.jason.strings;

import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public class Split {

    public static void main(String[] args) {
        String demo = "hello|world";
//        String[] strings = {};
//        strings = StringUtils.split(demo, "|");
//        System.out.println(strings.length);
//
//        for (int i = 0; i < strings.length; ++i) {
//            System.out.println(strings[i]);
//        }

        List<String> list = Arrays.asList(StringUtils.split(demo, "|"));
        System.out.println(list.size());
        list.forEach(o -> System.out.println(o));
    }
}
