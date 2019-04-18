package dotest.dataDeal.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author DongYunxiang
 * @create 2019-04-17
 **/
public class 插入排序 {

    /*
    首先设定插入次数，即循环次数，for(int i=1;i
    设定插入数和得到已经排好序列的最后一个数的位数。insertNum和j=i-1。
    从最后一个数开始向前循环，如果插入数小于当前数，就将当前数向后移动一位。
    将当前数放置到空着的位置，即j+1。
     */

    public void insertSort(long[] a) {
        int length = a.length;//数组长度，将这个提取出来是为了提高速度。
        long insertNum;//要插入的数
        for (int i = 1; i < length; i++) {//插入的次数
            insertNum = a[i];//要插入的数
            int j = i - 1;//已经排序好的序列元素个数
            while (j >= 0 && a[j] > insertNum) {//序列从后到前循环，将大于insertNum的数向后移动一格
                a[j + 1] = a[j];//元素移动一格
                j--;
            }
            a[j + 1] = insertNum;//将需要插入的数放在要插入的位置。
        }
    }

    @Test
    public void testinsertSort() {
        insertSort(ArrayData.ARR);
        System.out.println(Arrays.toString(ArrayData.ARR));
    }

    void doit(long[] arr){
        for(int i=1;i<arr.length;i++){//默认数组第0位是有序数组,从第1位开始进行插入
            long value = arr[i];//需要定位的数值
            int index = i;//未定位的数值的索引
            while(index>0 && value<arr[index-1]){
                arr[index] = arr[index-1];
                index--;
            }
            arr[index] = value;
        }
    }

    @Test
    public void testdoit() {
        doit(ArrayData.ARR);
        System.out.println(Arrays.toString(ArrayData.ARR));

    }
}
