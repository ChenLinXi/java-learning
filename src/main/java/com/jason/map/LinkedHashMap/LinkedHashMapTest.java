package com.jason.map.LinkedHashMap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap(4);

        linkedHashMap.put("1", "1");
        linkedHashMap.put("2", "2");
        linkedHashMap.put("3", "3");
        linkedHashMap.put("4", "4");

        // map中实体对象集合
        Set<Map.Entry<String, String>> entrySet = linkedHashMap.entrySet();
        // map中实体对象集合迭代器
        Iterator<Map.Entry<String, String>> entryIterator = entrySet.iterator();

        while (entryIterator.hasNext()) {
            Map.Entry<String, String> entry = entryIterator.next();

            boolean flag = entryIterator.hasNext();
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue() + ", hasNext: " + flag);
        }
    }
}
