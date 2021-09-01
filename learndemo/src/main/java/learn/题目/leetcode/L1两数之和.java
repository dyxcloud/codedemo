package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

public class L1两数之和 {

    public int[] twoSumHash(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            Integer integer = map.get(n);
            if (integer != null) {
                result[0] = integer;
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] bkarr = new int[nums.length];
        System.arraycopy(nums, 0, bkarr, 0, nums.length);
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int n = nums[l] + nums[r];
            if (n == target) {
                result[0] = l;
                result[1] = r;
                break;
            } else if (n < target) {
                l++;
            } else {
                r--;
            }
        }
        for (int k = 0; k < bkarr.length; k++) {
            if (bkarr[k] == nums[result[0]]) {
                result[0] = k;
                break;
            }
        }
        for (int k = 0; k < bkarr.length; k++) {
            if (bkarr[k] == nums[result[1]] && k != result[0]) {
                result[1] = k;
                break;
            }
        }
        return result;
    }


    @Test
    public void test() {
        {
            int[] arr = {2, 7, 11, 15};
            Assertions.assertArrayEquals(new int[]{0, 1}, twoSum(arr, 9));
        }
        {
            int[] arr = {3, 3};
            Assertions.assertArrayEquals(new int[]{0, 1}, twoSum(arr, 6));
        }
        {
            int[] arr = {-3, 4, 3, 90};
            Assertions.assertArrayEquals(new int[]{0, 2}, twoSum(arr, 0));
        }
    }

}
