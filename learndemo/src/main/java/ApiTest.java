import java.io.Serializable;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ApiTest  implements Serializable{


    public static ApiTest instance = new ApiTest();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // List<String> integers = Arrays.asList("1", "2", "3", "4", "5");
        // integers.stream().forEach(System.out::print);
        // System.out.println("------------");
        // integers.stream().unordered().forEach(System.out::print);
        // System.out.println("------------");
        // HashSet<String> set = new HashSet<>(integers);
        // set.stream().forEach(System.out::print);
        // System.out.println("------------");
        // set.stream().unordered().forEach(System.out::print);
        //
        // System.out.println("------------");
        // Stream.of(5, 1, 2, 6, 3, 7, 4).unordered().forEach(System.out::print);
        // System.out.println("------------");
        // Stream.of(5, 1, 2, 6, 3, 7, 4).unordered().parallel().forEach(System.out::print);
        //
        List<Integer> lists = Arrays.asList(1, 2, 3, 4, 5);
        // ForkJoinPool customThreadPool = new ForkJoinPool(4);
        // Integer integer = customThreadPool.submit(
        //         () -> lists.parallelStream().reduce(0, Integer::sum))
        //         .get();
        // System.out.println(integer);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Callable<Integer> c = () -> lists.parallelStream()
                .peek(e-> System.out.println(Thread.currentThread().getName()))
                .reduce(0, Integer::sum);
        Integer integer1 = executorService.submit(
                () -> lists.parallelStream()
                        .peek(e-> System.out.println(Thread.currentThread().getName()))
                        .reduce(0, Integer::sum))
                .get();
        System.out.println(integer1);
        // executorService.shutdown();
    }


}