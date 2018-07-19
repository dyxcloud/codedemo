package dotest.thread;

import java.util.concurrent.TimeUnit;

public class TwoThreadLockByObject {

    public static void main(String[] args) {
        Object lock = new Object();
        Runnable runnable = () -> {
            while (true) {
                synchronized (lock) {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(1);
                        lock.notify();// 唤醒了正在等待lock的另一个线程b，但lock并没有释放
                        lock.wait();// 主动等待, 释放了lock, 线程b得到了lock
                        // do something 重新获取锁之后继续执行同步块内的代码
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(runnable, "thread1").start();
        new Thread(runnable, "thread2").start();
    }
}