package dotest.dataDeal.sort;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author DongYunxiang
 * @create 2019-04-18
 **/
public class 快排 {

    /*
    选择第一个数为p，小于p的数放在左边，大于p的数放在右边。
    递归的将p左边和右边的数都按照第一步进行，直到不能递归。
     */

    public static void quickSort(long[] arr, int start, int end) {
        if (start < end) {
            long base = arr[start]; // 选定的基准值（第一个数值作为基准值）
            int i = start, j = end;
            do {
                while ((arr[i] < base) && (i < end))
                    i++;
                while ((arr[j] > base) && (j > start))
                    j--;
                if (i <= j) {
                    ArrayData.swap(arr,i,j);
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j)
                quickSort(arr, start, j);
            if (end > i)
                quickSort(arr, i, end);
        }
    }

    void demo(long[] arr,int start,int end){
        if(end<=start) return;
        long value = arr[start];
        int i = start;
        int j = end;
        while(i<=j){
            while(arr[i]<value && i<end) i++;
            while(arr[j]>value && j>start) j--;
            if(i<=j){
                ArrayData.swap(arr,i,j);
                i++;
                j--;
            }
        }
        demo(arr,start,j);
        demo(arr,i,end);
    }


    @Test
    public void testquickSort() {
        // quickSort(ArrayData.ARR,0,ArrayData.ARR.length-1);
        // System.out.println(Arrays.toString(ArrayData.ARR));
        // TestCase.assertTrue(ArrayData.isSort(ArrayData.ARR));

        demo(ArrayData.ARR,0,ArrayData.ARR.length-1);
        System.out.println(Arrays.toString(ArrayData.ARR));
        TestCase.assertTrue(ArrayData.isSort(ArrayData.ARR));
    }

    void doit(long arr[], int start, int end) {
    }

    @Test
    public void testdoit() {
        doit(ArrayData.ARR,0,ArrayData.ARR.length-1);
        System.out.println(Arrays.toString(ArrayData.ARR));
        TestCase.assertTrue(ArrayData.isSort(ArrayData.ARR));
    }

}
