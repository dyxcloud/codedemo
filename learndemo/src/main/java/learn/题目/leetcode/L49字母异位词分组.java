package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@SuppressWarnings("NonAsciiCharacters")
public class L49字母异位词分组 {

    /**
     * stream group
     */
    public List<List<String>> groupAnagrams0(String[] strs) {
        Map<String, List<String>> collect = Arrays.stream(strs).collect(Collectors.groupingBy(s -> {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }));
        List<List<String>> result = new ArrayList<>();
        collect.forEach((k, v) -> result.add(v));
        return result;
    }

    /**
     * 
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        return null;
    }
    @Test
    public void tt() {
        Function<String[], List<List<String>>> func = this::groupAnagrams;
        {
            String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
            List<List<String>> apply = func.apply(arr);
            Set<List<String>> collect = apply.stream().peek(Collections::sort).collect(Collectors.toSet());
            TestCase.assertEquals(Set.of(Collections.singletonList("bat"), Arrays.asList("nat", "tan"), Arrays.asList("ate", "eat", "tea")), collect);
        }
        {
            String[] arr = {""};
            List<List<String>> apply = func.apply(arr);
            Set<List<String>> collect = apply.stream().peek(Collections::sort).collect(Collectors.toSet());
            TestCase.assertEquals(Set.of(Collections.singletonList("")), collect);
        }
        {
            String[] arr = {"a"};
            List<List<String>> apply = func.apply(arr);
            Set<List<String>> collect = apply.stream().peek(Collections::sort).collect(Collectors.toSet());
            TestCase.assertEquals(Set.of(Collections.singletonList("a")), collect);
        }
    }
}
