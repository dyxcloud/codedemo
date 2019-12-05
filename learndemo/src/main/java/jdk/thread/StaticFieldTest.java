package jdk.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class StaticFieldTest {

    static int n = 0; // 目标变量

    public static void main(String[] args) throws InterruptedException {
        int times = 50;// 线程数
        CountDownLatch latch = new CountDownLatch(times);
        ReentrantLock lock = new ReentrantLock();

        Runnable r = () -> {
            for (int i = 0; i < 100; i++) {
//                lock.lock();
                try {
                    n++;
                } finally {
//                    lock.unlock();
                }
            }
            latch.countDown();
        };
        for (int i = 0; i < times; i++) {
            new Thread(r).start();
        }
        latch.await();
        System.out.println(n);
    }
}
