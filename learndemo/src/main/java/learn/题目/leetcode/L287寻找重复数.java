package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L287寻找重复数 {

    /**
     * 异或运算,数字最多重复一次可用
     * 时间复杂度n 空间复杂度1
     */
    public int findDuplicate00(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        for (int i = 1; i < nums.length; i++) {
            result ^= i;
        }
        return result;
    }

    /**
     * 时间复杂度n 空间复杂度n
     */
    public int findDuplicate(int[] nums) {
        int[] cache = new int[nums.length];
        for (int i : nums) {
            if (cache[i] == 0) {
                cache[i] = 1;
            } else {
                return i;
            }
        }
        return 0;
    }

    @Test
    public void tt() {
        ToIntFunction<int[]> func = this::findDuplicate;
        Assertions.assertEquals(2, func.applyAsInt(new int[]{1, 3, 4, 2, 2}));
        Assertions.assertEquals(3, func.applyAsInt(new int[]{3, 1, 3, 4, 2}));
        Assertions.assertEquals(1, func.applyAsInt(new int[]{1, 1}));
        Assertions.assertEquals(1, func.applyAsInt(new int[]{1, 1, 2}));
        Assertions.assertEquals(2, func.applyAsInt(new int[]{2, 2, 2, 2, 2}));
    }
}
