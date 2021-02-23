package learn.find;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class BinarySearch {

    public int bs(int[] arr, int des) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (des > arr[mid]) {
                low = mid + 1;
            } else if (des < arr[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int bsrwarp(int[] nums, int target) {
        return bsr(nums, target, 0, nums.length - 1);
    }

    public int bsr(int[] arr, int des, int low, int high) {
        if (low > high || des > arr[high] || des < arr[low])
            return -1;
        int mid = (low + high) / 2;
        if (des > arr[mid]) {
            return bsr(arr, des, mid + 1, high);
        } else if (des < arr[mid]) {
            return bsr(arr, des, low, mid - 1);
        } else {
            return mid;
        }
    }

    interface BinarySearchFunc {
        int search(int[] nums, int target);
    }

    @Test
    public void tt() {
        BinarySearchFunc func = this::bsrwarp;
        TestCase.assertEquals(2, func.search(new int[]{1, 3, 5, 6}, 5));
        TestCase.assertEquals(-1, func.search(new int[]{1, 3, 5, 6}, 0));
        TestCase.assertEquals(3, func.search(new int[]{1, 3, 5, 6}, 6));
        TestCase.assertEquals(0, func.search(new int[]{1, 3, 5, 6}, 1));
        {
            int[] arr = IntStream.rangeClosed(0, 9999999).toArray();// 生成一个0到n的顺序数组
            int target = 5645789;
            Assert.assertEquals(target, func.search(arr, target));
            target = -1;
            Assert.assertEquals(-1, func.search(arr, target));
        }
    }
}
