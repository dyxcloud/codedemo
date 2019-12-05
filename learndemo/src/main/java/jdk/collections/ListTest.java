package jdk.collections;

import java.util.Arrays;
import java.util.List;

/**
 * @author DongYunxiang
 * @create 2018-08-27
 **/
public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{1, 23, 4, 56});
        System.out.println(list.indexOf(null));
    }
}
