package com.jason.executor;

import java.util.Timer;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Executors / Executor / ExecutorService 区别
 *
 * Executor 是接口, 提供execute方法;
 *
 * ExecutorService 是继承与Executor的接口, 提供了一系列的管理线程池的方法;
 *
 * Executors是静态方法, 创建线程池, 返回 ExecutorService 实例对象;
 *
 * ExecutorService.execute(new Thread()), ExecutorService.submit(new Thread() / new Callable()) 并返回Future对象;
 */
public class ExecutorTest {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("ExecutorService: hello world!");
            }
        });
        // Future
        System.out.println(future.isDone());
        executorService.shutdown();

        // callable
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return "Callable: hello world!";
            }
        };
        System.out.println(callable.call());

        // runnable
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable: hello world!");
            }
        };
        runnable.run();
    }
}
