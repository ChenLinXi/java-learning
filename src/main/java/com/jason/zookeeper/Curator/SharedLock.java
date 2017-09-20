package com.jason.zookeeper.Curator;

import org.apache.commons.lang.StringUtils;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;

import java.util.concurrent.TimeUnit;

public class SharedLock {

    private InterProcessLock interProcessLock;

    public SharedLock(LockZookeeperClient lockZookeeperClient, String resourceId) {
        super();

        if (StringUtils.isBlank(resourceId)) {
            throw new NullPointerException("resourceId");
        }
        String path = lockZookeeperClient.getBasePath();
        path += ("/" + resourceId.trim());

        interProcessLock = new InterProcessMutex(lockZookeeperClient.getCuratorFramework(), path);
        lockZookeeperClient.gc(path);
    }

    /**
     * Acquire the mutex - blocking until it's available. Each call to acquire must be balanced by a call
     * to {@link #release()}
     *
     * @throws Exception ZK errors, connection interruptions
     */
    public void acquire() throws Exception {
        interProcessLock.acquire();
    }

    public boolean acquire(long time, TimeUnit unit) throws Exception {
        return interProcessLock.acquire(time, unit);
    }

    /**
     * Perform one release of the mutex.
     *
     * @throws Exception ZK errors, interruptions, current thread does not own the lock
     */
    public void release() throws Exception {
        interProcessLock.release();
    }

    /**
     * Returns true if the mutex is acquired by a thread in this JVM
     *
     * @return true/false
     */
    public boolean isAcquiredInThisProcess() {
        return interProcessLock.isAcquiredInThisProcess();
    }
}
