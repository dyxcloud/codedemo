package jdk.thread.deadLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSleepDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Thread0 t1 = new Thread0("t1", lock);
        Thread0 t2 = new Thread0("t2", lock);

        t1.start();
        t2.start();
    }

}

class Thread0 extends Thread {
    Lock lock;

    public Thread0(String name, Lock lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        runTest(this.lock);
    }

    public void runTest(Lock lock) {
        System.out.println(this.getName() + "start..");
        lock.lock();
        System.out.println(this.getName() + "run..");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        System.out.println(this.getName() + "end..");
    }

}
