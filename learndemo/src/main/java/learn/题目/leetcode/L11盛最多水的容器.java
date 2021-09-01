package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L11盛最多水的容器 {

    //双重for 起始 终止 n*(n-1)*(n-2)*...*2*1

    //窗口缩小 1*2*...*(n-1)*n
    public int maxArea0(int[] height) {
        int max = -1;
        for (int len = height.length - 1; len > 0; len--) {
            for (int i = 0; i < height.length - len; i++) {
                int j = i + len;
                int tmp = len * (Math.min(height[i], height[j]));
                if (tmp > max) {
                    max = tmp;
                }
            }
        }
        return max;
    }

    /*
    双指针遍历, 每次移动低位的一侧
    为什么不移动高位? result = len * min(l,r)
    如果低位不变, 移动高位, 那么len越来越小, min(l,r)也只会变小不会增大, 不能得出比当前更大的结果
     */
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = -1;
        while (l < r) {
            int tmp = (r - l) * Math.min(height[l], height[r]);
            if (tmp > max) {
                max = tmp;
            }
            if (height[r] < height[l]) {
                r--;
            } else {
                l++;
            }
        }
        return max;
    }

    @Test
    public void tt() {
        ToIntFunction<int[]> func = this::maxArea;
        Assertions.assertEquals(49, func.applyAsInt(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        Assertions.assertEquals(1, func.applyAsInt(new int[]{1, 1}));
        Assertions.assertEquals(16, func.applyAsInt(new int[]{4, 3, 2, 1, 4}));
        Assertions.assertEquals(2, func.applyAsInt(new int[]{1, 2, 1}));
    }
}
