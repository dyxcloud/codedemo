package dotest.dataDeal.数据结构;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author DongYunxiang
 * @create 2019-05-24
 **/
public class Heap {

    /*对两个子节点都是最大堆的父节点进行修复*/
    public static void maxHeapify(int arr[], int length, int root) {
        if (root >= length) return;
        int largest = root;
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != root) {
            int t = arr[root];
            arr[root] = arr[largest];
            arr[largest] = t;
            maxHeapify(arr, length, largest);
        }
    }

    @Test
    public void testreset() {
        int[] arr = {1, 8, 9, 4, 5, 6, 7};
        maxHeapify(arr, arr.length, 0);
        System.out.println(Arrays.toString(arr));
    }

}
