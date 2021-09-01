package learn.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author DongYunxiang
 * @create 2019-04-15
 **/
public class SortFunction {

    public int[] getArr(){
        Random random = new Random();
        return random.ints(0,100).limit(10).toArray();
    }

    public static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    public boolean isSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testGetArr() {
        System.out.println(Arrays.toString(getArr()));
    }
}
