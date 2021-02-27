package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

public class L69x的平方根 {

    public int mySqrt(int x) {
        int high;
        for (int i = 1; ; ) {
            long num = (long) i * i;
            if (num > x) {
                high = i;
                break;
            }
            i *= 10;
        }
        int low = high / 10;
        while (low < high - 1) {
            int m = low + (high - low) / 2;
            long num = (long) m * m;
            if (num == x) {
                return m;
            }
            if (num > x) {
                high = m - 1;
            } else {
                low = m;
            }
        }
        for (int i = low; i <= high; i++) {
            long num = (long) i * i;
            if (num == x) {
                return i;
            }
            if (num > x) {
                return i - 1;
            }
        }
        return high;
    }

    @Test
    public void tt() {
        // TestCase.assertEquals(2, mySqrt(4));
        // TestCase.assertEquals(2, mySqrt(8));
        // TestCase.assertEquals(10, mySqrt(100));
        // TestCase.assertEquals(12, mySqrt(150));
        // TestCase.assertEquals(0, mySqrt(0));
        TestCase.assertEquals(46339, mySqrt(2147395599));
    }
}
