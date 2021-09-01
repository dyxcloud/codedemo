package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

@SuppressWarnings("NonAsciiCharacters")
public class L55跳跃游戏 {

    /**
     * 动态规划(递归)
     */
    public boolean canJump0(int[] nums) {
        cache = new Boolean[nums.length];
        return helper(nums, nums.length - 1);
    }

    Boolean[] cache;

    private boolean helper(int[] nums, int targetIndex) {
        if (targetIndex == 0) {
            return true;
        }
        Boolean c = cache[targetIndex];
        if (c != null) {
            return c;
        }
        //反向遍历 (正向速度更慢, 因为元素都是小数?)
        for (int i = targetIndex - 1; i >= 0; i--) {
            int step = targetIndex - i;//1,2,3...
            if (nums[i] >= step) {
                boolean helper = helper(nums, i);
                if (helper) {
                    cache[targetIndex] = true;
                    return true;
                }
            }
        }
        cache[targetIndex] = false;
        return false;
    }

    /**
     * 贪心 维护最远可到达距离
     */
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i <= maxIndex; i++) {
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (maxIndex >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void tt() {
        Predicate<int[]> func = this::canJump;
        Assertions.assertTrue(func.test(new int[]{2, 3, 1, 1, 4}));
        Assertions.assertFalse(func.test(new int[]{3, 2, 1, 0, 4}));
        Assertions.assertTrue(func.test(new int[]{99, 3, 2, 1, 0, 4}));
    }

}
