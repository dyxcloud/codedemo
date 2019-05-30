package dotest.dataDeal.sort;

import dotest.dataDeal.数据结构.Heap;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

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

    public void sortWithPriorityQueue(long[] arr){
        PriorityQueue<Long> heap = LongStream.of(arr).boxed().collect(Collectors.toCollection(PriorityQueue::new));
       int i = 0;
       while(!heap.isEmpty()){
           arr[i++] = heap.poll();
       }
    }

    @Test
    public void testSort(){
        sort(ArrayData.ARR);
        System.out.println(Arrays.toString(ArrayData.ARR));
        TestCase.assertTrue(ArrayData.isSort(ArrayData.ARR));
    }

    @Test
    public void testsortWithPriorityQueue(){
        sortWithPriorityQueue(ArrayData.ARR);
        System.out.println(Arrays.toString(ArrayData.ARR));
        TestCase.assertTrue(ArrayData.isSort(ArrayData.ARR));
    }

}
