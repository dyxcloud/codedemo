package learn.题目.leetcode;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("NonAsciiCharacters")
public class L75颜色分类 {

    /**
     * 插排 O(n^2)
     */
    public void sortColors0(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            final int tmp = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > tmp) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = tmp;
        }
    }

    /**
     * 计数法 O(n)
     */
    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int[] countArr = {0, 0, 0};
        for (int i : nums) {
            countArr[i]++;
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            int count = countArr[i];
            for (int j = 0; j < count; j++) {
                nums[index++] = i;
            }
        }
    }

    @Test
    public void tt() {
        Consumer<int[]> func = this::sortColors;
        {
            int[] data = {2, 1, 0};
            func.accept(data);
            assertArrayEquals(new int[]{0, 1, 2}, data);
        }
        {
            int[] data = {2, 0, 2, 1, 1, 0};
            func.accept(data);
            assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, data);
        }
        {
            int[] data = {2, 0, 1};
            func.accept(data);
            assertArrayEquals(new int[]{0, 1, 2}, data);
        }
        {
            int[] data = {0};
            func.accept(data);
            assertArrayEquals(new int[]{0}, data);
        }
        {
            int[] data = {1};
            func.accept(data);
            assertArrayEquals(new int[]{1}, data);
        }

    }
}
