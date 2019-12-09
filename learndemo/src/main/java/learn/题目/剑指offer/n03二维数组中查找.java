package learn.题目.剑指offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2019-12-06
 **/
@SuppressWarnings("NonAsciiCharacters")
public class n03二维数组中查找 {

    public boolean find(int[][] arr, int target) {
        if(arr==null||arr.length==0||arr[0].length==0)
            return false;
        int x = arr.length - 1, y = 0;//右上角
        while (x >= 0 && y < arr[0].length) {
            int tmp = arr[x][y];
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
        Assert.assertEquals(true, find(arr, 7));
        Assert.assertEquals(true, find(arr, 1));
        Assert.assertEquals(true, find(arr, 15));
        Assert.assertEquals(false, find(arr, 0));
        Assert.assertEquals(false, find(arr, 99));
        Assert.assertEquals(false, find(arr, 3));
        Assert.assertEquals(false, find(null, 3));
    }
}
