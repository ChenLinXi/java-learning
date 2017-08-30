package com.jason.classloader;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();

        // 1. AppClassLoader: 装载ClassPath路径下的类包  sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println("current loader:" + loader);

        // 2. ExtClassLoader: 装载JRE扩展目录ext中的JAR类包  sun.misc.Launcher$ExtClassLoader@610455d6
        System.out.println("parent loader:" + loader.getParent());

        // 3. RootClassLoader: 装载JRE的核心类库 rt.jar、charsets.jar
        // 根装载器在Java中访问不到，所以返回null
        System.out.println("grandparent loader:" + loader.getParent().getParent());
    }
}
