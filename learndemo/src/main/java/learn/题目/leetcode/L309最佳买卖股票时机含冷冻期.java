package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

/**
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 */
@SuppressWarnings("NonAsciiCharacters")
public class L309最佳买卖股票时机含冷冻期 {
    
    /*
DP:
f(l,r) = max{f(l,m-1)+f{m+1,r}} m=l+2,l+3...r-2

     */

    Integer[][] cache;
    Integer[][] buyOnceCache;

    public int maxProfit(int[] prices) {
        cache = new Integer[prices.length][prices.length];
        buyOnceCache = new Integer[prices.length][prices.length];
        return helper(prices, 0, prices.length - 1);
    }

    /**
     * 计算区间内最优解, 比较不含冷冻期与含冷冻期时的值
     */
    private int helper(int[] prices, int l, int r) {
        if (r - l < 1) return 0;
        if (cache[l][r] != null) return cache[l][r];
        int max = helperBuyOnce(prices, l, r);
        for (int m = l + 2; m <= r - 2; m++) {
            int r1 = helper(prices, l, m - 1);
            int r2 = helper(prices, m + 1, r);
            max = Math.max(max, r1 + r2);
        }
        cache[l][r] = max;
        return max;
    }

    /**
     * 计算区间内不含冷冻期的最优解
     */
    private int helperBuyOnce(int[] prices, int l, int r) {
        if (r - l < 1) return 0;
        if (buyOnceCache[l][r] != null) return buyOnceCache[l][r];
        int min = prices[l], minIndex = l, max = 0, maxStartIndex = l;
        for (int i = l + 1; i <= r; i++) {
            int tt = prices[i] - min;
            if (max < tt) {
                max = tt;
                maxStartIndex = minIndex;
            }
            if (min > prices[i]) {
                min = prices[i];
                minIndex = i;
            }
            for (int t = l; t <= maxStartIndex; t++) {
                buyOnceCache[t][i] = max;
            }
        }
        return max;
    }

    @Test
    public void tt() {
        ToIntFunction<int[]> func = this::maxProfit;
        Assertions.assertEquals(3, func.applyAsInt(new int[]{1, 2, 3, 0, 2}));
        Assertions.assertEquals(98, func.applyAsInt(new int[]{1, 2, 99, 0, 2}));
        Assertions.assertEquals(110, func.applyAsInt(new int[]{1, 2, 99, 0, 2, 7, 5, 4, 3, 1, 3, 4, 5, 6, 8}));
    }
}
