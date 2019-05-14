package dotest.dataDeal;

import java.util.Random;

/**
 * @author DongYunxiang
 * @create 2019-04-15
 **/
public class 字符串字母次数 {
    public static void main(String[] args) {
        test();
    }

    /*
     * 统计字符串
     */
    public static void test() {
        String str = newStrArray(20);
        // String str = new String("abcdabcaba");

        // 打印原字符串
        System.out.println(str);
        System.out.println("=================");

        str = str.toUpperCase();
        char[] arrs = str.toCharArray();
        int[][] nums = new int[26][2];// 26个字母数组的数组,字母数组包含char值和次数两个元素
        for (int i = 0; i < nums.length; i++) {
            nums[i][0] = 'A' + i;// 给字母char值赋值
        }
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (arrs[i] == ('A' + j)) {
                    nums[j][1]++;// 表示该字母的次数
                }
            }
        }
        // 从大到小冒泡排序
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j][1] < nums[j + 1][1]) {
                    int[] temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        // 遍历二维数组,打印字母和次数
        for (int[] is : nums) {
            System.out.println((char) is[0] + "共出现了" + is[1] + "次");
        }
    }

    /*
     * 生成n位的纯字母随机字符串
     */
    public static String newStrArray(int n) {
        // 生成100位的随机A-Z的字符串
        Random rd = new Random();
        char[] chs = new char[20];
        for (int i = 0; i < chs.length; i++) {
            int seed = rd.nextInt(2);
            if (seed == 1) {
                chs[i] = (char) (rd.nextInt('z' - 'a' + 1) + 'a');
            } else {
                chs[i] = (char) (rd.nextInt('Z' - 'A' + 1) + 'A');
            }
        }
        String str = new String(chs);
        return str;
    }
}
