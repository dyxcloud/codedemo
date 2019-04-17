package dotest.dataDeal.sort;

import org.junit.Test;

import java.util.Arrays;

import static dotest.dataDeal.sort.ArrayData.swap;


/**
 * @author DongYunxiang
 * @create 2019-04-15
 **/
public class 冒泡 {

    public static void main(String[] args) {
        int a[] = ArrayData.ARR;
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    void doit(int[] arr) {
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
