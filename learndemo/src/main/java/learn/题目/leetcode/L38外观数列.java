package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.function.IntFunction;

public class L38外观数列 {

    public String countAndSay(int n) {
        if (n < 2) {
            return "1";
        }
        String str = countAndSay(n - 1);
        char[] chars = str.toCharArray();
        char pre = chars[0];
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == pre) {
                count++;
            } else {
                result.append(count).append(pre);
                pre = chars[i];
                count = 1;
            }
        }
        result.append(count).append(pre);
        return result.toString();
    }

    public String countAndSayLoop(int n) {
        StringBuilder result = new StringBuilder("1");
        for(int t=1;t<n;t++){
            char[] chars = result.toString().toCharArray();
            result.setLength(0);
            char pre = chars[0];
            int count = 1;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == pre) {
                    count++;
                } else {
                    result.append(count).append(pre);
                    pre = chars[i];
                    count = 1;
                }
            }
            result.append(count).append(pre);
        }
        return result.toString();
    }


    @Test
    public void ttt() {
        IntFunction<String> func = this::countAndSayLoop;
        TestCase.assertEquals("1", func.apply(1));
        TestCase.assertEquals("11", func.apply(2));
        TestCase.assertEquals("21", func.apply(3));
        TestCase.assertEquals("1211", func.apply(4));
        TestCase.assertEquals("111221", func.apply(5));
    }
}
