package learn.题目.other;

import junit.framework.TestCase;
import org.junit.Test;

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
        TestCase.assertEquals(17, func(1, 2, 5, 10));
    }

    public int func(int... arr) {
        /*
         * 第一次:最快的两个过去
         * 最慢的两个过去
         * 对岸最快的回来
         */
        return 0;
    }

}
