package jdk.thread.pool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author DongYunxiang
 * @create 2020-03-18
 **/
public class 线程池销毁测试 {

    public static void main(String[] args) throws Exception {
        // poolrun();
        List<Integer> lists = Arrays.asList(1, 2, 3, 4, 5);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Integer integer1 = executorService.submit(
                () -> lists.parallelStream().reduce(0, Integer::sum))
                .get();
        System.out.println(integer1);
        TimeUnit.SECONDS.sleep(10);
        System.out.println("qqqq");
        // System.gc();
        TimeUnit.SECONDS.sleep(999);
    }

    public static void poolrun() throws Exception {
        List<Integer> lists = Arrays.asList(1, 2, 3, 4, 5);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Integer integer1 = executorService.submit(
                () -> lists.parallelStream().reduce(0, Integer::sum))
                .get();
        System.out.println(integer1);
        // executorService.shutdown();
    }
}
