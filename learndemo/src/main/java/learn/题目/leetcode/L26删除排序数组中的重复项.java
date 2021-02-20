package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author DongYunxiang
 * @create 2021-02-20
 **/
public class L26删除排序数组中的重复项 {

    public int removeDuplicates(int[] nums) {
        int used = 0;
        for (int current = 1; current < nums.length; current++) {
            if (nums[current] > nums[used]) {
                nums[++used] = nums[current];
            }
        }
        return used + 1;
    }

    @Test
    public void tt() {
        {
            int[] nums = {1, 1, 2};
            TestCase.assertEquals(2, removeDuplicates(nums));
            System.out.println(Arrays.toString(nums));
        }
        {
            int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
            TestCase.assertEquals(5, removeDuplicates(nums));
            System.out.println(Arrays.toString(nums));
        }
    }
}
