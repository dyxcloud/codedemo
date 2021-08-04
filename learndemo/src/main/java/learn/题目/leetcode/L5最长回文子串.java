package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.UnaryOperator;

@SuppressWarnings("NonAsciiCharacters")
public class L5最长回文子串 {

    /**
     * 窗口暴力法
     */
    public String longestPalindrome(String s) {
        for (int len = s.length(); len > 0; len--) {
            for (int l = 0; l <= s.length() - len; l++) {
                int r = l + len - 1;
                boolean b = isPalindrome(s.toCharArray(), l, r);
                if (b) {
                    return s.substring(l, r + 1);
                }
            }
        }
        return "";
    }

    private boolean isPalindrome(char[] arr, int l, int r) {
        if (l == r) return true;
        while (l < r) {
            if (arr[l] != arr[r]) return false;
            l++;
            r--;
        }
        return true;
    }

    
    
    @Test
    public void tt() {
        UnaryOperator<String> func = this::longestPalindrome;
        TestCase.assertTrue(Arrays.asList("bab", "aba").contains(func.apply("babad")));
        TestCase.assertEquals("bb", func.apply("cbbd"));
        TestCase.assertEquals("aa", func.apply("aa"));
        TestCase.assertEquals("a", func.apply("ac"));
    }
}
