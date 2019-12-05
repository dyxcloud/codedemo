package jdk.thread;

import java.util.ArrayList;

public class ThreadTest {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    /**
     * volatile无法保证i++的原子性
     */
    public static void main(String[] args) {
        final ThreadTest test = new ThreadTest();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        test.increase();
                }

                ;
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(test.inc);
    }
}
