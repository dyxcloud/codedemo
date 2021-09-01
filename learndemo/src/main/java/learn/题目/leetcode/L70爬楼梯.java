package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntUnaryOperator;

/**
 * @author DongYunxiang
 * @create 2021-03-02
 **/
public class L70爬楼梯 {

    Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        Integer result = cache.get(n);
        if (result != null) {
            return result;
        } else {
            result = climbStairs(n - 1) + climbStairs(n - 2);
            cache.put(n, result);
            return result;
        }
    }


    @Test
    public void tt() {
        IntUnaryOperator func = this::climbStairs;
        Assertions.assertEquals(2, func.applyAsInt(2));
        Assertions.assertEquals(3, func.applyAsInt(3));
    }
}
