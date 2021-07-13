package learn.sort;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author DongYunxiang
 * @create 2019-04-18
 **/
public class 快速排序 extends SortFunction {

    /*
    选择第一个数为p，小于p的数放在左边，大于等于p的数放在右边。(操作后p不一定在交点)
    递归的将p左边和右边的数都按照第一步进行，直到不能递归。
     */

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    void quickSort(int[] arr, int low, int high) {
        if (high <= low) return;
        int pivot = partition(arr, low, high);
        quickSort(arr, low, pivot - 1);
        quickSort(arr, pivot + 1, high);
    }

    int partition(int[] arr, int low, int high) {
        int pivotKey = arr[low];//用第一个元素作为枢轴
        while (low < high) {
            while (high > low && arr[high] >= pivotKey) high--;//高位找到<p的数
            swap(arr, low, high);
            while (low < high && arr[low] <= pivotKey) low++;//低位找到>=p的数
            swap(arr, low, high);
        }
        return low;
    }

    void quickSort2(int[] arr, int low, int high) {
        if (high <= low) return;
        int pivotKey = arr[low];
        int i = low, j = high;
        while (i <= j) {
            while (i <= j && arr[i] < pivotKey) i++;//低位找到>=p的数
            while (j >= i && arr[j] > pivotKey) j--;//高位找到<p的数
            if (i <= j) {//如果低位和高位还没有交叉, 就进行交换, 这样就保证低位和高位走过的值都是左小右大
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        quickSort2(arr, low, j);
        quickSort2(arr, i, high);
    }


    @Test
    public void testquickSort() {
        {
            int[] arr = getArr();
            quickSort(arr);
            System.out.println(Arrays.toString(arr));
            TestCase.assertTrue(isSort(arr));
        }
        {
            int[] arr = getArr();
            quickSort2(arr, 0, arr.length - 1);
            System.out.println(Arrays.toString(arr));
            TestCase.assertTrue(isSort(arr));
        }
    }


}
