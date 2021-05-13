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
        sort(nums,0,nums.length-1);
        //取中值
        int m = nums[nums.length/2];
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

    
    
    @Test
    public void tt() {
        ToIntFunction<int[]> f = this::majorityElement;
        TestCase.assertEquals(3, f.applyAsInt(new int[]{3, 2, 3}));
        TestCase.assertEquals(2, f.applyAsInt(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
    
    @Test
    public void testSort(){
        int[] arr = {5,5,5,8,8,1,1,1,5,5,9,9,9};
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
