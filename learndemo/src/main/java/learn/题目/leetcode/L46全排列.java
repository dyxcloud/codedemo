package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


@SuppressWarnings("NonAsciiCharacters")
public class L46全排列 {

    /**
     * 以字典序生成全排列
     */
    static class l46_1 {
        L31下一个排列 l31 = new L31下一个排列();

        public List<List<Integer>> permute(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            int times = 1, length = nums.length;
            while (length > 1) {
                times *= length;
                length--;
            }
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            while (times > 1) {
                l31.nextPermutation(nums);
                result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                times--;
            }
            return result;
        }
    }

    /**
     * 回溯法, 双队列
     */
    static class l46_2 {
        
        List<List<Integer>> result;
        int length;

        public List<List<Integer>> permute(int[] nums) {
            length = nums.length;
            result = new ArrayList<>();
            List<Integer> queue = new ArrayList<>(length);
            List<Integer> sources = Arrays.stream(nums).boxed().collect(Collectors.toList());
            helper(queue, sources);
            return result;
        }

        private void helper(List<Integer> queue, List<Integer> sources) {
            int qSize = queue.size();
            for (int i = 0; i < sources.size(); i++) {
                Integer remove = sources.remove(i);
                queue.add(remove);
                if (queue.size() == length) {
                    result.add(new ArrayList<>(queue));
                } else {
                    helper(queue, sources);
                }
                sources.add(i, remove);
                queue.remove(qSize);
            }
        }
    }

    /**
     * 回溯法, swap, 展开交换的情况树
     */
    static class l46_3{
        List<List<Integer>> res;
        
        public List<List<Integer>> permute(int[] nums) {
            res = new ArrayList<>();
            if (nums == null || nums.length == 0) return res;
            exchange(nums, 0);
            return res;
        }

        /**
         * @param i 交换起点index
         */
        private void exchange(int[] nums, int i) {
            if (i == nums.length - 1) {
                res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                return;
            }
            // 将当前位置的数跟后面的数交换，并搜索解
            for (int j = i; j < nums.length; j++) {
                swap(nums, i, j);
                exchange(nums, i + 1);
                swap(nums, i, j);
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    @Test
    public void tt() {
        Function<int[], List<List<Integer>>> func = new l46_2()::permute;
        {
            Set<List<Integer>> set = Set.of(
                    Arrays.asList(1, 2, 3),
                    Arrays.asList(1, 3, 2),
                    Arrays.asList(2, 1, 3),
                    Arrays.asList(2, 3, 1),
                    Arrays.asList(3, 1, 2),
                    Arrays.asList(3, 2, 1)
            );
            Assertions.assertEquals(set, new HashSet<>(func.apply(new int[]{1, 2, 3})));
        }
        {
            Set<List<Integer>> set = Set.of(
                    Arrays.asList(0, 1),
                    Arrays.asList(1, 0)
            );
            Assertions.assertEquals(set, new HashSet<>(func.apply(new int[]{0, 1})));
        }
        {
            Set<List<Integer>> set = Set.of(
                    Collections.singletonList(1)
            );
            Assertions.assertEquals(set, new HashSet<>(func.apply(new int[]{1})));
        }
    }
}
