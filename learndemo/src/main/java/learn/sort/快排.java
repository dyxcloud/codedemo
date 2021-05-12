package learn.sort;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author DongYunxiang
 * @create 2019-04-18
 **/
public class 快排 {

    /*
    选择第一个数为p，小于p的数放在左边，大于等于p的数放在右边。(操作后p不一定在交点)
    递归的将p左边和右边的数都按照第一步进行，直到不能递归。
     */

    void demo(long[] arr,int start,int end){
        if(end<=start) return;
        long value = arr[start];
        int i = start;
        int j = end;
        while(i<=j){
            while(arr[i]<value && i<end) i++;//低位找到>=p的数
            while(arr[j]>=value && j>start) j--;//高位找到<p的数
            if(i<=j){//如果低位和高位还没有交叉, 就进行交换, 这样就保证低位和高位走过的值都是左小右大
                if(i<j){
                    ArrayData.swap(arr,i,j);
                }
                i++;
                j--;
            }
        }
        // System.out.println(Arrays.toString(arr));
        // System.out.println("i="+i+" j="+j);
        demo(arr,start,j);
        demo(arr,i,end);
    }


    @Test
    public void testquickSort() {
        {
            demo(ArrayData.ARR,0,ArrayData.ARR.length-1);
            System.out.println(Arrays.toString(ArrayData.ARR));
            TestCase.assertTrue(ArrayData.isSort(ArrayData.ARR));
        }
        {
            long[] arr = {5,5,5,8,8,1,1,1,5,5,9,9,9};
            demo(arr,0,arr.length-1);
            System.out.println(Arrays.toString(arr));
            TestCase.assertTrue(ArrayData.isSort(arr));
        }
    }


}
