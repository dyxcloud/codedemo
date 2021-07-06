package learn.sort;

import junit.framework.TestCase;
import org.junit.Test;

public class 希尔排序 extends SortFunction {

    public void sheelSort(int[] arr) {
        int increment = arr.length;
        while (increment > 1) {
            increment = increment / 2;
            for (int x = 0; x < increment; x++) {//x是每组的第一个元素
                //组内插排
                for (int i = x + increment; i < arr.length; i += increment) {
                    int j = i - increment;//j为有序序列最后一位的位数
                    int insertNum = arr[i];//要插入的元素
                    while (j >= 0 && insertNum < arr[j]) {//从后往前遍历。
                        arr[j + increment] = arr[j];//向后移动d位
                        j -= increment;
                    }
                    arr[j + increment] = insertNum;
                }
            }
        }
    }

    @Test
    public void tt() {
        int[] arr = getArr();
        sheelSort(arr);
        TestCase.assertTrue(isSort(arr));
    }

}
