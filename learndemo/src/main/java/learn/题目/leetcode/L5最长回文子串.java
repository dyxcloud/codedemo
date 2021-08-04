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
    public String longestPalindrome0(String s) {
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

    /*
DP
    b   a   b   a   d   a   b
b   b
a   a
b   bab
a   aba
d   d
a   ada
b   badab
已x为结尾的回文子串
baxba a
aaabaaa a
     */

    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int preIndex = 0;//上一个回文的结束点
        int preLen = 1;//上一个回文的长度
        boolean preSame = true;
        int maxIndex = preIndex;
        int maxLen = preLen;
        for (int i = 1; i < chars.length; i++) {
            //全相同
            if (preSame) {
                if (chars[i] == chars[preIndex]) {
                    preIndex = i;
                    preLen += 1;
                    if (maxLen < preLen) {
                        maxLen = preLen;
                        maxIndex = preIndex;
                    }
                    continue;
                } else {
                    preSame = false;
                }
            }
            //上一个回文起始的前一位是否等于当前
            if (preIndex - preLen >= 0 && chars[i] == chars[preIndex - preLen]) {
                preIndex = i;
                preLen += 2;
                if (maxLen < preLen) {
                    maxLen = preLen;
                    maxIndex = preIndex;
                }
                continue;
            }
            //回文长度不变或减少 对称轴移动
            int len = preLen;
            for (; len > 0; len--) {
                int l = i - len + 1;
                int r = i;
                boolean finded = true;
                while (l < r) {
                    if (chars[l] != chars[r]) {
                        finded = false;
                        break;
                    }
                    l++;
                    r--;
                }
                if (finded && l >= r) {
                    preIndex = i;
                    preLen = len;
                    //判断是否单字符
                    preSame = true;
                    char c = chars[i];
                    for (int p = i - 1; p > preIndex - preLen + 1; p--) {
                        if (chars[p] != c) {
                            preSame = false;
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return s.substring(maxIndex - maxLen + 1, maxIndex + 1);
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
