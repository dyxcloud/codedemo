package dotest.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author DongYunxiang
 * @create 2019-05-28
 **/
public class LoopAndPool {

    private static final int loopNum = 10;

    public static void main(String args[]) throws InterruptedException {
        LoopAndPool TestThreadPool = new LoopAndPool();
        long bt = System.currentTimeMillis();
        TestThreadPool.m1();
        long et2 = System.currentTimeMillis();
        System.out.println("[1]耗时:" + (et2 - bt) + "ms");
        long at = System.currentTimeMillis();
        TestThreadPool.m2();
        long et3 = System.currentTimeMillis();
        System.out.println("[2]耗时:" + (et3 - at) + "ms");

    }

    private void m1() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        class Run implements Runnable {
            private int n;
            private Run(int n) {
                this.n = n;
            }
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);  //模拟耗时操作
                    System.out.println("[1]" + Thread.currentThread().getName() + "runNumber[" + n + "]");
                } catch (Exception ignored) {
                }
            }
        }
        IntStream.range(0, loopNum).forEach(n -> pool.execute(new Run(n)));
        pool.shutdown();
        pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES);
        System.out.println("[1] done!");
    }

    private void m2() {
        IntStream.range(0, loopNum).forEach(n -> {
            try {
                Thread.sleep(1000);  //模拟耗时操作
                System.out.println("[2]" + Thread.currentThread().getName());
            } catch (Exception ignored) {
            }
        });
        System.out.println("[2] done!");
    }
}
