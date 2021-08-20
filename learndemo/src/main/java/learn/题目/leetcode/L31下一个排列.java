package learn.题目.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Consumer;

@SuppressWarnings("NonAsciiCharacters")
public class L31下一个排列 {

    public void nextPermutation(int[] nums) {
        //找到降序数
        int l = nums.length - 2;
        while (l >= 0 && nums[l] >= nums[l + 1]) {
            l--;
        }
        if (l == -1) {
            //字典序的最后一个
            reverse(nums, 0);
        } else {
            //找到第一个大于l的数
            int r = nums.length - 1;
            while (r > l && nums[l] >= nums[r]) {
                r--;
            }
            swap(nums, l, r);
            //使l之后为升序
            // Arrays.sort(nums, l + 1, nums.length);
            //因为r是第一个大于l的数字,所以交换后,后段序列一定是降序的
            reverse(nums, l + 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private void reverse(int[] nums, int start) {
        int r = nums.length - 1;
        while (start < r) {
            swap(nums, start, r);
            start++;
            r--;
        }
    }

    @Test
    public void tt() {
        Consumer<int[]> func = this::nextPermutation;
        {
            int[] arr = {1, 2, 3};
            func.accept(arr);
            Assert.assertArrayEquals(new int[]{1, 3, 2}, arr);
        }
        {
            int[] arr = {1, 3, 2};
            func.accept(arr);
            Assert.assertArrayEquals(new int[]{2, 1, 3}, arr);
        }
        {
            int[] arr = {3, 2, 1};
            func.accept(arr);
            Assert.assertArrayEquals(new int[]{1, 2, 3}, arr);
        }
        {
            int[] arr = {1, 1, 5};
            func.accept(arr);
            Assert.assertArrayEquals(new int[]{1, 5, 1}, arr);
        }
        {
            int[] arr = {1};
            func.accept(arr);
            Assert.assertArrayEquals(new int[]{1}, arr);
        }
    }
}
