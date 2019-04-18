package dotest.dataDeal.sort;

import org.junit.Test;

import java.util.Arrays;

import static dotest.dataDeal.sort.ArrayData.swap;


/**
 * @author DongYunxiang
 * @create 2019-04-15
 **/
public class 冒泡 {

    void doit(long[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//从0位开始获取最小的
            for (int n = arr.length - 1; n > i; n--) {
                if (arr[n] < arr[n - 1]) {
                    swap(arr, n, n - 1);
                }
            }
        }
    }

    @Test
    public void testdoit() {
        doit(ArrayData.ARR);
        System.out.println(Arrays.toString(ArrayData.ARR));
    }

}
