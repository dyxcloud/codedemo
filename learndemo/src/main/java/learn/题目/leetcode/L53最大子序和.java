package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.function.ToIntFunction;

public class L53最大子序和 {

    //O(n^2)
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

    
    /*
    	-2	1	-3	4	-1	2	1	终止
    -2	-2	-1	-1	0	0	1	2	
    1	-2	1	1	2	2	3	4	
    -3								
    4								
    -1								
    2								
    1								
    起始								

max(当前坐标 or 左边 or 上边)
i起始
y终止
max(f(i,j) or f(i,j-1) or f(i-1,j))

     */
    
    //DP
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

    public int maxSubArrayHelper(int[] nums, int start, int end) {
        if (start > end) return Integer.MIN_VALUE;
        //计算当前起始的值
        int current = 0;
        for (int i = start; i <= end; i++) {
            current += i;
        }
        int sub1 = maxSubArrayHelper(nums, start - 1, end);
        int sub2 = maxSubArrayHelper(nums, start, end - 1);
        return Math.max(current, Math.max(sub1, sub2));
    }

    @Test
    public void ttt() {
        ToIntFunction<int[]> func = this::maxSubArray;
        TestCase.assertEquals(6, func.applyAsInt(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        TestCase.assertEquals(1, func.applyAsInt(new int[]{1}));
        TestCase.assertEquals(0, func.applyAsInt(new int[]{0}));
        TestCase.assertEquals(-1, func.applyAsInt(new int[]{-1}));
        TestCase.assertEquals(-100000, func.applyAsInt(new int[]{-100000}));
    }

}
