package com.jason.lock;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ReentrantLock implements Lock, java.io.Serializable {

    private static final long serialVersionUID = 7373984872572414699L;

    /**
     * Synchronizer 提供了锁的所有基本功能的实现
     */
    private final Sync sync;

    /**
     * 基于 Synchronizer对锁的控制， ReentrantLock提供了两种模式的类型
     * 以AQS state表示ReentrackLock的使用状态
     */
    abstract static class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = -5179523762034025860L;

        abstract void lock();

        /**
         * 不公平互斥请求
         */
        final boolean nonfairTryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
            if (c == 0) {
                /**
                 * 锁未被占用，设置锁为当前线程使用
                 */
                if (compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            } else if (current == getExclusiveOwnerThread()) {
                int nextc = c + acquires;
                if (nextc < 0)
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;
            }
            return false;
        }

        /**
         * 释放锁资源
         */
        protected final boolean tryRelease(int releases) {
            int c = getState() - releases;
            if (Thread.currentThread() != getExclusiveOwnerThread())
                throw new IllegalMonitorStateException();
            boolean free = false;
            if (c == 0) {
                free = true;
                setExclusiveOwnerThread(null);
            }
            setState(c);
            return free;
        }

        /**
         * 检查互斥锁是否被当前线程占用
         */
        protected final boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        /**
         * 记录锁的状态：锁定／未锁定／等待... ...
         */
        final ConditionObject newCondition() {
            return new ConditionObject();
        }

        /**
         * 获得使用锁的当前线程
         */
        final Thread getOwner() {
            return getState() == 0 ? null : getExclusiveOwnerThread();
        }

        /**
         * 获取当前队列的请求线程数
         */
        final int getHoldCount() {
            return isHeldExclusively() ? getState() : 0;
        }

        /**
         * 检查互斥锁是否被线程占用
         */
        final boolean isLocked() {
            return getState() != 0;
        }
    }

    /**
     * 不公平互斥锁实现
     */
    static final class NonfairSync extends Sync {
        private static final long serialVersionUID = 7316153563782823691L;


        final void lock() {
            /**
             * 如果当前互斥锁未被占用，将互斥锁权限交给当前线程
             */
            if (compareAndSetState(0, 1))
                setExclusiveOwnerThread(Thread.currentThread());
            /**
             * 互斥锁被使用，请求失败
             */
            else
                acquire(1);
        }

        protected final boolean tryAcquire(int acquires) {
            return nonfairTryAcquire(acquires);
        }
    }


    /**
     * 公平互斥锁实现
     */
    static final class FairSync extends Sync {
        private static final long serialVersionUID = -3000897897090466540L;

        final void lock() {
            acquire(1);
        }

        /**
         * 请求互斥锁资源
         * 不支持递归调用
         */
        protected final boolean tryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
            if (c == 0) {
                if (!hasQueuedPredecessors() &&
                        compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            } else if (current == getExclusiveOwnerThread()) {
                int nextc = c + acquires;
                if (nextc < 0)
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;
            }
            return false;
        }
    }


    /**
     * 构造函数
     */
    public ReentrantLock() {
        sync = new NonfairSync();
    }

    /**
     * 构造函数
     */
    public ReentrantLock(boolean fair) {
        sync = fair ? new FairSync() : new NonfairSync();
    }

    /**
     * 释放互斥锁
     * <p>
     * 1. 如果是当前占有互斥锁的线程释放，立刻返回并将阻塞队列的数目减1
     * <p>
     * 2. 如果当前互斥锁被其他线程占用，当前请求无效，直到被其他线程释放
     */
    public void lock() {
        sync.lock();
    }

    /**
     * 锁定中断
     */
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    /**
     * 锁定
     */
    public boolean tryLock() {
        return sync.nonfairTryAcquire(1);
    }

    /**
     * 延时锁定
     */
    public boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(timeout));
    }

    /**
     * 解锁
     */
    public void unlock() {
        sync.release(1);
    }

    /**
     * 互斥锁状态
     */
    public Condition newCondition() {
        return sync.newCondition();
    }

    /**
     * 获取互斥锁当前的等待线程总数
     */
    public int getHoldCount() {
        return sync.getHoldCount();
    }

    public boolean isHeldByCurrentThread() {
        return sync.isHeldExclusively();
    }

    public boolean isLocked() {
        return sync.isLocked();
    }

    public final boolean isFair() {
        return sync instanceof FairSync;
    }

    public final boolean hasQueuedThreads() {
        return sync.hasQueuedThreads();
    }

    public final boolean hasQueuedThread(Thread thread) {
        return sync.isQueued(thread);
    }

    public final int getQueueLength() {
        return sync.getQueueLength();
    }

    protected Collection<Thread> getQueuedThreads() {
        return sync.getQueuedThreads();
    }

    public boolean hasWaiters(Condition condition) {
        if (condition == null)
            throw new NullPointerException();
        if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            throw new IllegalArgumentException("not owner");
        return sync.hasWaiters((AbstractQueuedSynchronizer.ConditionObject) condition);
    }

    public int getWaitQueueLength(Condition condition) {
        if (condition == null)
            throw new NullPointerException();
        if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            throw new IllegalArgumentException("not owner");
        return sync.getWaitQueueLength((AbstractQueuedSynchronizer.ConditionObject) condition);
    }

    protected Collection<Thread> getWaitingThreads(Condition condition) {
        if (condition == null)
            throw new NullPointerException();
        if (!(condition instanceof AbstractQueuedSynchronizer.ConditionObject))
            throw new IllegalArgumentException("not owner");
        return sync.getWaitingThreads((AbstractQueuedSynchronizer.ConditionObject) condition);
    }

    public String toString() {
        Thread o = sync.getOwner();
        return super.toString() + ((o == null) ?
                "[Unlocked]" :
                "[Locked by thread " + o.getName() + "]");
    }

}
