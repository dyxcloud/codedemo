package dotest.dataDeal.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author DongYunxiang
 * @create 2019-04-17
 **/
public class 插入排序 {

    public void insertSort(int[] a){
        int length=a.length;//数组长度，将这个提取出来是为了提高速度。
        int insertNum;//要插入的数
        for(int i=1;i<length;i++){//插入的次数
            insertNum=a[i];//要插入的数
            int j=i-1;//已经排序好的序列元素个数
            while(j>=0&&a[j]>insertNum){//序列从后到前循环，将大于insertNum的数向后移动一格
                a[j+1]=a[j];//元素移动一格
                j--;
            }
            a[j+1]=insertNum;//将需要插入的数放在要插入的位置。
        }
    }

    @Test
    public void testinsertSort(){
        insertSort(ArrayData.ARR);
        System.out.println(Arrays.toString(ArrayData.ARR));
    }
}
