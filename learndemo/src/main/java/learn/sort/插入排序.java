package learn.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author DongYunxiang
 * @create 2019-04-17
 **/
public class 插入排序 extends SortFunction {

    /*
    首先设定插入次数，即循环次数，for(int i=1;i
    设定插入数和得到已经排好序列的最后一个数的位数。insertNum和j=i-1。
    从最后一个数开始向前循环，如果插入数小于当前数，就将当前数向后移动一位。
    将当前数放置到空着的位置，即j+1。
     */

    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertNum = arr[i];//要插入的数
            int j = i - 1;//最后一个已排序元素
            while (j >= 0 && arr[j] > insertNum) {//从后向前一次比较
                arr[j + 1] = arr[j];//元素后移一格
                j--;
            }
            arr[j + 1] = insertNum;//将需要插入的数放在要插入的位置。
        }
    }

    @Test
    public void testinsertSort() {
        int[] arr = getArr();
        insertSort(arr);
        Assertions.assertTrue(isSort(arr));
    }

}
