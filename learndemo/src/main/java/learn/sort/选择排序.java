package learn.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author DongYunxiang
 * @create 2019-04-15
 **/
public class 选择排序 extends SortFunction {

    void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//确定第i位
            int minP = i;
            for (int p = i + 1; p < arr.length; p++) {
                if (arr[p] < arr[minP]) {
                    minP = p;
                }
            }
            if (minP != i) {
                swap(arr, i, minP);
            }
        }
    }

    @Test
    public void testdoit() {
        int[] arr = getArr();
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
