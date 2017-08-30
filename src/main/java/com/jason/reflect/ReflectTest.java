package com.jason.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {

    public static Car initByDefaultConst() throws Throwable {

        // 通过类加载器获取Car类对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Class clazz = loader.loadClass("com.jason.reflect");

        // 获取类的默认构造器对象并通过它实例化Car
        Constructor cons = clazz.getDeclaredConstructor((Class[]) null);
        Car car = (Car) cons.newInstance();

        // 通过反射方法设置属性、invoke方法调用目标类的方法
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "Benz");

        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "Black");

        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 280);

        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
    }
}
