package dotest.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lamda {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
// 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
        squaresList.stream().forEach(System.out::println);
    }
}
