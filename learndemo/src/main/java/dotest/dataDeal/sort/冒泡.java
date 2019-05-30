package dotest.dataDeal.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static dotest.dataDeal.sort.ArrayData.swap;


/**
 * @author DongYunxiang
 * @create 2019-04-15
 **/
public class 冒泡 {

    /**
     * 冒泡排序
     * @author DongYunxiang
     * @date 2017年12月18日
     * @param list
     */
    public <T extends Comparable<T>> void bubbleSort(T[] list) {
        boolean swapped = true;
        for (int i = list.length - 1; i > 0 && swapped; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    /**
     * 冒泡排序,自定义比较器
     * @author DongYunxiang
     * @date 2017年12月18日
     * @param list
     * @param comp
     */
    public <T extends Comparable<T>> void bubbleSort(T[] list, Comparator<T> comp) {
        boolean swapped = true;
        for (int i = list.length - 1; i > 0 && swapped; i--) {
            swapped = false;
            for (int j = 0; j < i; j++) {
                if (comp.compare(list[j], list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

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
