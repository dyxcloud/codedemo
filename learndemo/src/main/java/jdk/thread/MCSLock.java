package jdk.thread;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author DongYunxiang
 * @create 2020-12-10
 **/
public class MCSLock {
    public static class MCSNode {
        volatile MCSNode next;
        volatile boolean isBlock = true; // 默认是在等待锁
    }
    private ThreadLocal<MCSNode> LOCAL = ThreadLocal.withInitial(MCSNode::new);
    volatile MCSNode queue;// 指向最后一个申请锁的MCSNode
    private static final AtomicReferenceFieldUpdater<MCSLock, MCSNode> UPDATER = AtomicReferenceFieldUpdater.newUpdater(MCSLock.class, MCSNode.class, "queue");

    public void lock() {
        MCSNode cNode = LOCAL.get();
        // 将当前申请锁的线程置为queue并返回旧值
        MCSNode predecessor = UPDATER.getAndSet(this, cNode); // step 1
        if (predecessor != null) {
            // 形成链表结构(单向)
            predecessor.next = cNode; // step 2
            // 当前线程处于等待状态时自旋(MCSNode的isBlock初始化为true)
            // 等待前驱节点主动通知，即将isBlock设置为false，表示当前线程可以获取到锁
            for (; cNode.isBlock; ) ;
        } else {
            // 只有一个线程在使用锁，没有前驱来通知它，所以得自己标记自己为非阻塞 - 表示已经加锁成功
            cNode.isBlock = false;
        }
    }

    public void unlock() {
        MCSNode cNode = LOCAL.get();
        if (cNode.isBlock) {
            return;// 锁拥有者进行释放锁才有意义
        }
        if (cNode.next == null && !UPDATER.compareAndSet(this, cNode, null)) {
            // 没有后继节点的情况，将queue置为空
            // 如果CAS操作失败了表示突然有节点排在自己后面了，可能还不知道是谁，下面是等待后续者
            // 这里之所以要忙等是因为上述的lock操作中step 1执行完后，step 2可能还没执行完
            for (; cNode.next == null; ) ;
        }
        if (cNode.next != null) {
            cNode.next.isBlock = false;// 通知后继节点可以获取锁
            cNode.next = null;// 将当前节点从链表中断开，方便对当前节点进行GC
        }
        LOCAL.remove();// 清空当前线程对应的节点信息
    }

    public static void main(String[] args) throws InterruptedException {
        final MCSLock lock = new MCSLock();
        for (int i = 1; i <= 10; i++) {
            String name = String.valueOf(i);
            new Thread(() -> {
                lock.lock();
                try {
                    Thread.sleep(3000);
                } catch (Exception ignored) {
                }
                System.out.println("Thread " + Thread.currentThread().getName() + " Completed");
                lock.unlock();
            }, name).start();
            Thread.sleep(500);
        }
    }
}
