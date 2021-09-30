package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L221最大正方形 {
    
    /*
data:
1 0 1 1 1 
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

向右下延伸的边长:
1 0 3 2 1
1 0 2 2 1
1 1 1 1 1
1 0 0 1 0

l(x) = 0 
       min(l右,l下,l右下) + 1
     */

    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int lengthX = matrix[0].length;
        int[] cache = new int[matrix.length * lengthX];
        for (int y = matrix.length - 1; y >= 0; y--) {
            for (int x = lengthX - 1; x >= 0; x--) {
                int current = matrix[y][x] == '1' ? 1 : 0;
                //获取右/下/右下的值
                if (current != 0 && x + 1 < lengthX && y + 1 < matrix.length) {
                    int l1 = cache[y * lengthX + x + 1];
                    int l2 = cache[(y + 1) * lengthX + x];
                    int l3 = cache[(y + 1) * lengthX + x + 1];
                    current += Math.min(Math.min(l1, l2), l3);
                }
                if (current > max) max = current;
                cache[y * lengthX + x] = current;
            }
        }
        return max * max;
    }


    @Test
    public void tt() {
        ToIntFunction<char[][]> func = this::maximalSquare;
        {
            char[][] data = {
                    {'1', '0', '1', '0', '0'},
                    {'1', '0', '1', '1', '1'},
                    {'1', '1', '1', '1', '1'},
                    {'1', '0', '0', '1', '0'}
            };
            Assertions.assertEquals(4, func.applyAsInt(data));
        }
        {
            char[][] data = {
                    {'0', '1'},
                    {'1', '0'}
            };
            Assertions.assertEquals(1, func.applyAsInt(data));
        }
        {
            char[][] data = {
                    {'0'}
            };
            Assertions.assertEquals(0, func.applyAsInt(data));
        }
        {
            char[][] data = {
                    {'1', '1', '0', '1'},
                    {'1', '1', '0', '1'},
                    {'1', '1', '1', '1'}
            };
            Assertions.assertEquals(4, func.applyAsInt(data));
        }
    }
}
