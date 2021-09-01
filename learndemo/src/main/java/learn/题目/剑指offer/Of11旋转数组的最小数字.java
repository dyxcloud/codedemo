package learn.题目.剑指offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author DongYunxiang
 * @create 2019-12-10
 **/
@SuppressWarnings("NonAsciiCharacters")
public class Of11旋转数组的最小数字 {


    public int minArray(int[] arr) {
        if (arr == null || arr.length == 0) return -1;
        if (arr.length == 1) return arr[0];
        if (arr[0] < arr[arr.length - 1]) return arr[0];

        int l = 0, r = arr.length - 1;
        int m = l + (r - l) / 2;
        if (arr[l] == arr[m] && arr[m] == arr[r])
            return fore(arr);

        while (l < r) {
            m = l + (r - l) / 2;
            //[[l,,,,m],[m+1,,,,r]]
            if (arr[m] <= arr[r])//因为相邻时m=l所以要与r比较
                r = m;
            else
                l = m + 1;
        }
        return arr[r];
    }

    public int fore(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) return arr[i];
        }
        return arr[0];
    }

    @Test
    public void test(){
        Assertions.assertEquals(1, minArray(new int[]{4,5,6,7,1,2,3}));
        Assertions.assertEquals(1, minArray(new int[]{3,1,2}));
        Assertions.assertEquals(1, minArray(new int[]{3,4,5,1,2}));
        Assertions.assertEquals(1, minArray(new int[]{4,5,6,7,1}));
        Assertions.assertEquals(1, minArray(new int[]{7,1,2,3,4,5,6}));
        Assertions.assertEquals(1, minArray(new int[]{2,1}));

        Assertions.assertEquals(1, minArray(new int[]{4,5,6,7,1,1,2,3}));
        Assertions.assertEquals(1, minArray(new int[]{1,1,1}));
        Assertions.assertEquals(1, minArray(new int[]{2,2,2,2,2,1,2}));
        Assertions.assertEquals(1, minArray(new int[]{2,1,2,2,2,2,2}));
        Assertions.assertEquals(1, minArray(new int[]{3,3,3,3,3,1,2,2,2}));
        Assertions.assertEquals(1, minArray(new int[]{3,1,2,2,2,2,2,2,2}));
        Assertions.assertEquals(1, minArray(new int[]{4,5,6,6,7,1,2,3,4}));

        Assertions.assertEquals(-1, minArray(new int[]{}));
        Assertions.assertEquals(-1, minArray(null));

        Assertions.assertEquals(1, minArray(new int[]{1}));
        Assertions.assertEquals(1, minArray(new int[]{1,2}));
        Assertions.assertEquals(1, minArray(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }
}
