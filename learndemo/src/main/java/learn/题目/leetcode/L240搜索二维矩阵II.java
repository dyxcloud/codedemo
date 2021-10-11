package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

@SuppressWarnings("NonAsciiCharacters")
public class L240搜索二维矩阵II {

    Boolean[][] cache;

    /**
     * 从0,0探索, 二叉树展开dfs
     * 因为坐标会出现重复执行,加入缓存
     */
    public boolean searchMatrix0(int[][] matrix, int target) {
        cache = new Boolean[matrix.length][matrix[0].length];
        return dfs(matrix, target, 0, 0);
    }

    private boolean dfs(int[][] matrix, int target, int x, int y) {
        if (x >= matrix[0].length) return false;
        if (y >= matrix.length) return false;
        if (matrix[y][x] == target) return true;
        if (matrix[y][x] > target) return false;
        if (cache[y][x] != null) return cache[y][x];
        boolean nextX = dfs(matrix, target, x + 1, y);
        boolean nextY = dfs(matrix, target, x, y + 1);
        cache[y][x] = nextX || nextY;
        return cache[y][x];
    }


/*
a b c d q
e f g h w
i j k l e
m n o p r
z x c v b

1, 4, 7, 11, 15
2, 5, 8, 12, 19
3, 6, 9, 16, 22
10, 13, 14, 17, 24
18, 21, 23, 26, 30
x,y的左上部分一定小于xy, 右下部分一定大于xy, 其余部分不确定
 */

    /**
     * 二分法,四个象限
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        return dfsBinarySearch(matrix, target, 0, 0, matrix[0].length - 1, matrix.length - 1);
    }

    private boolean dfsBinarySearch(int[][] matrix, int target, int lx, int ly, int rx, int ry) {
        if (matrix[ry][rx] < target) return false;
        if (matrix[ly][lx] > target) return false;
        if (matrix[ly][lx] == target) return true;
        if (matrix[ry][rx] == target) return true;
        if (matrix[ly][rx] == target) return true;
        if (matrix[ry][lx] == target) return true;
        int x1, x2, y1, y2;
        if (rx - lx > 1) {
            int mx = lx + (rx - lx) / 2;
            x1 = mx - 1;
            x2 = mx;
        } else {
            x1 = lx;
            x2 = rx;
        }
        if (ry - ly > 1) {
            int my = ly + (ry - ly) / 2;
            y1 = my - 1;
            y2 = my;
        } else {
            y1 = ly;
            y2 = ry;
        }
        boolean b = dfsBinarySearch(matrix, target, lx, ly, x1, y1);//第二象限
        if (b) return true;
        b = dfsBinarySearch(matrix, target, x2, ly, rx, y1);//第一象限
        if (b) return true;
        b = dfsBinarySearch(matrix, target, lx, y2, x1, ry);//第三象限
        if (b) return true;
        b = dfsBinarySearch(matrix, target, x2, y2, rx, ry);//第四象限
        if (b) return true;
        return false;
    }

    @Test
    public void tt() {
        BiPredicate<int[][], Integer> func = this::searchMatrix;
        {
            int[][] data = {
                    {1, 4, 7, 11, 15},
                    {2, 5, 8, 12, 19},
                    {3, 6, 9, 16, 22},
                    {10, 13, 14, 17, 24},
                    {18, 21, 23, 26, 30}
            };
            Assertions.assertTrue(func.test(data, 5));
        }
        {
            int[][] data = {
                    {1, 4, 7, 11, 15},
                    {2, 5, 8, 12, 19},
                    {3, 6, 9, 16, 22},
                    {10, 13, 14, 17, 24},
                    {18, 21, 23, 26, 30}
            };
            Assertions.assertFalse(func.test(data, 20));
        }
        {
            int[][] data = {
                    {1, 4, 7, 11},
                    {2, 5, 8, 12},
                    {3, 6, 9, 16},
                    {10, 13, 14, 17},
                    {18, 21, 23, 26}
            };
            Assertions.assertTrue(func.test(data, 5));
        }
        {
            int[][] data = {
                    {1, 4, 7, 11, 15},
                    {2, 5, 8, 12, 19},
                    {3, 6, 9, 16, 22},
                    {10, 13, 14, 17, 24},
            };
            Assertions.assertTrue(func.test(data, 5));
        }
        {
            int[][] data = {
                    {1, 4},
                    {2, 5}
            };
            Assertions.assertTrue(func.test(data, 2));
        }
    }
}
