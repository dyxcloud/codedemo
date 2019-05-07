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

    void demo(long[] arr,int start,int end){
        if(end<=start) return;
        long value = arr[start];
        int i = start;
        int j = end;
        while(i<=j){
            while(arr[i]<value && i<end) i++;//低位找到比中间值大的数
            while(arr[j]>value && j>start) j--;//高位找到比中间值小的数
            if(i<=j){//如果低位和高位还没有交叉, 就进行交换, 这样就保证低位和高位走过的值都是左小右大
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
