package dotest.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @title 两个线程依次交替执行
 * @description 假定两个线程分别为红灯、绿灯，执行的期待结果为：红-绿-红-绿-红-绿...
 */
public class TwoThreadLock2 {

    private int tnum = 1;// 线程编号,Thread Number

    private ReentrantLock lock = new ReentrantLock();

    private Condition redCon = lock.newCondition();
    private Condition greenCon = lock.newCondition();

    public void run() {
        new Thread(new LightThread(1, redCon, greenCon), "red light").start();
        new Thread(new LightThread(-1, greenCon, redCon), "green light").start();
    }

    public static void main(String[] args) {
        new TwoThreadLock2().run();
    }

    class LightThread implements Runnable {
        private int stat;
        private Condition myCon;
        private Condition otherCon;

        public LightThread(int stat, Condition myCon, Condition otherCon) {
            this.stat = stat;
            this.myCon = myCon;
            this.otherCon = otherCon;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    // 判断是否该自己执行了[采用while不是if是为了防止死锁]
                    while (tnum != stat)
                        myCon.await();
                    System.out.println(Thread.currentThread().getName() + " is flashing...");
                    TimeUnit.SECONDS.sleep(1);// 停留时间，便于从控制台观看
                    tnum = stat * -1;// mian状态转换为另一条线程
                    otherCon.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

}
