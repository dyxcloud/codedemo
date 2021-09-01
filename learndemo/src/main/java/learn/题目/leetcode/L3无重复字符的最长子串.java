package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.ToIntFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L3无重复字符的最长子串 {

    /**
     * 滑动窗口 只记录右指针 左边界需要遍历
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() <= 1) return s.length();
        int max = 0;
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer preIndex = map.put(c, i);
            if (preIndex != null) {
                l = preIndex + 1;
                final int index = l;
                //删除map中l之前的记录
                map.values().removeIf(mapi -> mapi < index);
            } else {
                int currentLen = i - l + 1;
                if (currentLen > max) {
                    // System.out.println("update..." + l + "," + i);
                    max = currentLen;
                }
            }
        }
        return max;
    }

    /**
     * 滑动窗口 同时记录左右指针
     */
    public int lengthOfLongestSubstring0(String s) {
        if (s == null) return 0;
        if (s.length() <= 1) return s.length();
        int max = 0;
        int r = 0;
        Set<Character> map = new HashSet<>();
        for (int i = 0; i < s.length() - max; i++) {
            if (i > 0) {
                map.remove(s.charAt(i - 1));
            }
            while (r < s.length() && !map.contains(s.charAt(r))) {
                map.add(s.charAt(r));
                r++;
            }
            max = Math.max(max, r - i);
        }
        return max;
    }

    @Test
    public void tt() {
        ToIntFunction<String> func = this::lengthOfLongestSubstring0;
        Assertions.assertEquals(3, func.applyAsInt("abcabcbb"));
        Assertions.assertEquals(3, func.applyAsInt("pwwkew"));
        Assertions.assertEquals(0, func.applyAsInt(""));
        Assertions.assertEquals(5, func.applyAsInt("tmmzuxt"));
    }
}
