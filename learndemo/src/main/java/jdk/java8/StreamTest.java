package jdk.java8;

import cn.hutool.core.util.StrUtil;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {

    List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

    @Test
    public void f1(){
        strings.forEach(s -> System.out.println(StrUtil.isBlank(s)));
    }

    @Test
    public void map(){
        List<String> collect = strings.stream().filter(StrUtil::isNotBlank).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void coll(){
        Map<String, String> collect = strings.stream().distinct().collect(Collectors.toMap(s -> s, String::toUpperCase));
        collect.forEach((k,v)-> System.out.println(k+"="+v));
    }
}
