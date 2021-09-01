package jdk.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFutureTest {
    
    @Test
    public void tt() throws InterruptedException, ExecutionException {
        Supplier<String> task = ()-> {
            System.out.println("开启执行任务");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException ignored) {}
            return "Hello World";
        };
        CompletableFuture<String> future = CompletableFuture.supplyAsync(task);
        TimeUnit.SECONDS.sleep(3);
        System.out.println(future.get());
    }
}
