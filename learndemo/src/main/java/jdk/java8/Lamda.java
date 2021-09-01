package jdk.java8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lamda {

    /**
     * 二元算子函数
     */
    interface MathOperation {
        int operation(int a, int b);
    }

    /**
     * 函数式接口
     */
    interface GreetingService {
        void sayMessage(String message);
    }


    @Test
    public void listForeach() {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        squaresList.stream().forEach(System.out::println);
    }

    @Test
    public void lamda() {
        MathOperation add = (a, b) -> a + b;
        System.out.println(add.operation(1, 2));

        MathOperation op2 = (c, b) -> c * b;
        System.out.println(op2.operation(2,3));

        GreetingService hello = msg -> System.out.println("你好, "+msg);
        hello.sayMessage("张三");
        GreetingService print = System.out::print;
        print.sayMessage("李四");
    }

    String[] cars = {"轿车", "客车", "火车","跑车"};


    @Test
    public void ref(){
        List<String> carList = Arrays.asList(cars);
        carList.forEach(System.out::println);

        Function<Integer,int[]> aNew = int[]::new;
        int[] ints = aNew.apply(12);
        System.out.println(ints.length);



    }
}
