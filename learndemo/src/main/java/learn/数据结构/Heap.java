package learn.数据结构;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author DongYunxiang
 * @create 2019-05-24
 **/
public class Heap {

    /*对两个子节点都是最大堆的父节点进行修复*/
    public static void maxHeapify(long[] arr, int length, int rootIndex) {
        if (rootIndex >= length) return;
        int largest = rootIndex;
        int left = rootIndex * 2 + 1;
        int right = rootIndex * 2 + 2;
        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != rootIndex) {
            long t = arr[rootIndex];
            arr[rootIndex] = arr[largest];
            arr[largest] = t;
            maxHeapify(arr, length, largest);
        }
    }

    public static void buildHeap(long[] arr){
        if(arr.length<2) return;
        int rootIndex = (arr.length-2)/2;
        while(rootIndex>=0){
            maxHeapify(arr,arr.length,rootIndex);
            rootIndex--;
        }
    }

    @Test
    public void testmaxHeapify() {
        long[] arr = {1, 8, 9, 4, 5, 6, 7};
        maxHeapify(arr, arr.length, 0);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testbuild(){
        long[] arr = {0,1,2,3,4,5,6,7};
        buildHeap(arr);
        System.out.println(Arrays.toString(arr));
    }

}
