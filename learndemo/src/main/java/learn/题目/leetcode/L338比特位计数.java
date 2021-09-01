package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.IntFunction;

/**
 * @author DongYunxiang
 * @create 2021-05-28
 **/
public class L338比特位计数 {

    /**
     * 暴力计算
     */
    public int[] countBits0(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int num = i;
            while (num != 0) {
                num = num & (num - 1);
                result[i]++;
            }
        }
        return result;
    }

    
    /*
    DP
0   0
1   1
10  1
11  2
100 1
101 2
110 2
111 3
1000    1
1001    2
1010    2
1011    3
1100    2
1101    3
1110    3
1111    4

f(i) = f(i>>1) + (i&1)
     */

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }

    @Test
    public void tt() {
        IntFunction<int[]> f = this::countBits;
        Assertions.assertArrayEquals(new int[]{0, 1, 1}, f.apply(2));
        Assertions.assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, f.apply(5));
    }
}
