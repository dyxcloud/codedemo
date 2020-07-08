package learn.题目.other;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @author DongYunxiang
 * @create 2020-07-08
 **/
@SuppressWarnings({"NonAsciiCharacters"})
public class 过河问题 {

    /*
     * https://www.jianshu.com/p/49cc1f42c8b9
     * 过河问题:
     * 在漆黑的夜里，甲乙丙丁共四位旅行者来到了一座狭窄而且没有护栏的桥边。
     * 如果不借助手电筒的话，大家是无论如何也不敢过桥的。
     * 不幸的是，四个人一共只带了一只手电筒，而桥窄得只够让两个人同时过。
     * 如果各自单独过桥的话，四人所需要的时间分别是1、2、5、8分钟；
     * 而如果两人同时过桥，所需要的时间就是走得比较慢的那个人单独行动时所需的时间。
     * 问题：如何设计一个方案，让这四人尽快过桥
     * 1+2>2
     * 1
     * 5+8>8
     * 2
     * 1+2>2
     */
    @Test
    public void testfunc() {
        // TestCase.assertEquals(17, func(1, 2, 5, 10));
        // TestCase.assertEquals(15, func(1, 2, 5, 8));
        // TestCase.assertEquals(5, func(1, 1, 1, 1));
        // TestCase.assertEquals(7, func(1, 1, 1, 1, 1));
        TestCase.assertEquals(16, func(1, 2, 2, 10));
    }

    public int func(int... arr) {
        /*
         * 第一次:最快的两个过去
         * 最慢的两个过去
         * 对岸最快的回来
         */
        int result = 0;
        LinkedList<Integer> to = new LinkedList<>();
        LinkedList<Integer> from = Arrays.stream(arr).sorted().boxed().collect(Collectors.toCollection(LinkedList::new));
        System.out.println("from: " + from.hashCode());
        System.out.println("to: " + to.hashCode());
        while (!from.isEmpty()) {
            if (to.isEmpty()) {
                int t1 = trans(from, to, true);
                int t2 = trans(from, to, true);
                result += Math.max(t1, t2);
                if (!from.isEmpty()) {
                    int i = trans(to, from, true);
                    result += i;
                }
                continue;
            }
            if (!from.isEmpty()) {
                int t1 = trans(from, to, false);
                int t2 = trans(from, to, false);
                result += Math.max(t1, t2);
                if (!from.isEmpty()) {
                    int i = trans(to, from, true);
                    result += i;
                }
            }
        }
        return result;
    }

    private int trans(LinkedList<Integer> from, LinkedList<Integer> to, boolean isMin) {
        Integer poll;
        if (isMin) {
            poll = from.pollFirst();
        } else {
            poll = from.pollLast();
        }
        if (poll != null) {
            System.out.println(from.hashCode() + " trans to " + to.hashCode() + "\t" + poll);
            to.offer(poll);
            Collections.sort(from);
            Collections.sort(to);
            return poll;
        } else {
            return 0;
        }
    }

}
