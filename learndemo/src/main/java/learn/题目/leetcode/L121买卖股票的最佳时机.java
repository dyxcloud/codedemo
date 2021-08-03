package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.function.ToIntFunction;
import java.util.stream.Stream;

/**
 * @author DongYunxiang
 * @create 2021-04-27
 **/
public class L121买卖股票的最佳时机 {

    /**
     * 纯暴力法
     */
    public int maxProfit00(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int tmp = prices[j] - prices[i];
                if (tmp > result) {
                    result = tmp;
                }
            }
        }
        return result;
    }

    
    /**
     * 暴力分析法, 先获取最大值和最小值
     * 判断两个值的先后顺序, 如果先小后大就直接返回
     * 如果先大后小, 就分别求以极值分隔的三段数组的result,并进行比较
     */
    public int maxProfit0(int[] prices) {
        return maxProfit0Helper(prices, 0, prices.length - 1);
    }
    public int maxProfit0Helper(int[] prices, int start, int end) {
        if (end - start < 1) {
            return 0;
        }
        int maxp = start, maxv = prices[start], minp = start, minv = prices[start];
        for (int i = 1; i <= end; i++) {
            if (maxv < prices[i]) {
                maxv = prices[i];
                maxp = i;
            }
            if (minv > prices[i]) {
                minv = prices[i];
                minp = i;
            }
        }
        if (maxp > minp) {
            return maxv - minv;
        } else if (minp > maxp) {
            int midR = maxProfit0Helper(prices, maxp + 1, minp - 1);
            int leftR = 0, rightR = 0;
            for (int i = start; i < maxp; i++) {
                if (prices[i] < maxv) {
                    leftR = Math.max(leftR, maxv - prices[i]);
                }
            }
            for (int i = minp + 1; i <= end; i++) {
                if (prices[i] > minv) {
                    rightR = Math.max(rightR, prices[i] - minv);
                }
            }
            return Stream.of(midR, leftR, rightR).max(Integer::compareTo).orElse(0);
        } else {
            return 0;
        }
    }


    @Test
    public void tt() {
        ToIntFunction<int[]> f = this::maxProfit0;
        TestCase.assertEquals(5, f.applyAsInt(new int[]{7, 1, 5, 3, 6, 4}));
        TestCase.assertEquals(0, f.applyAsInt(new int[]{7, 6, 4, 3, 1}));
        TestCase.assertEquals(0, f.applyAsInt(new int[]{}));
    }
}
