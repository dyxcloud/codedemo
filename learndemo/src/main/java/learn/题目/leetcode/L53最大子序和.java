package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

public class L53最大子序和 {

    public int maxSubArray0(int[] nums) {
        int max = -100001;
        for (int l = 0; l < nums.length; l++) {
            int sum = 0;
            for (int r = l; r < nums.length; r++) {
                sum += nums[r];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    public int maxSubArray(int[] nums) {
        int max = -100001;
        for (int l = 0; l < nums.length; l++) {
            int sum = 0;
            for (int r = l; r < nums.length; r++) {
                sum += nums[r];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    interface GetFunc {
        int maxSubArray(int[] nums);
    }

    @Test
    public void ttt() {
        GetFunc func = this::maxSubArray0;
        TestCase.assertEquals(6, func.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        TestCase.assertEquals(1, func.maxSubArray(new int[]{1}));
        TestCase.assertEquals(0, func.maxSubArray(new int[]{0}));
        TestCase.assertEquals(-1, func.maxSubArray(new int[]{-1}));
        TestCase.assertEquals(-100000, func.maxSubArray(new int[]{-100000}));
    }

}
