package jdk.thread.pool;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author DongYunxiang
 * @create 2020-12-14
 **/
@SuppressWarnings("NonAsciiCharacters")
public class Callable线程池 {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        int taskSize = 5;
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            int taskNum = i;
            Callable<String> c = () -> {
                System.out.println(">>>" + taskNum + "任务启动");
                Date dateTmp1 = new Date();
                Thread.sleep(1000);
                Date dateTmp2 = new Date();
                long time = dateTmp2.getTime() - dateTmp1.getTime();
                System.out.println(">>>" + taskNum + "任务终止");
                return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
            };
            Future<String> f = pool.submit(c);
            list.add(f);
        }
        pool.shutdown();
        for (Future<String> f : list) {
            System.out.println(">>>" + f.get());
        }
    }
}
