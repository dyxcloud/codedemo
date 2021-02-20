package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

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
        TestCase.assertTrue(isValid("()"));
        TestCase.assertTrue(isValid("()[]{}"));
        TestCase.assertFalse(isValid("(]"));
        TestCase.assertFalse(isValid("([)]"));
        TestCase.assertTrue(isValid("{[]}"));
    }
}
