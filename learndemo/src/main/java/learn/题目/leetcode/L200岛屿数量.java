package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L200岛屿数量 {

    public int numIslands0(char[][] grid) {
        List<Integer> newX = new ArrayList<>();
        int count = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] != '0') {
                    if (x - 1 < 0 || grid[y][x - 1] == '0') {//左边空
                        if (y - 1 < 0 || grid[y - 1][x] == '0') {//上边空
                            count++;
                            newX.add(x);
                        }
                    } else {//左边不空
                        if (y - 1 >= 0 && grid[y - 1][x] != '0') {//上边不空
                            if (newX.contains(x)) {
                                count--;
                                newX.remove(Integer.valueOf(x));
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * 搜索标记方式
     */
    public int numIslands(char[][] grid) {
        boolean[][] walkMap = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] != '0' && !walkMap[y][x]) {
                    count++;
                    walk(grid, walkMap, x, y);
                }
            }
        }
        return count;
    }

    private void walk(char[][] grid, boolean[][] walkMap, int x, int y) {
        int[][] offsets = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] offset : offsets) {
            int nx = x + offset[0];
            int ny = y + offset[1];
            if (nx >= 0 && ny >= 0 && nx < grid[0].length && ny < grid.length//没出界
                    && grid[ny][nx] != '0'//非空
                    && !walkMap[ny][nx]) {//没走过
                walkMap[ny][nx] = true;
                walk(grid, walkMap, nx, ny);
            }
        }
    }

    @Test
    public void tt() {
        ToIntFunction<char[][]> func = this::numIslands;
        {
            char[][] grid = {
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '0', '1', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '0', '0', '0'}
            };
            Assertions.assertEquals(1, func.applyAsInt(grid));
        }
        {
            char[][] grid = {
                    {'1', '1', '0', '1', '0'},
                    {'1', '1', '1', '1', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '0', '0', '0'}
            };
            Assertions.assertEquals(1, func.applyAsInt(grid));
        }
        {
            char[][] grid = {
                    {'1', '1', '0', '0', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '1', '0', '0'},
                    {'0', '0', '0', '1', '1'}
            };
            Assertions.assertEquals(3, func.applyAsInt(grid));
        }
        {
            char[][] grid = {
                    {'1', '1', '1'},
                    {'0', '1', '0'},
                    {'1', '1', '1'}
            };
            Assertions.assertEquals(1, func.applyAsInt(grid));
        }
    }
}
