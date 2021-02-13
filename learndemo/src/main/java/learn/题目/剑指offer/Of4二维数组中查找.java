package learn.题目.剑指offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2019-12-06
 **/
@SuppressWarnings("NonAsciiCharacters")
public class Of4二维数组中查找 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return false;
        int x = matrix.length - 1, y = 0;//右上角
        while (x >= 0 && y < matrix[0].length) {
            int tmp = matrix[x][y];
            if (tmp == target) {
                return true;
            } else if (tmp > target) {
                x--;
            } else {
                y++;
            }
        }
        return false;
    }

    @Test
    public void testfind() {
        int[][] arr = {{1, 2, 4, 6}, {2, 4, 7, 8}, {8, 9, 10, 11}, {9, 12, 13, 15}};
        Assert.assertEquals(true, findNumberIn2DArray(arr, 7));
        Assert.assertEquals(true, findNumberIn2DArray(arr, 1));
        Assert.assertEquals(true, findNumberIn2DArray(arr, 15));
        Assert.assertEquals(false, findNumberIn2DArray(arr, 0));
        Assert.assertEquals(false, findNumberIn2DArray(arr, 99));
        Assert.assertEquals(false, findNumberIn2DArray(arr, 3));
        Assert.assertEquals(false, findNumberIn2DArray(null, 3));
    }
}
