package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

/**
 * @author DongYunxiang
 * @create 2021-05-13
 **/
public class L283移动零 {

    //插排
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) continue;
            for (int p = i; p < end; p++) {
                int tmp = nums[p];
                nums[p] = nums[p + 1];
                nums[p + 1] = tmp;
            }
            end--;
        }
    }

    //直接向前覆盖, 后面填充0
    public void moveZeroes1(int[] nums) {
        int numSize = 0;//非0数size
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[numSize++] = nums[i];
            }
        }
        while (numSize < nums.length) {
            nums[numSize++] = 0;
        }
    }

    @Test
    public void tt() {
        Consumer<int[]> f = this::moveZeroes1;
        {
            int[] arr = {0, 1, 0, 3, 12};
            f.accept(arr);
            Assertions.assertArrayEquals(new int[]{1, 3, 12, 0, 0}, arr);
        }
    }
}
