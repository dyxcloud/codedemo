package dotest.dataDeal;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * 表达式求值
 *
 * @author DongYunxiang
 * @create 2019-04-03
 **/
@SuppressWarnings("NonAsciiCharacters")
public class 表达式求值 {


    private static final List<Character> symbolPer = Arrays.asList('{', '[', '(');
    private static final List<Character> symbolSuf = Arrays.asList('}', ']', ')');
    private static final List<String> symbol = Arrays.asList(")", "+", "-", "*", "/", "(");

    /**
     * 判断一个括号表达式是否合法
     * 如: "{[()]}"为合法
     *
     * @param str
     * @return
     */
    private static boolean isLegal(String str) {
        str = str.replaceAll(" +", "");
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (symbolPer.contains(c)) {
                stack.push(c);
            } else if (symbolSuf.contains(c)) {
                if (stack.empty()) return false;
                char pop = stack.pop();
                if (symbolPer.indexOf(pop) != symbolSuf.indexOf(c)) return false;
            }
            //跳过
        }
        return true;
    }

    /**
     * 可以先运行A
     *
     * @param operatorA
     * @param operatorB
     * @return
     */
    private static boolean canRunAFirst(String operatorA, String operatorB) {
        if (")".equals(operatorA) || "(".equals(operatorA)) return false;
        if ("(".equals(operatorB)) return false;
        if (")".equals(operatorB)) return true;
        int a = symbol.indexOf(operatorA);
        int b = symbol.indexOf(operatorB);
        return !(a < 3 && b > 2);
    }

    public static double operator(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new RuntimeException("bad operator:"+operator);
        }
    }

    /**
     * 表达式求值
     * 负数识别: 若使用减号表示的话, 只需判断前一个操作符是否为空或者"("
     *
     * @param str
     * @return
     */
    public static double get(String str) {
        str = str.replaceAll(" +", "");
        String[] split = str.split("(?<=[-+*/()])|(?=[-+*/()])");
        Stack<String> operators = new Stack<>();
        Stack<Double> numbers = new Stack<>();
        IntStream.range(0, split.length).forEach(i -> {
            String s = split[i];//获取split的索引, 用于判断负号
            if (symbol.contains(s)) {
                //先判断是否为负号
                if ("-".equals(s) && (i == 0 || split[i - 1].equals("("))) {
                    split[i + 1] = "-" + split[i + 1];
                    return;
                }
                //如果前一个操作符优先级大于等于后一个, 就计算前一个, 否则就放入
                while (!operators.empty() && canRunAFirst(operators.peek(), s)) {
                    String pop = operators.pop();//计算前一个
                    double n2 = numbers.pop();
                    double n1 = numbers.pop();
                    numbers.push(operator(n1, n2, pop));
                }
                //当前是右括号,与左括号向消
                if (")".equals(s) && !operators.empty() && "(".equals(operators.peek())) {
                    operators.pop();
                } else {
                    operators.push(s);
                }
            } else {
                numbers.push(Double.parseDouble(s));
            }
        });
        System.out.println(numbers);
        System.out.println(operators);
        while (!operators.empty()) {
            String pop = operators.pop();
            double n2 = numbers.pop();
            double n1 = numbers.pop();
            numbers.push(operator(n1, n2, pop));
        }
        Double result = numbers.pop();
        if (numbers.empty()) {
            return result;
        } else {
            throw new RuntimeException("多个操作数:" + numbers);
        }
    }


    @Test
    public void testIsLegal() {
        TestCase.assertTrue(isLegal("{[()]}"));
        TestCase.assertTrue(!isLegal("(()))"));
        TestCase.assertTrue(!isLegal("(()]"));
        TestCase.assertTrue(!isLegal("{(})"));
    }

    @Test
    public void testGet() {
        TestCase.assertEquals(get("1 + 2 - 3 * 4 + 4 / 2"), -7.0);
        TestCase.assertEquals(get("1 + 2 - 3 * 4 + 4 / 2/1 + 2 - 3 * 4 + 4 / 2+1 + 2 - 3 * 4 + 4 / 2"), -22.0);
        TestCase.assertEquals(get("((11+33)/11-2*4)*(8-3)"), -20.0);
        TestCase.assertEquals(get("((11+33)/11-2*4)*(8-3)"), -20.0);
        TestCase.assertEquals(get("-1 + 2 - 3 * 4 + 4 / 2"), -9.0);
        TestCase.assertEquals(get("((-11+33)/11-2*4)*(8-3)"), -30.0);
    }

}
