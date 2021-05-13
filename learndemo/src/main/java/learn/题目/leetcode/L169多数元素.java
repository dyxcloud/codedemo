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
    
    /*
    传统方法:
        方法1: 字典
        方法2: hash
    多数元素:
        f3: 排序
        f4: 随机挑选
        f5: 分治
        f6: 投票(相消)
     */

    public int majorityElement(int[] nums) {
        //快排
        sort(nums, 0, nums.length - 1);
        //取中值
        int m = nums[nums.length / 2];
        //判断是否超过一半
        return m;
    }

    void sort(int[] nums, int start, int end) {
        if (start >= end) return;
        int l = start, r = end;
        int m = nums[start];
        while (l < r) {
            //小于m的放左边, 大于等于m的放右边
            while (nums[l] < m && l < end) l++;
            while (nums[r] >= m && r > start) r--;
            if (l <= r) {
                int t = nums[l];
                nums[l] = nums[r];
                nums[r] = t;
                l++;
                r--;
            }
        }
        sort(nums, start, r);
        sort(nums, l, end);
    }

    public int majorityElement1(int[] nums) {
        //非法输入判断
        if (nums == null || nums.length <= 0)
            return 0;
        int times = 1;
        int number = nums[0];
        //查看是否存在有可能次数大于数组长度一半的数字
        for (int i = 1; i < nums.length; i++) {
            if (times <= 0) {
                number = nums[i];
                times = 0;
            }
            if (nums[i] == number) {
                times++;
            } else {
                times--;
            }
        }
        //判断该数字次数是否大于数组长度一半
        if (times > 0) {
            int count = 0;
            for (int value : nums) {
                if (value == number)
                    count++;
            }
            return (count > nums.length / 2) ? number : 0;
        } else {
            return 0;
        }
    }

    @Test
    public void tt() {
        ToIntFunction<int[]> f = this::majorityElement1;
        TestCase.assertEquals(3, f.applyAsInt(new int[]{3, 2, 3}));
        TestCase.assertEquals(2, f.applyAsInt(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    @Test
    public void testSort() {
        int[] arr = {5, 5, 5, 8, 8, 1, 1, 1, 5, 5, 9, 9, 9};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
