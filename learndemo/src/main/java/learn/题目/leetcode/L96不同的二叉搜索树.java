package learn.题目.leetcode;

import org.junit.jupiter.api.Test;

import java.util.function.IntUnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
public class L96不同的二叉搜索树 {

    /**
     * 二维
     */
    public int numTrees0(int n) {
        cache = new int[n][n];
        return helper(1, n);
    }

    int[][] cache;

    private int helper(int start, int end) {
        if (start >= end) return 1;
        if (cache[start - 1][end - 1] != 0) {
            return cache[start - 1][end - 1];
        }
        int sum = 0;
        //轮流做root
        for (int i = start; i <= end; i++) {
            int l = helper(start, i - 1);
            int r = helper(i + 1, end);
            sum += (l * r);
        }
        cache[start - 1][end - 1] = sum;
        return sum;
    }

    /**
     * 一维, 结果只与元素个数有关,与起始终止无关
     * f(n) = f(0)*f(n-1)+f(1)*f(n-2)+.....+f(n-1)*f(0)
     * f2 = f0*f1+f1*f0
     */
    public int numTrees(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int l = cache[j - 1];
                int r = cache[i - j];
                cache[i] += (l * r);
            }
        }
        return cache[n];
    }

    @Test
    public void tt() {
        IntUnaryOperator func = this::numTrees;
        assertEquals(5, func.applyAsInt(3));
        assertEquals(16796, func.applyAsInt(10));
        assertEquals(1, func.applyAsInt(1));
    }
}
