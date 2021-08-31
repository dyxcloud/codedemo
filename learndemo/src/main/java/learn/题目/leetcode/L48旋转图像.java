package learn.题目.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("NonAsciiCharacters")
public class L48旋转图像 {
    
    /*
1   2   3
4   5   6
7   8   9

7   4   1
8   5   2
9   6   3

1: 00>02
2: 01>12
3: 02>22

x,y
y,l-1-x
     */

    int[] startPoint = {-1, -1};

    public void rotate(int[][] matrix) {
        for (int x = 0; x < matrix.length / 2; x++) {
            for (int y = x; y < matrix.length - x - 1; y++) {
                startPoint[0] = x;
                startPoint[1] = y;
                move(matrix, x, y);
            }
        }
    }

    private void move(int[][] matrix, int x, int y) {
        int value = matrix[x][y];
        int x2 = y;
        int y2 = matrix.length - 1 - x;
        if (x2 != startPoint[0] || y2 != startPoint[1]) {
            move(matrix, x2, y2);
        }
        matrix[x2][y2] = value;
    }

    @Test
    public void tt() {
        Consumer<int[][]> func = this::rotate;
        {
            int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            func.accept(matrix);
            int[] ints = Stream.of(matrix).flatMapToInt(IntStream::of).toArray();
            Assert.assertArrayEquals(new int[]{7, 4, 1, 8, 5, 2, 9, 6, 3}, ints);
        }
        {
            int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
            func.accept(matrix);
            int[] ints = Stream.of(matrix).flatMapToInt(IntStream::of).toArray();
            Assert.assertArrayEquals(new int[]{15, 13, 2, 5, 14, 3, 4, 1, 12, 6, 8, 9, 16, 7, 10, 11}, ints);
        }
        {
            int[][] matrix = {{1}};
            func.accept(matrix);
            int[] ints = Stream.of(matrix).flatMapToInt(IntStream::of).toArray();
            Assert.assertArrayEquals(new int[]{1}, ints);
        }
        {
            int[][] matrix = {{1, 2}, {3, 4}};
            func.accept(matrix);
            int[] ints = Stream.of(matrix).flatMapToInt(IntStream::of).toArray();
            Assert.assertArrayEquals(new int[]{3, 1, 4, 2}, ints);
        }
    }
}
