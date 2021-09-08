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
    public void sortColors1(int[] nums) {
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

    /**
     * 双指针 O(n) 一次遍历
     * 主要难点: i与save2交换后,交换到i点的值无法保证, 还需要重新校验
     */
    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int save0 = 0;
        int save2 = nums.length - 1;
        for (int i = 0; i <= save2; ) {
            if (nums[i] == 0) {
                swap(nums, i, save0++);
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, save2--);
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
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
            int[] data = {0, 0, 1};
            func.accept(data);
            assertArrayEquals(new int[]{0, 0, 1}, data);
        }
        {
            int[] data = {2, 1, 2};
            func.accept(data);
            assertArrayEquals(new int[]{1, 2, 2}, data);
        }
        {
            int[] data = {0};
            func.accept(data);
            assertArrayEquals(new int[]{0}, data);
        }
        {
            int[] data = {2, 2};
            func.accept(data);
            assertArrayEquals(new int[]{2, 2}, data);
        }
        {
            int[] data = {1};
            func.accept(data);
            assertArrayEquals(new int[]{1}, data);
        }

    }
}
