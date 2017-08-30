package com.jason.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrivateCarReflectTest {
    public static void main(String[] args) throws Throwable {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.jason.reflect.PrivateCar");

        PrivateCar privateCar = (PrivateCar) clazz.newInstance();
        Field colorFld = clazz.getDeclaredField("color");

        // 取消Java 语言访问检查以访问private变量; 否则抛出 IllegalAccessException
        colorFld.setAccessible(true);
        colorFld.set(privateCar, "Black");

        Method driveMtd = clazz.getDeclaredMethod("drive", (Class[]) null);

        // 取消Java 语言访问检查以访问protected变量
        driveMtd.setAccessible(true);
        driveMtd.invoke(privateCar, (Object[]) null);
    }
}
