package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

@SuppressWarnings("NonAsciiCharacters")
public class L207课程表 {


    /**
     * 判断是否能走完
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        return true;
    }

    @Test
    public void tt() {
        BiPredicate<Integer, int[][]> func = this::canFinish;
        {
            int[][] data = {{1, 0}};
            Assertions.assertTrue(func.test(2, data));
        }
        {
            int[][] data = {{1, 0}, {0, 1}};
            Assertions.assertFalse(func.test(2, data));
        }
        {
            int[][] data = {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
            Assertions.assertFalse(func.test(20, data));
        }
    }
}
