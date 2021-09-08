package learn.题目.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NonAsciiCharacters")
public class L78子集 {

/*
1 2 3
N: *
3: ** 3*
2: ** *3 2* 23
1: *** **3 *2* *23 1** 1*3 12* 123

f(n)=f(n-1) + ("n"+"f(n-1)")
 */

    /**
     * DP解法
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            for (int p = result.size() - 1; p >= 0; p--) {
                ArrayList<Integer> integers = new ArrayList<>(result.get(p));
                integers.add(num);
                result.add(integers);
            }
        }
        return result;
    }

    @Test
    public void tt() {
        Function<int[], List<List<Integer>>> func = this::subsets;
        {
            List<List<Integer>> apply = func.apply(new int[]{1, 2, 3});
            Set<List<Integer>> collect = apply.stream().peek(Collections::sort).collect(Collectors.toSet());
            assertEquals(Set.of(Collections.emptyList(), Collections.singletonList(1), Collections.singletonList(2), Arrays.asList(1, 2), Collections.singletonList(3), Arrays.asList(1, 3), Arrays.asList(2, 3), Arrays.asList(1, 2, 3)), collect);
        }
        {
            List<List<Integer>> apply = func.apply(new int[]{0});
            Set<List<Integer>> collect = apply.stream().peek(Collections::sort).collect(Collectors.toSet());
            assertEquals(Set.of(Collections.emptyList(), Collections.singletonList(0)), collect);
        }
    }
}
