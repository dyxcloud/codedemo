package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L39组合总和 {

    List<List<Integer>> result;
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        this.candidates = candidates;
        Arrays.sort(this.candidates);
        helper(new ArrayList<>(), target, candidates.length - 1);
        return result;
    }

    public void helper(ArrayList<Integer> current, int currentTarget, int pickIndex) {
        if (current.size() >= 149) {
            return;
        }
        for (int i = pickIndex; i >= 0; i--) {
            if (candidates[i] > currentTarget) {
                continue;
            }
            current.add(candidates[i]);
            int nextTarget = currentTarget - candidates[i];
            if (nextTarget > 0) {
                helper(current, nextTarget, i);
            } else {
                result.add(new ArrayList<>(current));
            }
            current.remove(current.size() - 1);
        }
    }

    @Test
    public void tt() {
        BiFunction<int[], Integer, List<List<Integer>>> func = this::combinationSum;
        {
            List<List<Integer>> apply = func.apply(new int[]{2, 3, 6, 7}, 7);
            apply.forEach(Collections::sort);
            Assertions.assertEquals(Set.of(Collections.singletonList(7), Arrays.asList(2, 2, 3)), new HashSet<>(apply));
        }
        {
            List<List<Integer>> apply = func.apply(new int[]{2, 3, 5}, 8);
            apply.forEach(Collections::sort);
            Assertions.assertEquals(Set.of(Arrays.asList(2, 2, 2, 2), Arrays.asList(2, 3, 3), Arrays.asList(3, 5)), new HashSet<>(apply));
        }
        {
            List<List<Integer>> apply = func.apply(new int[]{2}, 1);
            apply.forEach(Collections::sort);
            Assertions.assertEquals(Collections.EMPTY_SET, new HashSet<>(apply));
        }
        {
            List<List<Integer>> apply = func.apply(new int[]{1}, 1);
            apply.forEach(Collections::sort);
            Assertions.assertEquals(Set.of(Collections.singletonList(1)), new HashSet<>(apply));
        }
        {
            List<List<Integer>> apply = func.apply(new int[]{1}, 2);
            apply.forEach(Collections::sort);
            Assertions.assertEquals(Set.of(Arrays.asList(1, 1)), new HashSet<>(apply));
        }
    }
}
