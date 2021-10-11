package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.IntUnaryOperator;

@SuppressWarnings("NonAsciiCharacters")
public class L279完全平方数 {
    /*
    1 4 9 16 25
    
    f(43)=1+f(43-6^2)
          1+f(43-5^2)
    DP:
     */
    int[] cache;

    public int numSquares(int n) {
        if (n <= 1) return n;
        if (cache == null) cache = new int[n + 1];
        if (cache[n] != 0) return cache[n];
        int maxI = 1;
        while (maxI * maxI <= n) {
            maxI++;
        }
        maxI--;
        int result = Integer.MAX_VALUE;
        for (int i = maxI; i > 0; i--) {
            int i1 = numSquares(n - i * i);
            if (result > i1) result = i1;
        }
        cache[n] = result + 1;
        return cache[n];
    }

    public int numSquares1(int n) {
        int[] cache = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int e = 1; e * e <= i; e++) {
                if (min > cache[i - e * e]) min = cache[i - e * e];
            }
            cache[i] = min + 1;
        }
        return cache[n];
    }

    @Test
    public void tt() {
        IntUnaryOperator func = this::numSquares1;
        Assertions.assertEquals(3, func.applyAsInt(12));
        Assertions.assertEquals(2, func.applyAsInt(13));
        Assertions.assertEquals(3, func.applyAsInt(43));//36-4-1-1-1 25-9-9
    }
}
