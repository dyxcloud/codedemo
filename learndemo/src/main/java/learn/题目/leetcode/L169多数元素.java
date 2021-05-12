package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.ToIntFunction;

/**
 * @author DongYunxiang
 * @create 2021-05-12
 **/
public class L169多数元素 {

    public int majorityElement(int[] nums) {
        //快排
        int l = 0, r = nums.length - 1;
        int m = nums[0];
        while (l < r) {
            while (nums[l] < m && l < r) {
                l++;
            }
            while (nums[r] >= m && l < r) {
                r--;
            }
            if (l < r) {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
            }
        }
        System.out.println(Arrays.toString(nums));
        //取中值
        //判断是否超过一半
        return 0;
    }


    @Test
    public void tt() {
        ToIntFunction<int[]> f = this::majorityElement;
        TestCase.assertEquals(3, f.applyAsInt(new int[]{3, 2, 3}));
        TestCase.assertEquals(2, f.applyAsInt(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

}
