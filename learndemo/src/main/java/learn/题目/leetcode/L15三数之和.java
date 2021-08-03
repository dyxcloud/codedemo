package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

public class L15三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            result.addAll(twoSumPoint(nums,i));
        }
        return result;
    }

    private ArrayList<List<Integer>> twoSumPoint(int[] nums, int i){
        ArrayList<List<Integer>> result = new ArrayList<>();
        int target = -nums[i];
        int l=i+1,r=nums.length-1;
        while(l<r){
            if (l > i + 1 && nums[l] == nums[l - 1]) {//j不能与上一次取值相同
                l++;
                continue;
            }
            int add = nums[l] + nums[r];
            if (add == target) {
                List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                result.add(list);
                l++;
                r--;
            } else if (add > target) {
                r--;
            } else {
                l++;
            }
        }
        return result;
    }
    
    private ArrayList<List<Integer>> twoSumHash(int[] nums, int i){
        LinkedHashSet<List<Integer>> result = new LinkedHashSet<>();
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
        return new ArrayList<>(result);
    }

    @Test
    public void test3() {
        {
            int[] arr = {-1, 0, 1, 2, -1, -4};
            TestCase.assertEquals(
                    Arrays.asList(Arrays.asList(-1, 0, 1), Arrays.asList(-1, -1, 2))
                    , threeSum(arr));
        }{
            int[] arr = {0,0,0};
            TestCase.assertEquals(
                    Arrays.asList(Arrays.asList(0,0,0))
                    , threeSum(arr));
        }
    }
    
}
