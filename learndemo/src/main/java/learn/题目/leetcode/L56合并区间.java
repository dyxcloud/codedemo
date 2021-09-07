package learn.题目.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("NonAsciiCharacters")
public class L56合并区间 {

    /**
     * 排序+双指针
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int[] zone = intervals[0];
        int i = 1;
        while (i < intervals.length) {
            int[] p = intervals[i];
            if (p[0] <= zone[1]) {
                if (p[1] > zone[1]) {
                    zone[1] = p[1];
                }
            } else {
                result.add(zone);
                zone = p;
            }
            i++;
        }
        result.add(zone);
        return result.toArray(new int[result.size()][]);
    }

    @Test
    public void tt() {
        Function<int[][], int[][]> func = this::merge;
        {
            int[][] data = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
            int[][] test = {{1, 6}, {8, 10}, {15, 18}};
            assertArrayEquals(test, func.apply(data));
        }
        {
            int[][] data = {{1, 4}, {4, 5}};
            int[][] test = {{1, 5}};
            assertArrayEquals(test, func.apply(data));
        }
        {
            int[][] data = {{1, 4}, {0, 4}};
            int[][] test = {{0, 4}};
            assertArrayEquals(test, func.apply(data));
        }
        {
            int[][] data = {{1, 4}, {2, 3}};
            int[][] test = {{1, 4}};
            assertArrayEquals(test, func.apply(data));
        }
        {
            int[][] data = {{1, 4}, {5, 6}};
            int[][] test = {{1, 4}, {5, 6}};
            assertArrayEquals(test, func.apply(data));
        }
    }
}
