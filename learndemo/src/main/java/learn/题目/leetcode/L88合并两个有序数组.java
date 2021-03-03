package learn.题目.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class L88合并两个有序数组 {

    public void merge0(int[] nums1, int m, int[] nums2, int n) {
        int[] a = new int[m];
        System.arraycopy(nums1, 0, a, 0, m);
        int i = 0, j = 0, p = 0;
        while (i < m || j < n) {
            if (j >= n || (i < m && a[i] < nums2[j])) {
                nums1[p] = a[i];
                i++;
            } else {
                nums1[p] = nums2[j];
                j++;
            }
            p++;
        }
    }


    interface Func {
        void merge(int[] nums1, int m, int[] nums2, int n);
    }

    @Test
    public void test() {
        Func f = this::merge0;
        {
            int[] nums1 = {1, 2, 3, 0, 0, 0};
            f.merge(nums1, 3, new int[]{2, 5, 6}, 3);
            System.out.println(Arrays.toString(nums1));
            Assert.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1);
        }
        {
            int[] nums1 = {1};
            f.merge(nums1, 1, new int[]{}, 0);
            System.out.println(Arrays.toString(nums1));
            Assert.assertArrayEquals(new int[]{1}, nums1);
        }
        {
            int[] nums1 = {4, 5, 6, 0, 0, 0};
            f.merge(nums1, 3, new int[]{1, 2, 3}, 3);
            System.out.println(Arrays.toString(nums1));
            Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, nums1);
        }
    }
}
