package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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


    /**
     * 中心扩展
     * a a a a
     */
    public String longestPalindrome2(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start + 1) {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    @Test
    public void tt() {
        UnaryOperator<String> func = this::longestPalindrome2;
        Assertions.assertTrue(Arrays.asList("bab", "aba").contains(func.apply("babad")));
        Assertions.assertEquals("bb", func.apply("cbbd"));
        Assertions.assertEquals("aa", func.apply("aa"));
        Assertions.assertEquals("a", func.apply("ac"));
    }
}
