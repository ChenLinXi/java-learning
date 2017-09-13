package com.jason.synchronizer;

/**
 * 虚类线程同步器
 */
public abstract class AbstractOwnableSynchronizer implements java.io.Serializable {

    private static final long serialVersionUID = 3737899427754241961L;

    /**
     * 提供给子类使用的默认构造器
     */
    protected AbstractOwnableSynchronizer() {
    }

    /**
     * 同步器
     */
    private transient Thread exclusiveOwnerThread;

    protected final void setExclusiveOwnerThread(Thread thread) {
        exclusiveOwnerThread = thread;
    }

    protected final Thread getExclusiveOwnerThread() {
        return exclusiveOwnerThread;
    }
}
