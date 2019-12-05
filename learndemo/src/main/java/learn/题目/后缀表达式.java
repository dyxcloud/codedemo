package learn.题目;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author DongYunxiang
 * @create 2019-04-03
 **/
@SuppressWarnings("NonAsciiCharacters")
public class 后缀表达式 {

    /**
     * 8 5 - 4 2 - *
     *
     * @param str
     * @return
     */
    public static String run(String str) {
        final List<String> symbol = Arrays.asList("+", "-", "*", "/");
        Deque<String> stack = new ArrayDeque<>();
        for (String c : str.split(" +")) {
            if (symbol.contains(c)) {
                double a = Double.parseDouble(stack.removeFirst());
                double b = Double.parseDouble(stack.removeFirst());
                double result;
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
                stack.addFirst(String.valueOf(result));
            } else {
                stack.addFirst(c);
            }
        }
        return stack.removeFirst();
    }

    @Test
    public void testRun() {
        Assert.assertEquals(run(" 8  5 - 4 2 - * "), "6.0");
        Assert.assertEquals(run("2 1 + 3 *"), "9.0");
    }
}
