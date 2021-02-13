package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

public class L14最长公共前缀 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; ; i++) {
            if (strs[0].length() <= i) {
                break;
            }
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i
                        || c != strs[j].charAt(i)) {
                    return result.toString();
                }
            }
            result.append(c);
        }
        return result.toString();
    }


    @Test
    public void ttt() {
        TestCase.assertEquals("fl", longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        TestCase.assertEquals("", longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
