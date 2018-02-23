package com.jason.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    public static void main(String[] args) {

        // java -XX:+PrintFlagsFinal -version | grep HeapSize
        // java jvm heap default size is 2147483648 Bytes, almost 2 GB

        List<Long> list = new ArrayList<>();
        for (Long i = 0L; i < 10000000000L; i++) {
            list.add(i);
//            try {
//                list.add(i);
//            } catch (Exception ex) {
//
//                System.out.println(ex.getMessage());
//                System.out.println(i);
//                return;
//            }
        }
    }
}
