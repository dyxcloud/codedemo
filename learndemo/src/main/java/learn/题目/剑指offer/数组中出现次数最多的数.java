package learn.题目.剑指offer;

import org.junit.jupiter.api.Assertions;
import learn.题目.leetcode.L169多数元素;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"NonAsciiCharacters"})
public class 数组中出现次数最多的数 {

    @Test
    public void test() {
        int[] arr = {1, 2, 1, 1, 1, 4, 1, 5, 1, 6};
        Assertions.assertEquals(1, MoreThanHalfNum_Solution(arr));
    }

    public static int MoreThanHalfNum_Solution(int... array) {
        L169多数元素 l169 = new L169多数元素();
        return l169.majorityElement1(array);
    }
}
