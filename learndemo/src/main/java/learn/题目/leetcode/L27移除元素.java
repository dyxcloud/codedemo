package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author DongYunxiang
 * @create 2021-02-20
 **/
public class L27移除元素 {

    public int removeElement(int[] nums, int val) {
        int used = nums.length;
        for (int current = 0; current < used; ) {
            if (nums[current] == val) {
                nums[current] = nums[used - 1];
                used--;
            } else {
                current++;
            }
        }
        return used;
    }

    @Test
    public void tt() {
        {
            int[] nums = {3, 2, 2, 3};
            TestCase.assertEquals(2, removeElement(nums, 3));
            System.out.println(Arrays.toString(nums));
        }
        {
            int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
            TestCase.assertEquals(5, removeElement(nums, 2));
            System.out.println(Arrays.toString(nums));
        }
    }
}
