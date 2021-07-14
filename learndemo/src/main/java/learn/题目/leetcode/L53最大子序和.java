package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.function.ToIntFunction;

public class L53最大子序和 {

    int count = 0;

    //O(n^2)
    public int maxSubArray0(int[] nums) {
        int max = -100001;
        for (int l = 0; l < nums.length; l++) {
            int sum = 0;
            for (int r = l; r < nums.length; r++) {
                sum += nums[r];
                count++;
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    
    /*
    	-2	1	-3	4	-1	2	1	-5  40  终止j
    40  /   /   /   /   /   /   /   /   40
    -5  /   /   /   /   /   /   /   -5  40
    1	/	/	/	/	/	/	1	1   40
    2	/	/	/	/	/	2	3	3   40
    -1	/   /   /   /   -1	2	3	3   40
    4	/   /   /	4	4	5	6	6   41
    -3	/   /	-3  4   4   5   6	6   41
    1	/	1   1   4   4   5   6	6   41
    -2	-2  1   1   4   4   5   6	6	41					
    起始i

max(sum(i~j) , f(i+1,j), f(i,j-1))
//这个公式无法利用子调用的结果直接求解,还要重新累加, 所以比暴力法还慢
递归调用树是一个二叉树展开,深度为l
            f(0,l)
        f(0,l-1) f(1,l)
f(0,l-2) f(1,l-1) f(1,l-1) f(2,l)
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
        int sub1 = maxSubArrayHelper(nums, start + 1, end);
        int sub2 = maxSubArrayHelper(nums, start, end - 1);
        //计算当前起始的值
        int current = 0;
        for (int i = start; i <= end; i++) {
            current += nums[i];
        }
        // System.out.println(current + " ," + start + "~" + end);
        int result = Math.max(current, Math.max(sub1, sub2));
        cache[start][end] = result;
        return result;
    }

    //f(i)=max{f(i−1)+nums[i],nums[i]}
    int[] cache2;

    public int maxSubArray20(int[] nums) {
        cache2 = new int[nums.length];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(maxSubArray20Helper(nums, i), result);
        }
        return result;
    }

    public int maxSubArray20Helper(int[] nums, int end) {
        if (end < 0) return 0;
        if (end == 0) return nums[0];
        if (cache2[end] != 0) {
            return cache2[end];
        }
        count++;
        int result = Math.max(maxSubArray20Helper(nums, end - 1) + nums[end], nums[end]);
        cache2[end] = result;
        return result;
    }

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
        ToIntFunction<int[]> func = this::maxSubArray;
        TestCase.assertEquals(6, func.applyAsInt(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        TestCase.assertEquals(41, func.applyAsInt(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 40}));
        TestCase.assertEquals(1, func.applyAsInt(new int[]{1}));
        TestCase.assertEquals(0, func.applyAsInt(new int[]{0}));
        TestCase.assertEquals(-1, func.applyAsInt(new int[]{-1}));
        TestCase.assertEquals(-100000, func.applyAsInt(new int[]{-100000}));
        System.out.println(count);
    }

}
