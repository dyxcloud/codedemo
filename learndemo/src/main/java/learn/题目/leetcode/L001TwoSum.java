package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class L001TwoSum {

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
            Assert.assertArrayEquals(new int[]{0, 1}, twoSum(arr, 9));
        }
        {
            int[] arr = {3, 3};
            Assert.assertArrayEquals(new int[]{0, 1}, twoSum(arr, 6));
        }
        {
            int[] arr = {-3, 4, 3, 90};
            Assert.assertArrayEquals(new int[]{0, 2}, twoSum(arr, 0));
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        LinkedHashSet<List<Integer>> result = new LinkedHashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                int n = target - nums[j];
                Integer integer = map.get(n);
                if (integer != null) {
                    List<Integer> list = Arrays.asList(nums[i], nums[integer], nums[j]);
                    Collections.sort(list);
                    result.add(list);
                }
                map.put(nums[j], j);
            }
        }
        return new ArrayList<>(result);
    }

    @Test
    public void test3() {
        {
            int[] arr = {-1, 0, 1, 2, -1, -4};
            TestCase.assertEquals(
                    Arrays.asList(Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2))
                    , threeSum(arr));
        }
    }

}
