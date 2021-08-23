package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.function.ToIntBiFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L33搜索旋转排序数组 {

    public int search(int[] nums, int target) {
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

    @Test
    public void tt() {
        ToIntBiFunction<int[], Integer> func = this::search;
        TestCase.assertEquals(-1, func.applyAsInt(new int[]{1, 2, 3, 4}, 0));
        TestCase.assertEquals(4, func.applyAsInt(new int[]{4, 5, 6, -1, 0, 1, 2}, 0));
        TestCase.assertEquals(4, func.applyAsInt(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        TestCase.assertEquals(-1, func.applyAsInt(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        TestCase.assertEquals(-1, func.applyAsInt(new int[]{1}, 0));
        TestCase.assertEquals(0, func.applyAsInt(new int[]{1}, 1));
    }
}
