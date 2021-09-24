package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L152乘积最大子数组 {
    /*
DP
已i开头的子数组最大乘积

     */

    public int maxProduct(int[] nums) {
        return 0;
    }

    private int maxFixEnd(int[] nums, int start, int end) {
        if (start > end) return 0;
        if (start == end) return nums[start];
        int pre = maxFixEnd(nums, start, end - 1);
        Math.max(pre,pre*nums[end]);
        return 0;
    }

    @Test
    public void tt() {
        ToIntFunction<int[]> func = this::maxProduct;
        Assertions.assertEquals(6, func.applyAsInt(new int[]{2, 3, -2, 4}));
        Assertions.assertEquals(0, func.applyAsInt(new int[]{-2, 0, -1}));
    }
}
