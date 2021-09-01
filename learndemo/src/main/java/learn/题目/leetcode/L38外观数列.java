package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        Assertions.assertEquals("1", func.apply(1));
        Assertions.assertEquals("11", func.apply(2));
        Assertions.assertEquals("21", func.apply(3));
        Assertions.assertEquals("1211", func.apply(4));
        Assertions.assertEquals("111221", func.apply(5));
    }
}
