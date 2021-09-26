package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L198打家劫舍 {
    /*
2 7 9 3 1 2
dp
f(0,n) = max(f(0,n-2)+num[n]
            ,f(0,n-3)+num[n-1])
     */

    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        cache[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int r1 = nums[i] + (i - 2 < 0 ? 0 : cache[i - 2]);
            int r2 = nums[i - 1] + (i - 3 < 0 ? 0 : cache[i - 3]);
            cache[i] = Math.max(r1, r2);
        }
        return cache[nums.length - 1];
    }


    @Test
    public void tt() {
        ToIntFunction<int[]> func = this::rob;
        Assertions.assertEquals(4, func.applyAsInt(new int[]{1, 2, 3, 1}));
        Assertions.assertEquals(12, func.applyAsInt(new int[]{2, 7, 9, 3, 1}));
        Assertions.assertEquals(13, func.applyAsInt(new int[]{2, 7, 9, 3, 1, 2}));
        Assertions.assertEquals(16, func.applyAsInt(new int[]{2, 7, 9, 7, 1, 2}));
        Assertions.assertEquals(19, func.applyAsInt(new int[]{2, 4, 8, 9, 9, 3}));
        Assertions.assertEquals(2, func.applyAsInt(new int[]{2, 1}));
    }
}
