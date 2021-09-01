package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@SuppressWarnings("NonAsciiCharacters")
public class L17电话号码的字母组合 {

    Map<Character, char[]> keyMap = Map.of(
            '2', new char[]{'a', 'b', 'c'},
            '3', new char[]{'d', 'e', 'f'},
            '4', new char[]{'g', 'h', 'i'},
            '5', new char[]{'j', 'k', 'l'},
            '6', new char[]{'m', 'n', 'o'},
            '7', new char[]{'p', 'q', 'r', 's'},
            '8', new char[]{'t', 'u', 'v'},
            '9', new char[]{'w', 'x', 'y', 'z'}
    );

    StringBuilder stack;
    List<String> result;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.length() == 0) return result;
        stack = new StringBuilder();
        char[] chars = digits.toCharArray();
        helper(chars, 0);
        return result;
    }

    private void helper(char[] source, int index) {
        char[] chars = keyMap.get(source[index]);
        for (char c : chars) {
            stack.append(c);
            if (index == source.length - 1) {
                result.add(stack.toString());
            } else {
                helper(source, index + 1);
            }
            stack.deleteCharAt(stack.length() - 1);
        }
    }

    @Test
    public void tt() {
        Function<String, List<String>> func = this::letterCombinations;
        Assertions.assertEquals(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"), func.apply("23"));
        Assertions.assertEquals(Arrays.asList(), func.apply(""));
        Assertions.assertEquals(Arrays.asList("a", "b", "c"), func.apply("2"));
    }
}
