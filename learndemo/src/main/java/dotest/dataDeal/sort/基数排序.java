package dotest.dataDeal.sort;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 * @author DongYunxiang
 * @create 2019-05-31
 **/
public class 基数排序 {

    public int n = 10;

    /**先对个位进行排序, 再对十位进行排序(保证稳定性)*/
    public void sort(int[] a) {
        int[] c = new int[n];
        int[] remainder = new int[a.length];
        int[] b = new int[a.length];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < a.length; j++) {
                int temp = getRadix(a[j], i, n);
                remainder[j] = temp;
                c[temp]++;
            }
            for (int k = 1; k < n; k++) {
                c[k] += c[k - 1];
            }
            for (int j = a.length - 1; j >= 0; j--) {
                b[--c[remainder[j]]] = a[j];
            }
            for (int j = 0; j < n; j++) {
                c[j] = 0;
            }
            System.arraycopy(b, 0, a, 0, a.length);
        }
    }

    private int getRadix(int a, int i, int radix) {
        return ((int)(a / Math.pow(radix, i))) % radix;
    }

    @Test
    public void testSort(){
        int[] ar = ArrayData.getIntArr();
        sort(ar);
        System.out.println(Arrays.toString(ar));
        TestCase.assertTrue(ArrayData.isSort(ar));
    }
}
