package learn.题目.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.BiFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L34在排序数组中查找元素的第一个和最后一个位置 {

    /**
     * 两次二分
     */
    public int[] searchRange(int[] nums, int target) {
        int size = nums.length;
        //找起始
        int start = -1;
        int l = 0, r = size - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (nums[m] < target) {
                l = m + 1;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                if (m > 0 && nums[m - 1] == target) {
                    r = m - 1;
                } else {
                    start = m;
                    break;
                }
            }
        }
        if (start == -1) {
            return new int[]{-1, -1};
        }
        //找终止
        int end = start;
        l = start;
        r = size - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (nums[m] > target) {
                r = m - 1;
            } else {
                if (m < size - 1 && nums[m + 1] == target) {
                    l = m + 1;
                } else {
                    end = m;
                    break;
                }
            }
        }
        return new int[]{start, end};
    }

    @Test
    public void tt() {
        BiFunction<int[], Integer, int[]> func = this::searchRange;
        Assert.assertArrayEquals(new int[]{3, 4}, func.apply(new int[]{5, 7, 7, 8, 8, 10}, 8));
        Assert.assertArrayEquals(new int[]{3, 5}, func.apply(new int[]{6, 6, 6, 7, 7, 7, 8, 8, 8}, 7));
        Assert.assertArrayEquals(new int[]{-1, -1}, func.apply(new int[]{5, 7, 7, 8, 8, 10}, 6));
        Assert.assertArrayEquals(new int[]{-1, -1}, func.apply(new int[]{}, 0));
    }
}
