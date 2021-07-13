package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

public class L67二进制求和 {

    public String addBinary(String a, String b) {
        char[] longChars, shortChars;
        if (a.length() > b.length()) {
            longChars = a.toCharArray();
            shortChars = b.toCharArray();
        } else {
            shortChars = a.toCharArray();
            longChars = b.toCharArray();
        }
        int pre = 0;
        for (int is = shortChars.length - 1, il = longChars.length - 1; il >= 0; il--) {
            int s;
            if (is >= 0) {
                s = shortChars[is] == '1' ? 1 : 0;
                is--;
            } else {
                s = 0;
            }
            int l = longChars[il] == '1' ? 1 : 0;
            int sum = pre + s + l;
            switch (sum) {
                case 0:
                    pre = 0;
                    longChars[il] = '0';
                    break;
                case 1:
                    pre = 0;
                    longChars[il] = '1';
                    break;
                case 2:
                    pre = 1;
                    longChars[il] = '0';
                    break;
                case 3:
                    pre = 1;
                    longChars[il] = '1';
                    break;
            }
        }
        if (pre == 1) {
            char[] result = new char[longChars.length + 1];
            result[0] = '1';
            System.arraycopy(longChars, 0, result, 1, longChars.length);
            return new String(result);
        } else {
            return new String(longChars);
        }
    }

    @Test
    public void ttt() {
        TestCase.assertEquals("100", addBinary("11", "1"));
        TestCase.assertEquals("10101", addBinary("1010", "1011"));
    }
}
