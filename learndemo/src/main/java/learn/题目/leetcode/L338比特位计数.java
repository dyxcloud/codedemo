package learn.题目.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.IntFunction;

/**
 * @author DongYunxiang
 * @create 2021-05-28
 **/
public class L338比特位计数 {

    public int[] countBits(int n) {
        
        return null;
    }

    @Test
    public void tt() {
        IntFunction<int[]> f = this::countBits;
        Assert.assertArrayEquals(new int[]{0, 1, 1}, f.apply(2));
        Assert.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, f.apply(5));
    }
}
