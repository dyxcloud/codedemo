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
    	-2	1	-3	4	-1	2	1	-5  终止
    -5  /   /   /   /   /   /   /   -5
    1	/	/	/	/	/	/	1	1
    2	/	/	/	/	/	2	3	3
    -1	/   /   /   /   -1	2	3	3				
    4	/   /   /	4	3	5	6	6		
    -3	/   /	-3  4   3   5   6	6					
    1	/	1   -2  4   3   5   6	6					
    -2	-2  1   -2  4   3   5   6	6						
    起始								

max(当前坐标 , 上边, 左边)
i起始
j终止
max(sum(i~j) , f(i+1,j), f(i,j-1))
     */

    //DP
    int[][] cache;

    public int maxSubArray(int[] nums) {
        cache = new int[nums.length][nums.length];
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    public int maxSubArrayHelper(int[] nums, int start, int end) {
        if (start < 0 || end >= nums.length || start > end) return Integer.MIN_VALUE;
        if (end == start) {
            return nums[start];
        }
        if (cache[start][end] != 0) {
            return cache[start][end];
        }
        //计算当前起始的值
        int current = 0;
        for (int i = start; i <= end; i++) {
            current += nums[i];
        }
        System.out.println(current + " ," + start + "~" + end);
        int sub1 = maxSubArrayHelper(nums, start + 1, end);
        int sub2 = maxSubArrayHelper(nums, start, end - 1);
        int result = Math.max(current, Math.max(sub1, sub2));
        cache[start][end] = result;
        return result;
    }

    //f(i)=max{f(i−1)+nums[i],nums[i]}
    public int maxSubArray2(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    @Test
    public void ttt() {
        ToIntFunction<int[]> func = this::maxSubArray2;
        TestCase.assertEquals(6, func.applyAsInt(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        TestCase.assertEquals(1, func.applyAsInt(new int[]{1}));
        TestCase.assertEquals(0, func.applyAsInt(new int[]{0}));
        TestCase.assertEquals(-1, func.applyAsInt(new int[]{-1}));
        TestCase.assertEquals(-100000, func.applyAsInt(new int[]{-100000}));
    }

}
