package dotest.dataDeal.数据结构.graph;

import java.util.Arrays;

/**
 * 递增进位制法
 * N个数的全排列, 一种排列方式对应一个数字
 * N个数一共有N!种排列, 而转换获取到的数字范围正好是0~(N!-1)
 *
 * @author DongYunxiang
 * @create 2019-11-26
 **/
public class Permutation {

    /**
     * 数字转排列
     * @param index 数字
     * @param len   排列长度
     */
    public static int[] decode(int index, int len) {
        int i, base, j;
        int[] auxiliary = new int[len];
        auxiliary[len - 1] = 0;
        int[] result = new int[len];

        base = 2;
        for (i = len - 2; i >= 0; i--) {
            auxiliary[i] = index % base;
            index /= base;
            base++;
        }
        //打印aux数组
        /*for (i = 0; i < len; i++)
            System.out.print(auxiliary[i] + " ");
        System.out.println();*/

        for (i = 0; i < len; i++) {
            for (j = 0; j < len; j++) {
                if (auxiliary[j] == 0) {
                    result[j] = i;
                    auxiliary[j] = -1;
                    break;
                } else if (auxiliary[j] > 0)
                    auxiliary[j]--;
            }
        }
        //打印排列数组
        /*for (i = 0; i < len; i++)
            System.out.print(result[i] + " ");
        System.out.println();*/
        return result;
    }

    /**
     * 排列转数字
     * @param array 排列
     * @param len   排列长度
     */
    public static int encode(int[] array, int len) {
        int i, j, single, base, total = 0;
        if (len < 3)
            return -1;

        base = 1;
        for (i = len - 2; i >= 0; i--) {
            single = 0;
            base *= len - i - 1;
            for (j = len - 1; j > i; j--) {
                if (array[i] > array[j])
                    single++;
            }
            total += single * base;
        }
        return total;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 119; i++) {
            int[] result = decode(i, 5);
            System.out.println(Arrays.toString(result));
        }

        System.out.println(Arrays.toString(decode(362879,9)));
        System.out.println(encode(new int[]{8, 7, 6, 5, 4, 3, 2, 1, 0}, 9));
    }
}
