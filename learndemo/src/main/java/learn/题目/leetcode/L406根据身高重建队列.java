package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

@SuppressWarnings("NonAsciiCharacters")
public class L406根据身高重建队列 {

    /**
     * 按照val排序, 从小到大逐个填充到result
     */
    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][];
        //sort people val
        sort(people, 0, people.length - 1);
        // Arrays.stream(people).forEach(p -> System.out.println(p[0]));
        //填充result
        for (int[] p : people) {
            int count = 0;
            for (int i = 0; i < result.length; i++) {
                if (result[i] == null) {
                    if (count == p[1]) {
                        result[i] = p;
                        break;
                    } else {
                        count++;
                    }
                } else if (result[i][0] >= p[0]) {
                    count++;
                }
            }
        }
        return result;
    }

    private void sort(int[][] arr, int start, int end) {
        if (start >= end) return;
        int p = arr[start][0];
        int l = start, r = end;
        while (l < r) {
            while (r > l && arr[r][0] >= p) r--;
            swap(arr, l, r);
            while (l < r && arr[l][0] <= p) l++;
            swap(arr, l, r);
        }
        sort(arr, start, l - 1);
        sort(arr, l + 1, end);
    }

    private void swap(int[][] arr, int a, int b) {
        int[] t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    @Test
    public void tt() {
        UnaryOperator<int[][]> func = this::reconstructQueue;
        {
            /*
            valSort: 44 50 52 61 70 71
            50 _ _ _ 44 _
             */
            int[][] input = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
            int[][] check = {{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}};
            Assertions.assertArrayEquals(check, func.apply(input));
        }
        {
            int[][] input = {{6, 0}, {5, 0}, {4, 0}, {3, 2}, {2, 2}, {1, 4}};
            int[][] check = {{4, 0}, {5, 0}, {2, 2}, {3, 2}, {1, 4}, {6, 0}};
            Assertions.assertArrayEquals(check, func.apply(input));
        }
    }
}
