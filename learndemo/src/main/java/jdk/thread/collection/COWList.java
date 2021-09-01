package jdk.thread.collection;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author DongYunxiang
 * @create 2019-06-03
 **/
public class COWList {

    private CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();


    @Test
    public void testRun() throws InterruptedException {
        Runnable r = () -> IntStream.range(0,5000).forEach(n-> list.add(""));
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(r);
        pool.execute(r);
        pool.shutdown();
        pool.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
        System.out.println(list.size());
    }
}
