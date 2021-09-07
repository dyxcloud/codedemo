package learn.题目.leetcode;

import org.junit.jupiter.api.Test;

import java.util.function.IntBinaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
public class L62不同路径 {

/*
o o
o o
o o

 */

    int[][] cache;

    /**
     * DP 递归
     * @param m 高度
     * @param n 宽度
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        if (cache == null) {
            cache = new int[m+1][n+1];
        }
        if (cache[m][n] != 0) {
            return cache[m][n];
        }
        int result = uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        cache[m][n] = result;
        return result;
    }


    @Test
    public void tt() {
        IntBinaryOperator func = this::uniquePaths;
        assertEquals(28, func.applyAsInt(3, 7));
        assertEquals(3, func.applyAsInt(3, 2));
    }
}
