package learn.题目.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("NonAsciiCharacters")
public class L118杨辉三角 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            int length = i + 1;
            List<Integer> oneFloor = new ArrayList<>(length);
            for (int j = 0; j < length; j++) {
                if (j == 0 || j == length - 1)
                    oneFloor.add(1);
                else
                    oneFloor.add(arr.get(i - 1).get(j - 1) + arr.get(i - 1).get(j));
            }
            arr.add(oneFloor);
        }
        return arr;
    }

    @Test
    public void ttt() {
        List<List<Integer>> generate = generate(10);
        generate.forEach(System.out::println);
    }
}
