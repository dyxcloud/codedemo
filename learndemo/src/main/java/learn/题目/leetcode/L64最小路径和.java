package learn.题目.leetcode;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
public class L64最小路径和 {

/*
1 3 1
1 5 1
4 2 1
 */

    /**
     * DP 递归解法 
     */
    public int minPathSum(int[][] grid) {
        cache = new int[grid.length][grid[0].length];
        return helper(grid, grid[0].length - 1, grid.length - 1);
    }

    int[][] cache;

    /**
     * @param x 横坐标
     * @param y 纵坐标
     */
    public int helper(int[][] grid, int x, int y) {
        if (x == 0 && y == 0) {
            return grid[0][0];
        }
        if (cache[y][x] != 0) {
            return cache[y][x];
        }
        if (x == 0) {
            //y轴求和
            int sum = 0;
            for (int i = 0; i <= y; i++) {
                sum += grid[i][0];
            }
            cache[y][x] = sum;
            return sum;
        } else if (y == 0) {
            //x轴求和
            int sum = 0;
            for (int i = 0; i <= x; i++) {
                sum += grid[0][i];
            }
            cache[y][x] = sum;
            return sum;
        }
        int min = Math.min(helper(grid, x - 1, y), helper(grid, x, y - 1));
        int result = min + grid[y][x];
        cache[y][x] = result;
        return result;
    }

    @Test
    public void t() {
        ToIntFunction<int[][]> func = this::minPathSum;
        {
            int[][] data = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
            assertEquals(7, func.applyAsInt(data));
        }
        {
            int[][] data = {{1, 2, 3}, {4, 5, 6}};
            assertEquals(12, func.applyAsInt(data));
        }
    }
}
