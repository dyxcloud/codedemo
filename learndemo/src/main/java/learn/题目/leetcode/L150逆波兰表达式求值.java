package learn.题目.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 后缀表达式(逆波兰表达式求值)
 *
 * @author DongYunxiang
 * @create 2019-04-03
 **/
@SuppressWarnings("NonAsciiCharacters")
public class L150逆波兰表达式求值 {

    /**
     * 8 5 - 4 2 - *
     *
     * @param str
     * @return
     */
    public int evalRPN(String[] tokens) {
        final List<String> symbol = Arrays.asList("+", "-", "*", "/");
        Deque<Integer> stack = new ArrayDeque<>();
        for (String c : tokens) {
            if (symbol.contains(c)) {
                int b = stack.removeFirst();
                int a = stack.removeFirst();
                int result;
                switch (c) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                    default:
                        result = 0;
                }
                stack.addFirst(result);
            } else {
                stack.addFirst(Integer.parseInt(c));
            }
        }
        return stack.removeFirst();
    }

    @Test
    public void testRun() {
        Assert.assertEquals(6, evalRPN(new String[]{"8", "5", "-", "4", "2", "-", "*"}));
        Assert.assertEquals(9, evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        Assert.assertEquals(6, evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        Assert.assertEquals(22
                , evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
