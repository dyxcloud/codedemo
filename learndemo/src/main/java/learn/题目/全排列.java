package learn.题目;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DongYunxiang
 * @create 2018-11-26
 **/
public class 全排列 {

    /**
     * 使用递归(深度优先)穷举的方式获取全排列
     * 深度优先方式
     */
    private  class A1{
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            helper(nums, new ArrayList<>(), res);
            return res;
        }

        /**
         * 向排列数组[list]中添加一个数字
         * @param nums 原数组
         * @param list 存放一个排列的数组
         * @param res 输出全排列结果
         */
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

    /**
     * 使用交换方法获取全排列
     * A33 = 3*2*1
     * 递归的算法思想类似, 都是依次生成第一位/第二位/第三位...不过此方法相对A1因为直接在数组源上进行交换,免去了重复数字校验的问题
     */
    private class A2{
        // 最终返回的结果集
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            if (nums == null || nums.length == 0) return res;
            // 采用前后元素交换的办法，dfs解题
            exchange(nums, 0, nums.length);
            return res;
        }

        /**
         *
         * @param nums
         * @param i 交换起点index
         * @param len 目标输出长度
         */
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


    private class A3{
        int N;
        boolean[] used;
        int[] result;

        A3(int n) {
            N = n;
            used = new boolean[n + 1];
            result = new int[n];
        }

        void make(int level) {
            for (int i = 1; i <= N ; i++) {
                if (!used[i]) {
                    used[i] = true;
                    result[level] = i;
                    make(level + 1);
                    used[i] = false;
                }
            }
            if (level == N - 1) {
                for (int i = 0; i < N; i++) {
                    System.out.print(result[i] + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        A1 a1 = new 全排列().new A1();
        A2 a2 = new 全排列().new A2();

        // List<List<Integer>> res = a2.permute(new int[]{1, 2, 3});
        // res.forEach(System.out::println);

        A3 a3 = new 全排列().new A3(3);
        a3.make(0);
    }
}