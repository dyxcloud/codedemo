package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

@SuppressWarnings("NonAsciiCharacters")
public class L139单词拆分 {

    /**
     * 从句子起点尝试拼接单词,成功向后继续拼接,失败就回溯
     */
    public boolean wordBreak0(String s, List<String> wordDict) {
        wordDict.sort((s1, s2) -> s2.length() - s1.length());
        return test(s.toCharArray(), 0, wordDict);
    }

    private boolean test(char[] chars, int start, List<String> dict) {
        if (start >= chars.length) {
            return true;
        }
        for (String word : dict) {
            boolean notMatch = false;
            for (int i = 0; i < word.length(); i++) {
                if (start + i >= chars.length
                        || word.charAt(i) != chars[start + i]) {
                    notMatch = true;
                    break;
                }
            }
            if (!notMatch) {
                boolean test = test(chars, start + word.length(), dict);
                if (test) {
                    return true;
                }
            }
        }
        return false;
    }

    
    public boolean wordBreak(String s, List<String> wordDict) {
        return false;
    }
    
    @Test
    public void tt() {
        BiPredicate<String, List<String>> func = this::wordBreak;
        Assertions.assertTrue(func.test("leetcode", Arrays.asList("leet", "code")));
        Assertions.assertTrue(func.test("applepenapple", Arrays.asList("apple", "pen")));
        Assertions.assertFalse(func.test("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        Assertions.assertFalse(func.test("aaaaaaa", Arrays.asList("aaaa", "aa")));
        Assertions.assertFalse(func.test("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
    }
}
