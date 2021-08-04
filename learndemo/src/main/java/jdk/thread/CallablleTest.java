package jdk.thread;

import org.junit.Test;

import java.util.concurrent.*;

public class CallablleTest {

    Callable<Integer> task = () -> {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++)
            sum += i;
        return sum;
    };

    @Test
    public void thread() throws InterruptedException, ExecutionException {
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("主线程正在运行");
        TimeUnit.SECONDS.sleep(1);
        int time = 10;
        //callable执行完线程就停止了, 不会等待get
        while (time > 0) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(thread.getState());
            time--;
        }
        System.out.println("获取到子线程运行的结果: " + futureTask.get());
        System.out.println("所有任务执行完毕");
        System.out.println(thread.getState());
    }

    @Test
    public void future() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<Integer> result = executorService.submit(task);
        System.out.println("主线程正在运行");
        TimeUnit.SECONDS.sleep(1);
        int time = 10;
        while (time > 0) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(((ThreadPoolExecutor) executorService).getActiveCount());
            time--;
        }
        System.out.println("获取到子线程运行的结果: " + result.get());
        System.out.println("所有任务执行完毕");
        System.out.println(((ThreadPoolExecutor) executorService).getActiveCount());
    }

    @Test
    public void futureTask() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        FutureTask<Integer> futureTask = new FutureTask<>(task);
        executorService.submit(futureTask);
        System.out.println("主线程正在运行");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("获取到子线程运行的结果: " + futureTask.get());
        System.out.println("所有任务执行完毕");
    }

}
