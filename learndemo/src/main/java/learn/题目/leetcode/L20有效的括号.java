package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * @author DongYunxiang
 * @create 2021-02-20
 **/
public class L20有效的括号 {

    //()[]{}
    public boolean isValid(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        Character pre;
        for (Character c : chars) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    deque.offerFirst(c);
                    break;
                case ')':
                    pre = deque.pollFirst();
                    if (!Objects.equals(pre, '(')) return false;
                    break;
                case ']':
                    pre = deque.pollFirst();
                    if (!Objects.equals(pre, '[')) return false;
                    break;
                case '}':
                    pre = deque.pollFirst();
                    if (!Objects.equals(pre, '{')) return false;
                    break;
            }
        }
        return deque.isEmpty();
    }

    @Test
    public void tt() {
        Assertions.assertTrue(isValid("()"));
        Assertions.assertTrue(isValid("()[]{}"));
        Assertions.assertFalse(isValid("(]"));
        Assertions.assertFalse(isValid("([)]"));
        Assertions.assertTrue(isValid("{[]}"));
    }
}
