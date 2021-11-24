package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L347前K个高频元素 {

    /**
     * 计数, 传入优先队列(小顶堆)
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null) return null;
        if (nums.length == 1) return nums;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : nums) {
            countMap.compute(i, (key, val) -> {
                if (val == null) return 1;
                return val + 1;
            });
        }
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.stream().mapToInt(Map.Entry::getKey).toArray();
    }

    @Test
    public void tt() {
        BiFunction<int[], Integer, int[]> func = this::topKFrequent;
        {
            int[] apply = func.apply(new int[]{1, 1, 1, 2, 2, 3}, 2);
            Arrays.sort(apply);
            Assertions.assertArrayEquals(new int[]{1, 2}, apply);
        }
        Assertions.assertArrayEquals(new int[]{1}, func.apply(new int[]{1}, 1));
    }
}
