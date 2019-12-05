package learn.sort;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author DongYunxiang
 * @create 2019-05-31
 **/
public class 计数排序 {

    public void sort(int[] a) {
        int len = a.length;
        final int MAX = 256;
        int[] c = new int[MAX];//计数数组
        int[] b = new int[MAX];//结果数组
        for (int anA : a) {
            c[anA]++;
        }
        for (int i = 1; i < MAX; i++) {//对计数求和
            c[i] += c[i-1];
        }
        for (int i = len - 1; i >= 0; i--) {
            b[c[a[i]] - 1] = a[i];//将这个数赋予这个数所在的位置
            c[a[i]]--;//相同数字放在前一位
        }
        System.arraycopy(b, 0, a, 0, len);
    }

    @Test
    public void testSort(){
        int[] ar = ArrayData.getIntArr();
        sort(ar);
        System.out.println(Arrays.toString(ar));
        TestCase.assertTrue(ArrayData.isSort(ar));
    }
}
