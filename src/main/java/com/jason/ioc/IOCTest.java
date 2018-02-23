package com.jason.ioc;

/**
 * 依赖反转原则(很少情况下使用)
 *
 * 里氏代换原则LSP: 子类型必须能够替换掉它们的父类型;
 *
 * 在实现访问mysql数据库的基类后, 高层模块因业务需求需要把数据库类型变更为mongo;
 *
 * 一般来说, 可以新增一个访问mongo的基类, 然后修改高层模块, 使之调用mongo的底层模块;
 *
 * 可以通过模版实现访问不同类型[mysql/mongo]数据库的方法, 然后修改高层模块的调用;
 *
 * 另外一种方式: 针对接口编程;
 *
 * 使 高层模块/底层模块 全部继承于一个通用接口, 好比电脑cpu, 无需关心电脑的型号, 只需设计好cpu的引脚;
 */
public class IOCTest {

    public static void main(String[] args) {
        Man man = new Man("chen");
        man.hello();

        Woman woman = new Woman("meng");
        woman.hello();
    }

    abstract static class Person {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void hello() {

        }
    }

    static class Man extends Person {

        public Man(String name) {
            this.setName(name);
        }

        @Override
        public void hello() {
            System.out.println("Man: " + this.getName());
        }
    }

    static class Woman extends Person {

        public Woman(String name) {
            this.setName(name);
        }

        @Override
        public void hello() {
            System.out.println("Woman: " + this.getName());
        }
    }
}
