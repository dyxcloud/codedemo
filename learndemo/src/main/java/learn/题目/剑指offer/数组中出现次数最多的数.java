package learn.题目.剑指offer;

import junit.framework.TestCase;
import org.junit.Test;

@SuppressWarnings({"NonAsciiCharacters"})
public class 数组中出现次数最多的数 {

    @Test
    public void test() {
        int[] arr = {1, 2, 1, 1, 1, 4, 1, 5, 1, 6};
        TestCase.assertEquals(1, MoreThanHalfNum_Solution(arr));
    }

    public static int MoreThanHalfNum_Solution(int... array) {
        //非法输入判断
        if (array == null || array.length <= 0)
            return 0;
        int times = 1;
        int number = array[0];
        //查看是否存在有可能次数大于数组长度一半的数字
        for (int i = 1; i < array.length; i++) {
            if (times <= 0) {
                number = array[i];
                times = 0;
            }
            if (array[i] == number) {
                times++;
            } else {
                times--;
            }
        }
        //判断该数字次数是否大于数组长度一半
        if (times > 0) {
            int count = 0;
            for (int value : array) {
                if (value == number)
                    count++;
            }
            if (count > array.length / 2)
                return number;
            else
                return 0;
        } else
            return 0;
    }
}
