package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

@SuppressWarnings("NonAsciiCharacters")
public class L128最长连续序列 {

    /**
     * 遍历合并区间
     */
    public int longestConsecutive0(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        Map<Integer, Integer> lows = new HashMap<>();//low>high
        Map<Integer, Integer> highs = new HashMap<>();//high>low
        for (int i : collect) {
            Integer high = lows.remove(i + 1);
            Integer low = highs.remove(i - 1);
            if (high != null && low != null) {
                lows.put(low, high);
                highs.put(high, low);
            } else if (high != null) {
                lows.put(i, high);
                highs.put(high, i);
            } else if (low != null) {
                lows.put(low, i);
                highs.put(i, low);
            } else {
                lows.put(i, i);
                highs.put(i, i);
            }
        }
        // System.out.println(lowTargets);
        int max = 0;
        for (Map.Entry<Integer, Integer> e : lows.entrySet()) {
            int l = e.getValue() - e.getKey();
            if (l > max) {
                max = l;
            }
        }
        return max + 1;
    }

    /**
     * 从每一个区间的下界向后延伸
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int result = 1;
        for (int i : collect) {
            if (collect.contains(i - 1)) {
                continue;
            }
            int l = 1;
            while (collect.contains(++i)) {
                l++;
            }
            if (l > result) {
                result = l;
            }
        }
        return result;
    }

    @Test
    public void tt() {
        ToIntFunction<int[]> func = this::longestConsecutive;
        Assertions.assertEquals(4, func.applyAsInt(new int[]{100, 4, 200, 1, 3, 2}));
        Assertions.assertEquals(9, func.applyAsInt(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        Assertions.assertEquals(4, func.applyAsInt(new int[]{-7, -1, 3, -9, -4, 7, -3, 2, 4, 9, 4, -9, 8, -7, 5, -1, -7}));
    }
}
