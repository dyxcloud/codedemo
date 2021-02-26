package learn.题目.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2021-02-26
 **/
public class L66加一 {

    public int[] plusOne0(int[] digits) {
        long num = 0;
        for (int digit : digits) {
            num = num * 10 + digit;
        }
        num++;
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        int[] result = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            result[i] = chars[i] - '0';
        }
        return result;
    }

    public int[] plusOne(int[] digits) {
        int incr = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + incr;
            if (num <= 9) {
                digits[i] = num;
                return digits;
            } else {
                incr = 1;
                digits[i] = num - 10;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        System.arraycopy(digits, 0, result, 1, digits.length);
        return result;
    }

    @Test
    public void tt() {
        Assert.assertArrayEquals(new int[]{1, 2, 4}, plusOne(new int[]{1, 2, 3}));
        Assert.assertArrayEquals(new int[]{4, 3, 2, 2}, plusOne(new int[]{4, 3, 2, 1}));
        Assert.assertArrayEquals(new int[]{1}, plusOne(new int[]{0}));
        Assert.assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 1}
                , plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
        Assert.assertArrayEquals(new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 7}
                , plusOne(new int[]{7, 2, 8, 5, 0, 9, 1, 2, 9, 5, 3, 6, 6, 7, 3, 2, 8, 4, 3, 7, 9, 5, 7, 7, 4, 7, 4, 9, 4, 7, 0, 1, 1, 1, 7, 4, 0, 0, 6}));
    }
}
