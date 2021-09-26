package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L152乘积最大子数组 {

    /**
     * 遍历以第一位,第二位...最后一位结尾的子串的最大乘积(正/负)
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = nums[0];
        int[] pre;//[正数最大值, 负数最大值]
        if (nums[0] > 0) {
            pre = new int[]{nums[0], 0};
        } else {
            pre = new int[]{0, nums[0]};
        }
        for (int end = 1; end < nums.length; end++) {
            int p0, p1;
            if (nums[end] >= 0) {
                p0 = Math.max(nums[end], pre[0] * nums[end]);
                p1 = Math.min(0, pre[1] * nums[end]);
            } else {
                p0 = Math.max(0, pre[1] * nums[end]);
                p1 = Math.min(nums[end], pre[0] * nums[end]);
            }
            pre[0] = p0;
            pre[1] = p1;
            max = Math.max(pre[0], max);
        }
        return max;
    }

    @Test
    public void tt() {
        ToIntFunction<int[]> func = this::maxProduct;
        Assertions.assertEquals(6, func.applyAsInt(new int[]{2, 3, -2, 4}));
        Assertions.assertEquals(72, func.applyAsInt(new int[]{-8, 1, -9, -2, 3}));
        Assertions.assertEquals(24, func.applyAsInt(new int[]{-2, 3, -4}));
        Assertions.assertEquals(0, func.applyAsInt(new int[]{-2, 0, -1}));
        Assertions.assertEquals(-2, func.applyAsInt(new int[]{-2}));
    }
}
