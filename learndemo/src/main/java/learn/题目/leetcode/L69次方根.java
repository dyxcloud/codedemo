package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

@SuppressWarnings("NonAsciiCharacters")
public class L69次方根 {

    interface RootGetter {
        double getRoot(long num, int times);
    }

    @Test
    public void testGetRoot() {
        // RootGetter getter = this::getRoot;
        RootGetter getter = this::getRootByBinarySearch;
        System.out.println(getter.getRoot(9, 2));//3.0
        System.out.println(getter.getRoot(27, 3));//3.0
        System.out.println(getter.getRoot(15, 2));//3.872
        System.out.println(getter.getRoot(-64, 3));
        System.out.println(getter.getRoot(2147395599, 2));
    }

    /**
     * 二分法计算次方根
     */
    public double getRootByBinarySearch(double x, final int times) {
        double low = 0;
        double high = x;
        double mid;
        while (Math.abs(high) > Math.abs(low)) {
            mid = low / 2 + high / 2;
            double r = Math.abs(Math.pow(mid, times));
            if (Math.abs(r - Math.abs(x)) < 0.001) {
                return mid;
            } else if (r > Math.abs(x)) {
                high = mid;
            } else if (r < Math.abs(x)) {
                low = mid;
            }
        }
        throw new RuntimeException("not found");
    }

    /**
     * 逐位进行计算
     */
    public double getRoot(long num, int times) {
        final int accuracy = -3;
        int sign = num < 0 && times % 2 == 1 ? -1 : 1;
        int size = getSize(num, times);
        double l = 0;
        while (--size >= accuracy) {
            l += Math.pow(10, size);
            double nextL = l + Math.pow(10, size);
            while (true) {
                double guess = Math.pow(nextL, times);
                if (guess > Math.abs(num)) {
                    break;
                } else if (guess == Math.abs(num)) {
                    return nextL*sign;
                } else {
                    l = nextL;
                    nextL = l + Math.pow(10, size);
                }
            }
        }
        return l*sign;
    }

    /**
     * 获取次方根的位数
     */
    private int getSize(long num, int pow) {
        num = Math.abs(num);
        int i = 0;
        while (true) {
            double base = Math.pow(10, i);
            if (Math.pow(base, pow) > num) {
                return i;
            }
            i++;
        }
    }

    @Test
    public void testmethod() {
        TestCase.assertEquals(2, getSize(121, 2));
        TestCase.assertEquals(2, getSize(100, 2));
        TestCase.assertEquals(1, getSize(81, 2));
        TestCase.assertEquals(1, getSize(9, 2));
        TestCase.assertEquals(1, getSize(1, 2));
        TestCase.assertEquals(0, getSize(0, 2));
        TestCase.assertEquals(1, getSize(27, 3));
    }

}
