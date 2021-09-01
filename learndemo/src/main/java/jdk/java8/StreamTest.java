package jdk.java8;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {

    List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

    @Test
    public void f1(){
        strings.stream().forEach(s -> {
            System.out.println(StringUtils.isBlank(s));
        });
    }

    @Test
    public void map(){
        List<String> collect = strings.stream().filter(StringUtils::isNotBlank).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void coll(){
        Map<String, String> collect = strings.stream().distinct().collect(Collectors.toMap(s -> s, s -> s.toUpperCase()));
        collect.forEach((k,v)-> System.out.println(k+"="+v));
    }
}
