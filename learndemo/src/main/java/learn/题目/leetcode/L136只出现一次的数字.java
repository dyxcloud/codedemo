package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.function.ToIntFunction;

public class L136只出现一次的数字 {

    public int singleNumber0(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        return set.stream().findFirst().orElse(-1);
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result = result ^ i;
        }
        return result;
    }

    @Test
    public void tt() {
        ToIntFunction<int[]> f = this::singleNumber;
        TestCase.assertEquals(1, f.applyAsInt(new int[]{2, 2, 1}));
        TestCase.assertEquals(4, f.applyAsInt(new int[]{4, 1, 2, 1, 2}));
    }
}
