package com.jason.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {

        RealSubject realSubject = new RealSubject();
        Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(), new Class[]{Subject.class}, new ProxyHandler(realSubject));
        proxySubject.doSomething();
        createProxyClassFile();
    }

    public static void createProxyClassFile() {
        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{Subject.class});
        try {
            FileOutputStream outputStream = new FileOutputStream(name + ".class");
            outputStream.write(data);
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
