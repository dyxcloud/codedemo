package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class L69x的平方根 {

    public int mySqrt(int x) {
        int low = 0;
        int high = x / 2 + 1;
        while (low < high - 1) {
            int m = low + (high - low) / 2;
            long num = (long) m * m;
            if (num > x) {
                high = m - 1;
            } else {
                low = m;
            }
        }
        return ((long) high * high > x) ? high - 1 : high;
    }

    public int mySqrt_old(int x) {
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
        Assertions.assertEquals(2, mySqrt(4));
        Assertions.assertEquals(2, mySqrt(8));
        Assertions.assertEquals(10, mySqrt(100));
        Assertions.assertEquals(12, mySqrt(150));
        Assertions.assertEquals(0, mySqrt(0));
        Assertions.assertEquals(46339, mySqrt(2147395599));
    }
}
