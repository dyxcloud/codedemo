package learn.题目.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public class L260只出现一次的数字III {

    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum ^= i;
        }
        //寻找为1的bit
        int p = 1;
        while ((p & sum) == 0) {
            p = p << 1;
        }
        //划分数组, 重新^运算
        int[] result = new int[2];
        for (int i : nums) {
            if ((i & p) != 0) {
                result[0] = result[0] ^ i;
            } else {
                result[1] = result[1] ^ i;
            }
        }
        return result;
    }

    @Test
    public void tt() {
        UnaryOperator<int[]> f = this::singleNumber;
        int[] result;
        result = f.apply(new int[]{1, 2, 1, 3, 2, 5});
        Arrays.sort(result);
        Assert.assertArrayEquals(new int[]{3, 5}, result);
        result = f.apply(new int[]{-1, 0});
        Arrays.sort(result);
        Assert.assertArrayEquals(new int[]{-1, 0}, result);
        result = f.apply(new int[]{0, 1});
        Arrays.sort(result);
        Assert.assertArrayEquals(new int[]{0, 1}, result);
    }
}
