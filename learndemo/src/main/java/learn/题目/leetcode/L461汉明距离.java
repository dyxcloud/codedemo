package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.function.BiFunction;

/**
 * @author DongYunxiang
 * @create 2021-05-13
 **/
public class L461汉明距离 {

    public int hammingDistance(int x, int y) {
        int sum = x ^ y;
        int result = 0;
        while (sum != 0) {
            result++;
            //把这个1置零
            sum = sum & (sum - 1);
        }
        return result;
    }

    @Test
    public void tt() {
        BiFunction<Integer, Integer, Integer> f = this::hammingDistance;
        TestCase.assertEquals(2, (int) f.apply(1, 4));
    }
}
