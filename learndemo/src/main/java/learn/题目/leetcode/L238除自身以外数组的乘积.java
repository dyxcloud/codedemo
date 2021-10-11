package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

@SuppressWarnings("NonAsciiCharacters")
public class L238除自身以外数组的乘积 {
    
    /*
1.求出总乘积,用除法
2.双重for
3.构建两个数组,分别保存i位左边和右边的乘积
    
     */

    public int[] productExceptSelf0(int[] nums) {
        int[] result = new int[nums.length];
        int[] lArr = new int[nums.length];
        int[] rArr = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            if (i == 0) {
                lArr[i] = 1;
            } else {
                lArr[i] = lArr[i - 1] * nums[i - 1];
            }
        }
        for (int i = result.length - 1; i >= 0; i--) {
            if (i == result.length - 1) {
                rArr[i] = 1;
            } else {
                rArr[i] = rArr[i + 1] * nums[i + 1];
            }
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = lArr[i] * rArr[i];
        }
        return result;
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = result.length - 1; i >= 0; i--) {
            if (i == result.length - 1) {
                result[i] = 1;
            } else {
                result[i] = result[i + 1] * nums[i + 1];
            }
        }
        int L = 1;
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] * L;
            L *= nums[i];
        }
        return result;
    }

    @Test
    public void tt() {
        UnaryOperator<int[]> func = this::productExceptSelf;
        Assertions.assertArrayEquals(new int[]{24, 12, 8, 6}, func.apply(new int[]{1, 2, 3, 4}));
    }
}
