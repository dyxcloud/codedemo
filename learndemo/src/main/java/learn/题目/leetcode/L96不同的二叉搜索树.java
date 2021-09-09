package learn.题目.leetcode;

import org.junit.jupiter.api.Test;

import java.util.function.IntUnaryOperator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
public class L96不同的二叉搜索树 {

    public int numTrees(int n) {
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

    @Test
    public void tt() {
        IntUnaryOperator func = this::numTrees;
        assertEquals(5, func.applyAsInt(3));
        assertEquals(16796, func.applyAsInt(10));
        assertEquals(1, func.applyAsInt(1));
    }
}
