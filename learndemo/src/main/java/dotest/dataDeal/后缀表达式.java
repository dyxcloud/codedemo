package dotest.dataDeal;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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
        Stack<String> stack = new Stack<>();
        for (String c : str.split(" +")) {
            if (symbol.contains(c)) {
                double a = Double.parseDouble(stack.pop());
                double b = Double.parseDouble(stack.pop());
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
                stack.push(String.valueOf(result));
            } else {
                stack.push(c);
            }
        }
        return stack.pop();
    }

    @Test
    public void testRun() {
        Assert.assertEquals(run(" 8  5 - 4 2 - * "), "6.0");
        Assert.assertEquals(run("2 1 + 3 *"), "9.0");
    }
}
