package dotest.dataDeal.sort;

import dotest.dataDeal.数据结构.Heap;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author DongYunxiang
 * @create 2019-05-25
 **/
public class 堆排序 {

    public void sort(long[] arr){
        Heap.buildHeap(arr);
        for(int i = arr.length-1;i>0;i--){
            ArrayData.swap(arr,0,i);
            Heap.maxHeapify(arr,i,0);
        }
    }

    @Test
    public void testSort(){
        sort(ArrayData.ARR);
        System.out.println(Arrays.toString(ArrayData.ARR));
        TestCase.assertTrue(ArrayData.isSort(ArrayData.ARR));
    }

}
