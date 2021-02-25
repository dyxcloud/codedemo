package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

public class L58最后一个单词的长度 {

    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        boolean findWord = false;
        int r = -1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                if (!findWord) {
                    findWord = true;
                    r = i;//右边界
                }
            } else {
                if (findWord) {//左边界
                    return r - i;
                }
            }
        }
        if (findWord) {//左边界
            return r + 1;
        }
        return 0;
    }

    @Test
    public void tt() {
        TestCase.assertEquals(5, lengthOfLastWord("Hello World"));
        TestCase.assertEquals(0, lengthOfLastWord(" "));
        TestCase.assertEquals(1, lengthOfLastWord("a"));
        TestCase.assertEquals(1, lengthOfLastWord("a "));
    }
}
