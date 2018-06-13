package dotest.thread;

import java.util.concurrent.TimeUnit;

public class TwoThreadLock {

    private static Object lock = new Object();

    public static void main(String[] args) {
        new Thread1("thread1").start();
        new Thread1("thread2").start();
    }

    static class Thread1 extends Thread {
        public Thread1(String name) {
            super(name);
        }
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    try {
                        System.out.println(super.getName());
                        TimeUnit.SECONDS.sleep(1);
                        lock.notify();// 在这里虽然唤醒了另一个线程b，但锁并没有释放
                        lock.wait();// 在wait后的瞬间线程b得到锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}