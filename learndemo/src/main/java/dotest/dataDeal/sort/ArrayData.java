package dotest.dataDeal.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author DongYunxiang
 * @create 2019-04-15
 **/
public class ArrayData {

    public static final int[] ARR;

    static {
        Random random = new Random();
        ARR = random.ints(0,100).limit(25).toArray();
    }

    public static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    @Test
    public void get() {
        System.out.println(Arrays.toString(ARR));
    }
}
