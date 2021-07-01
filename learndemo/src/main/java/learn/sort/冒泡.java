package learn.sort;

import junit.framework.TestCase;
import org.junit.Test;


/**
 * @author DongYunxiang
 * @create 2017年12月18日
 **/
public class 冒泡 extends SortFunction {

    void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int n = arr.length - 1; n > i; n--) {
                if (arr[n] < arr[n - 1]) {
                    swap(arr, n, n - 1);
                }
            }
        }
    }

    void bubbleSort2(int[] arr) {
        boolean swapped = true;
        for (int i = 0; i < arr.length - 1 && swapped; i++) {
            swapped = false;//如果标记没有被置为true,说明后面已经有序
            for (int n = arr.length - 1; n > i; n--) {
                if (arr[n] < arr[n - 1]) {
                    swap(arr, n, n - 1);
                    swapped = true;
                }
            }
        }
    }

    @Test
    public void testdoit() {
        int[] arr = getArr();
        bubbleSort2(arr);
        TestCase.assertTrue(isSort(arr));
    }

}
