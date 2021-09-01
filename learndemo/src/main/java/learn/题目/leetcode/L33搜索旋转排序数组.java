package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.ToIntBiFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L33搜索旋转排序数组 {

    /**
     * 坐标重映射的二分查找
     */
    public int search0(int[] nums, int target) {
        //二分找旋转点
        int start;
        if (nums[0] < nums[nums.length - 1]) {
            start = 0;
        } else {
            int l = 0, r = nums.length - 1;
            while (r - l > 1) {
                int m = (r - l) / 2 + l;
                if (nums[m] < nums[l]) {
                    r = m;
                } else {
                    l = m;
                }
            }
            start = r;
        }
        // System.out.println("start="+start);
        //二分查找
        int l = start, r = (start - 1 + nums.length) % nums.length;
        while ((r - l + nums.length) % nums.length > 1) {
            if (target == nums[l])
                return l;
            if (target == nums[r])
                return r;
            int m = (((r - l + nums.length) % nums.length) / 2 + l + nums.length) % nums.length;
            // System.out.println(MessageFormat.format("l={0} m={1} r={2}",l,m,r));
            if (nums[m] > target) {
                r = m;
            } else if (nums[m] < target) {
                l = m;
            } else {
                return m;
            }
        }
        if (target == nums[l])
            return l;
        if (target == nums[r])
            return r;
        return -1;
    }

    /**
     * 二分查找 分区 不重映射坐标
     */
    public int search1(int[] nums, int target) {
        //二分找旋转点
        int start;
        if (nums[0] < nums[nums.length - 1]) {
            start = 0;
        } else {
            int l = 0, r = nums.length - 1;
            while (r - l > 1) {
                int m = (r - l) / 2 + l;
                if (nums[m] < nums[l]) {
                    r = m;
                } else {
                    l = m;
                }
            }
            start = r;
        }
        //二分查找
        int l, r;
        if (start == 0) {
            l = 0;
            r = nums.length - 1;
        } else {
            if (target >= nums[0]) {
                l = 0;
                r = start - 1;
            } else {
                l = start;
                r = nums.length - 1;
            }
        }
        while (r - l > 1) {
            if (target == nums[l])
                return l;
            if (target == nums[r])
                return r;
            int m = (r - l) / 2 + l;
            if (target > nums[m]) {
                l = m;
            } else if (target < nums[m]) {
                r = m;
            } else {
                return m;
            }
        }
        if (target == nums[l])
            return l;
        if (target == nums[r])
            return r;
        return -1;
    }

    /**
     * 二分查找 一次
     */
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (r - l > 1) {
            if (target == nums[l]) return l;
            if (target == nums[r]) return r;
            int m = (r - l) / 2 + l;
            if (target == nums[m]) return m;
            if (nums[m] < nums[nums.length - 1]) {
                //左侧旋转
                if (nums[m] < target && target < nums[nums.length - 1]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                //右侧旋转
                if (nums[0] < target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        if (target == nums[l]) return l;
        if (target == nums[r]) return r;
        return -1;
    }

    @Test
    public void tt() {
        ToIntBiFunction<int[], Integer> func = this::search;
        Assertions.assertEquals(-1, func.applyAsInt(new int[]{1, 2, 3, 4}, 0));
        Assertions.assertEquals(4, func.applyAsInt(new int[]{4, 5, 6, -1, 0, 1, 2}, 0));
        Assertions.assertEquals(4, func.applyAsInt(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        Assertions.assertEquals(-1, func.applyAsInt(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        Assertions.assertEquals(-1, func.applyAsInt(new int[]{1}, 0));
        Assertions.assertEquals(0, func.applyAsInt(new int[]{1}, 1));
    }
}
