package dotest.print;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DongYunxiang
 * @create 2018-11-26
 **/
public class 全排列 {

    private  class A1{
        private List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(nums, new ArrayList<>(), res);
            return res;
        }

        private void helper(int[] nums, List<Integer> list, List<List<Integer>> res) {
            if (list.size() == nums.length) {  // 达到长度，可以输出了
                res.add(new ArrayList<>(list));
            } else {
                for (int num : nums) {
                    if (!list.contains(num)) {  //若这个数字已经被包含了，就跳过
                        list.add(num);
                        helper(nums, list, res);
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
    }

    private class A2{
        // 最终返回的结果集
        private List<List<Integer>> res = new ArrayList<List<Integer>>();

        private List<List<Integer>> permute(int[] nums) {
            if (nums == null || nums.length == 0) return res;

            // 采用前后元素交换的办法，dfs解题
            exchange(nums, 0, nums.length);
            return res;
        }

        private void exchange(int[] nums, int i, int len) {
            // 将当前数组加到结果集中
            if (i == len - 1) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < len; j++) {
                    list.add(nums[j]);
                }
                res.add(list);
                return;
            }
            // 将当前位置的数跟后面的数交换，并搜索解
            for (int j = i; j < len; j++) {
                swap(nums, i, j);
                exchange(nums, i + 1, len);
                swap(nums, i, j);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


    public static void main(String[] args) {
        A1 a1 = new 全排列().new A1();
        A2 a2 = new 全排列().new A2();

        List<List<Integer>> res = a1.permute(new int[]{1, 2, 3});
        res.forEach(System.out::println);
    }
}