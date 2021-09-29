package learn.数据结构.heap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static learn.sort.SortFunction.swap;

/**
 * @author DongYunxiang
 * @create 2019-05-24
 **/
public class Heap {

    /*对两个子节点都是最大堆的父节点进行修复*/
    public static void maxHeapify(int[] arr, int length, int rootIndex) {
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
            swap(arr, rootIndex, largest);
            maxHeapify(arr, length, largest);
        }
    }

    //堆顶修复, 迭代实现
    public static void maxHeapify2(int[] arr, int length, int rootIndex) {
        int temp = arr[rootIndex];
        /* 沿关键字较大的孩子结点向下筛选 */
        for (int j = 2 * rootIndex + 1; j < length; j = 2 * j + 1) {
            if (j < length - 1 && arr[j] < arr[j + 1])
                ++j;/* j为关键字中较大的记录的下标 */
            if (temp >= arr[j])
                break;/* rc应插入在位置s上 */
            arr[rootIndex] = arr[j];
            rootIndex = j;
        }
        arr[rootIndex] = temp;
    }


    public static void buildHeap(int[] arr) {
        if (arr.length < 2) return;
        int rootIndex = (arr.length - 2) / 2;//最后一个非叶子结点
        while (rootIndex >= 0) {
            maxHeapify2(arr, arr.length, rootIndex);
            rootIndex--;
        }
    }

    @Test
    public void testmaxHeapify() {
        int[] arr = {1, 8, 9, 4, 5, 6, 7};
        maxHeapify2(arr, arr.length, 0);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void testbuild() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
        buildHeap(arr);
        System.out.println(Arrays.toString(arr));
    }

}
