package dotest.thread;

import org.junit.Test;

import java.util.concurrent.*;

public class CallablleTest {

    @Test
    public void future() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable<Integer> task = new Task();

        Future<Integer> result = executorService.submit(task);
        executorService.shutdown();

        System.out.println("主线程正在运行");
        TimeUnit.SECONDS.sleep(1);
        try {
            System.out.println("获取到子线程运行的结果: " + result.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
    }

    @Test
    public void futureTask() throws InterruptedException {
        Callable<Integer> task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<>(task);

        // 方式一
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        executorService.submit(futureTask);
//        executorService.shutdown();

        // 方式二
        new Thread(futureTask).start();

        System.out.println("主线程正在运行");
        TimeUnit.SECONDS.sleep(1);
        try {
            System.out.println("获取到子线程运行的结果: " + futureTask.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("所有任务执行完毕");
    }

    public static void main(String[] args) {

    }
}

class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for (int i = 0; i < 100; i++)
            sum += i;
        return sum;
    }
}
