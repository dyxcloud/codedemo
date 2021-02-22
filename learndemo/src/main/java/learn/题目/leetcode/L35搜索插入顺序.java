package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2021-02-22
 **/
public class L35搜索插入顺序 {

    public int searchInsert0(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] > target) {
                r = m;
            } else {
                l = m;
            }
        }
        return -1;
    }

    @Test
    public void tt() {
        TestCase.assertEquals(2, searchInsert(new int[]{1, 3, 5, 6}, 5));
        TestCase.assertEquals(1, searchInsert(new int[]{1, 3, 5, 6}, 2));
        TestCase.assertEquals(4, searchInsert(new int[]{1, 3, 5, 6}, 7));
        TestCase.assertEquals(0, searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

}
