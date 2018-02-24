package com.jason.map.concurrent;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This is a test of iteration
 */
public class ConcurrentHashMapTest {

    public static void main(String[] args) {

        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("first name", "meng");
        map.put("second name", "chen");

        // printing all keys of ConcurrentHashMap
        System.out.println("All keys of ConcurrentHashMap");
        for (String key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }

        // printing all keys and values pairs of ConcurrentHashMap
        System.out.println("Printing all keys and values of ConcurrentHashMap");
        for (Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key: " + key + " value: " + value);
        }

        // you can also use Iterator with EntrySet as shown below
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key: " + key + " value: " + value);
        }
    }
}
