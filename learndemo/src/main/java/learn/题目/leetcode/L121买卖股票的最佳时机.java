package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.function.ToIntFunction;

/**
 * @author DongYunxiang
 * @create 2021-04-27
 **/
public class L121买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        return 0;
    }

    @Test
    public void tt() {
        ToIntFunction<int[]> f = this::maxProfit;
        TestCase.assertEquals(5, f.applyAsInt(new int[]{7, 1, 5, 3, 6, 4}));
        TestCase.assertEquals(0, f.applyAsInt(new int[]{7, 6, 4, 3, 1}));
        TestCase.assertEquals(0, f.applyAsInt(new int[]{}));
    }
}
