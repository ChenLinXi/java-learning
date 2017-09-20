package com.jason.zookeeper.Curator;

import org.apache.curator.framework.CuratorFramework;

public interface LockZookeeperClient {

    CuratorFramework getCuratorFramework();

    String getBasePath();

    void gc(String gcPath);
}
