package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L200岛屿数量 {

    /**
     * 搜索标记方式 DFS
     */
    public int numIslands0(char[][] grid) {
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


    /**
     * 并查集 QuickUnion Rank 路径减半
     */
    int lengthX;
    int[] parents;
    int[] ranks;
    int count;

    public int numIslands(char[][] grid) {
        //初始化并查集
        lengthX = grid[0].length;
        parents = new int[lengthX * grid.length];
        ranks = new int[lengthX * grid.length];
        count = 0;
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
            ranks[i] = 1;
        }
        //进行遍历合并
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '1') {
                    count++;
                    //左边或者上边非空,就合并
                    if (x - 1 >= 0 && grid[y][x - 1] == '1') {
                        union(y * lengthX + x, y * lengthX + x - 1);
                    }
                    if (y - 1 >= 0 && grid[y - 1][x] == '1') {
                        union(y * lengthX + x, (y - 1) * lengthX + x);
                    }
                }
            }
        }
        return count;
    }

    private void union(int v1, int v2) {
        if (v1 == v2) return;
        int p1 = find(v1);
        int p2 = find(v2);
        if (p1 == p2) return;
        if (ranks[p1] > ranks[p2]) {
            parents[p2] = p1;
        } else if (ranks[p1] < ranks[p2]) {
            parents[p1] = p2;
        } else {
            parents[p1] = p2;
            ranks[p2]++;
        }
        count--;
    }

    private int find(int v) {
        while (v != parents[v]) {
            parents[v] = parents[parents[v]];//路径减半
            v = parents[v];
        }
        return v;
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
        {
            char[][] grid = {
                    {'1', '1', '1', '1', '1', '0', '1', '1', '1', '1'},
                    {'1', '0', '1', '0', '1', '1', '1', '1', '1', '1'},
                    {'0', '1', '1', '1', '0', '1', '1', '1', '1', '1'},
                    {'1', '1', '0', '1', '1', '0', '0', '0', '0', '1'},
                    {'1', '0', '1', '0', '1', '0', '0', '1', '0', '1'},
                    {'1', '0', '0', '1', '1', '1', '0', '1', '0', '0'},
                    {'0', '0', '1', '0', '0', '1', '1', '1', '1', '0'},
                    {'1', '0', '1', '1', '1', '0', '0', '1', '1', '1'},
                    {'1', '1', '1', '1', '1', '1', '1', '1', '0', '1'},
                    {'1', '0', '1', '1', '1', '1', '1', '1', '1', '0'}
            };
            Assertions.assertEquals(2, func.applyAsInt(grid));
        }
    }
}
