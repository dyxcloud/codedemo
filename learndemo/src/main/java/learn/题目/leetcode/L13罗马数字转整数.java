package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2021-02-19
 **/
public class L13罗马数字转整数 {

/*
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
*/


    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int highest = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            switch (c) {
                case 'M':
                    result += 1000;
                    highest = 1000;
                    break;
                case 'D':
                    if (highest <= 500) {
                        result += 500;
                        highest = 500;
                    } else {
                        result -= 500;
                    }
                    break;
                case 'C':
                    if (highest <= 100) {
                        result += 100;
                        highest = 100;
                    } else {
                        result -= 100;
                    }
                    break;
                case 'L':
                    if (highest <= 50) {
                        result += 50;
                        highest = 50;
                    } else {
                        result -= 50;
                    }
                    break;
                case 'X':
                    if (highest <= 10) {
                        result += 10;
                        highest = 10;
                    } else {
                        result -= 10;
                    }
                    break;
                case 'V':
                    if (highest <= 5) {
                        result += 5;
                        highest = 5;
                    } else {
                        result -= 5;
                    }
                    break;
                case 'I':
                    if (highest <= 1) {
                        result += 1;
                        highest = 1;
                    } else {
                        result -= 1;
                    }
                    break;
            }
        }
        return result;
    }

    @Test
    public void t() {
        TestCase.assertEquals(3, romanToInt("III"));
        TestCase.assertEquals(4, romanToInt("IV"));
        TestCase.assertEquals(9, romanToInt("IX"));
        TestCase.assertEquals(58, romanToInt("LVIII"));
        TestCase.assertEquals(1994, romanToInt("MCMXCIV"));
    }
}
