package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.UnaryOperator;

@SuppressWarnings("NonAsciiCharacters")
public class L394字符串解码 {

    /**
     * 使用栈
     */
    public String decodeString(String s) {
        Deque<Object> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
            } else if (c == ']') {
                //遇到']', 弹栈到第二次出现数字之前
                Object poll;
                StringBuilder len = new StringBuilder();
                //处理数字后的字符串
                while ((poll = stack.pollFirst()) instanceof String) {
                    len.insert(0, (String) poll);
                }
                //处理数字
                Integer num = (Integer) poll;
                len.append(len.toString().repeat(num - 1));
                //处理数字前的字符串
                while (stack.peekFirst() instanceof String) {
                    len.insert(0, (String) stack.pollFirst());
                }
                stack.offerFirst(len.toString());
            } else if (c >= '0' && c <= '9') {
                //数字压栈
                int num = c - '0';
                char nextChar;
                while ((nextChar = s.charAt(i + 1)) != '[') {
                    num = num * 10 + (nextChar - '0');
                    i++;
                }
                stack.offerFirst(num);
            } else {
                //子母压栈
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                char nextChar;
                while (i < s.length() - 1 && (nextChar = s.charAt(i + 1)) != ']' && nextChar > '9') {
                    sb.append(nextChar);
                    i++;
                }
                stack.offerFirst(sb.toString());
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pollFirst());
        }
        return result.toString();
    }

    @Test
    public void tt() {
        UnaryOperator<String> func = this::decodeString;
        Assertions.assertEquals("aaabcbc", func.apply("3[a]2[bc]"));
        Assertions.assertEquals("accaccacc", func.apply("3[a2[c]]"));
        Assertions.assertEquals("abcabccdcdcdef", func.apply("2[abc]3[cd]ef"));
        Assertions.assertEquals("abccdcdcdxyz", func.apply("abc3[cd]xyz"));
        Assertions.assertEquals("xxxxxx", func.apply("2[3[x]]"));
        Assertions.assertEquals("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef", func.apply("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        Assertions.assertEquals("sdfeegfeegi", func.apply("sd2[f2[e]g]i"));
    }
}
/*

 */
