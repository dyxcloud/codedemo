package learn.sort;

import org.junit.jupiter.api.Assertions;
import learn.数据结构.Heap;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author DongYunxiang
 * @create 2019-05-25
 **/
public class 堆排序 extends SortFunction{

    public void sort(int[] arr) {
        Heap.buildHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            Heap.maxHeapify(arr, i, 0);
        }
    }

    public void sortWithPriorityQueue(int[] arr) {
        PriorityQueue<Integer> heap = IntStream.of(arr).boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));
        int i = 0;
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }

    @Test
    public void testSort(){
        int[] arr = getArr();
        sort(arr);
        System.out.println(Arrays.toString(arr));
        Assertions.assertTrue(isSort(arr));
    }

    @Test
    public void testsortWithPriorityQueue(){
        int[] arr = getArr();
        sortWithPriorityQueue(arr);
        System.out.println(Arrays.toString(arr));
        Assertions.assertTrue(isSort(arr));
    }

}
