package com.jason.zookeeper.Curator;

import com.jason.zookeeper.Curator.impl.LockZookeeperClientFactory;

import java.util.concurrent.TimeUnit;

public class Demo {

    /**
     * 实现zookeeper共享锁步骤：
     * 1)继承于Curator 实现lockZookeeperClient接口
     * 2)实现lockZookeeperClientFactory, 继承并CuratorFramework的接口
     * 3)创建定时任务
     * 4)查询zookeeper目录及其子目录
     * 5)执行定时任务
     * @param args
     */
    public static void main(String[] args) {
        LockZookeeperClientFactory lockZookeeperClientFactory = new LockZookeeperClientFactory();
        lockZookeeperClientFactory.setZookeeperIpPort("127.0.0.1:8900");
        lockZookeeperClientFactory.setBasePath("/locks/sharedLock/");
        lockZookeeperClientFactory.init();

        SharedLock sharedLock = new SharedLock(lockZookeeperClientFactory, "sharedLock1");
        try {
            if (sharedLock.acquire(100, TimeUnit.MILLISECONDS)) {
                System.out.println("sharedLock1 get");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                sharedLock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        lockZookeeperClientFactory.destroy();
    }
}

