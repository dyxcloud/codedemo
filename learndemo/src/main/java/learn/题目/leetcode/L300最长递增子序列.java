package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.ToIntFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L300最长递增子序列 {

    /*
DP:
f(n) = 1+max(f(i))  i=0~n-1
        && nums[i]<nums[n]
     */

    /**
     * dp, 依次计算以n为结束的序列的长度, 最后得到最大值
     * 时间n^2 空间n
     */
    public int lengthOfLIS(int[] nums) {
        int[] cache = new int[nums.length];
        cache[0] = 1;
        for (int n = 1; n < nums.length; n++) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                if (nums[n] > nums[i] && cache[i] > max) {
                    max = cache[i];
                }
            }
            cache[n] = max + 1;
        }
        // System.out.println(Arrays.toString(cache));
        int result = 0;
        for (int i : cache) {
            if (result < i) result = i;
        }
        return result;
    }

    @Test
    public void tt() {
        ToIntFunction<int[]> func = this::lengthOfLIS;
        Assertions.assertEquals(4, func.applyAsInt(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));//2,3,7,101
        Assertions.assertEquals(4, func.applyAsInt(new int[]{0, 1, 0, 3, 2, 3}));//
        Assertions.assertEquals(1, func.applyAsInt(new int[]{7, 7, 7, 7, 7, 7, 7}));//
        Assertions.assertEquals(6, func.applyAsInt(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));//
    }
}
