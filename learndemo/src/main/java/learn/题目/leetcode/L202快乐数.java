package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @author DongYunxiang
 * @create 2020-07-08
 **/
public class L202快乐数 {

    @Test
    public void testFunc() {
        Assertions.assertTrue(isHappy(19));
        Assertions.assertFalse(isHappy(11));
    }

    /**
     * 存储结果, 判断是否回环
     */
    public boolean isHappy(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        HashSet<Integer> set = new HashSet<>();
        while (n > 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = getNext(n);
        }
        return true;
    }

    /**
     * 使用快慢指针判断是否回环
     */
    public boolean isHappy2(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        int slow = n, fast = n;
        do {
            slow = getNext(slow);
            fast = getNext(fast);
            fast = getNext(fast);
        } while (slow != fast);
        return slow == 1;
    }


    public int getNext(int i) {
        int res = 0;
        while (i != 0) {
            res += ((i % 10) * (i % 10));
            i /= 10;
        }
        return res;
    }

    @Test
    public void testMethod() {
        Assertions.assertEquals(65, getNext(81));
        Assertions.assertEquals(17, getNext(14));
        Assertions.assertEquals(1, getNext(1));
        Assertions.assertEquals(0, getNext(0));
    }
}
