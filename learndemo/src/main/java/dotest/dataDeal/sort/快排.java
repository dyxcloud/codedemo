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

    public static void quickSort(long[] numbers, int start, int end) {
        if (start < end) {
            long base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            long temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end))
                    i++;
                while ((numbers[j] > base) && (j > start))
                    j--;
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j)
                quickSort(numbers, start, j);
            if (end > i)
                quickSort(numbers, i, end);
        }
    }

    void doit(long arr[], int start, int end) {
        if(start>=end) return;

        System.out.print("in>>>");
        IntStream.rangeClosed(start,end).forEach(i-> System.out.print(arr[i]+", "));
        System.out.println();

        long value = arr[start];
        int index = start;
        for (int i = start+1; i <= end; i++) {
            if(arr[i]<value){
                arr[index] = arr[i];
                index = i;
            }
        }
        arr[index] = value;

        System.out.print("out>>>");
        IntStream.rangeClosed(start,end).forEach(i-> System.out.print(arr[i]+", "));
        System.out.println();

        doit(arr,start,index-1);
        doit(arr,index+1,end);
    }

    @Test
    public void testdoit() {
        doit(ArrayData.ARR,0,ArrayData.ARR.length-1);
        System.out.println(Arrays.toString(ArrayData.ARR));
        TestCase.assertTrue(ArrayData.isSort(ArrayData.ARR));
    }

}
