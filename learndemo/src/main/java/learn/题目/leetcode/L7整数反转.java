package learn.题目.leetcode;


import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2021-02-19
 **/
public class L7整数反转 {

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            result = result * 10 + pop;
        }
        return result;
    }

    @Test
    public void tt() {
        TestCase.assertEquals(321, reverse(123));
        TestCase.assertEquals(-321, reverse(-123));
        TestCase.assertEquals(21, reverse(120));
        TestCase.assertEquals(0, reverse(0));
    }
}
