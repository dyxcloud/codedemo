package learn.进制;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * @author DongYunxiang
 * @create 2019-04-12
 **/
public class 位运算 {


    boolean isOdd(long l) {
        return (l & 1) == 1;
    }

    @Test
    public void testIsOdd() {
        assertTrue(isOdd(1));
        assertTrue(!isOdd(2));
    }

    /**
     * 统计整数转成二进制后总共有多少位是1
     *
     * @param l
     * @return
     */
    int howmuch(long a) {
        int count = 0;
        while (a != 0) {
            a = a & (a - 1);
            count++;
        }
        return count;
    }

    @Test
    public void testhowmuch() {
        assertEquals(howmuch(1), 1);
        assertEquals(howmuch(-1), 64);
    }

    /**
     * 数组中除了一个数字为其他都出现了两次,找出这个数字
     * @param arr
     * @return
     */
    long findUninumber(long... arr) {
        long result = 0L;
        for (long a : arr) {
            result ^= a;
        }
        return result;
    }

    @Test
    public void testFindUninumber() {
        assertEquals(findUninumber(1,2,3,1,2,3,5),5);
    }

}
