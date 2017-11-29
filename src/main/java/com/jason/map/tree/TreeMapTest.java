package com.jason.map.tree;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

    public static void main(String[] args) {

        // TreeMap会按照Key字典生序排列
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("a", "a");
        treeMap.put("b", "b");
        treeMap.put("ab", "ab");
        treeMap.put("ba", "ba");

        Set<Map.Entry<String, String>> entrySet = treeMap.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();

            System.out.println("key: " + entry.getKey() + " , value: " + entry.getValue());
        }
    }
}
