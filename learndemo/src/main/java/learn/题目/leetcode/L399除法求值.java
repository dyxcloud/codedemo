package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("NonAsciiCharacters")
public class L399除法求值 {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        for (List<String> query : queries) {
            
        }
        return null;
    }

    interface CalcEquation {
        double[] apply(List<List<String>> equations, double[] values, List<List<String>> queries);
    }

    @Test
    public void tt() {
        CalcEquation func = this::calcEquation;
        {
            List<List<String>> equations = Arrays.asList(
                    Arrays.asList("a", "b")
                    , Arrays.asList("b", "c")
            );
            double[] values = {2.0, 3.0};
            List<List<String>> queries = Arrays.asList(
                    Arrays.asList("a", "c")
                    , Arrays.asList("b", "a")
                    , Arrays.asList("a", "e")
                    , Arrays.asList("a", "a")
                    , Arrays.asList("x", "x")
            );
            Assertions.assertArrayEquals(new double[]{6.0, 0.5, -1.0, 1.0, -1.0}, func.apply(equations, values, queries));
        }
        {
            List<List<String>> equations = Arrays.asList(
                    Arrays.asList("a", "b")
                    , Arrays.asList("b", "c")
                    , Arrays.asList("bc", "cd")
            );
            double[] values = {1.5, 2.5, 5.0};
            List<List<String>> queries = Arrays.asList(
                    Arrays.asList("a", "c")
                    , Arrays.asList("c", "b")
                    , Arrays.asList("bc", "cd")
                    , Arrays.asList("cd", "bc")
            );
            Assertions.assertArrayEquals(new double[]{3.75000, 0.40000, 5.00000, 0.20000}, func.apply(equations, values, queries));
        }
        {
            List<List<String>> equations = Collections.singletonList(
                    Arrays.asList("a", "b")
            );
            double[] values = {0.5};
            List<List<String>> queries = Arrays.asList(
                    Arrays.asList("a", "b")
                    , Arrays.asList("b", "a")
                    , Arrays.asList("a", "c")
                    , Arrays.asList("x", "y")
            );
            Assertions.assertArrayEquals(new double[]{0.50000, 2.00000, -1.00000, -1.00000}, func.apply(equations, values, queries));
        }
    }
}
