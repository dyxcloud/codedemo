package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author DongYunxiang
 * @create 2021-02-22
 **/
public class L28实现strStr {

    public int strStr(String haystack, String needle) {
        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();
        if (target.length == 0) {
            return 0;
        }
        out:
        for (int i = 0; i <= source.length - target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                if (source[i + j] != target[j]) {
                    continue out;
                }
            }
            return i;
        }
        return -1;
    }

    @Test
    public void tt() {
        Assertions.assertEquals(2, strStr("hello", "ll"));
        Assertions.assertEquals(-1, strStr("aaaaaa", "bba"));
    }
}
