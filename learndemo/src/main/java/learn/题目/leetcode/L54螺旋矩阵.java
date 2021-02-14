package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L54螺旋矩阵 {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;//y
        int n = matrix[0].length;//x
        int sum = m * n;
        List<Integer> result = new ArrayList<>(sum);
        int x = 0, y = 0;
        while (result.size() < sum) {
            while (x < n && matrix[y][x] < 1_000) {
                result.add(matrix[y][x]);
                matrix[y][x] = 1000;
                x++;
            }
            x--;
            y++;
             while (y < m && matrix[y][x] < 1_000) {
                result.add(matrix[y][x]);
                matrix[y][x] = 1000;
                y++;
            }
            y--;
            x--;
            while (x >= 0 && matrix[y][x] < 1_000) {
                result.add(matrix[y][x]);
                matrix[y][x] = 1000;
                x--;
            }
            x++;
            y--;
            while (y >= 0 && matrix[y][x] < 1_000) {
                result.add(matrix[y][x]);
                matrix[y][x] = 1000;
                y--;
            }
            y++;
            x++;
        }
        return result;
    }

    @Test
    public void te() {
        TestCase.assertEquals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)
                , spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
