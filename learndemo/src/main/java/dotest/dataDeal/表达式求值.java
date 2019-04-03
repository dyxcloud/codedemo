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
public class 表达式求值 {


    private static final List<Character> symbolPer = Arrays.asList('{', '[', '(');
    private static final List<Character> symbolSuf = Arrays.asList('}', ']', ')');

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


    public static void main(String[] args) {

    }

    @Test
    public void testIsLegal(){
        Assert.assertTrue(isLegal("{[()]}"));
        Assert.assertTrue(!isLegal("(()))"));
        Assert.assertTrue(!isLegal("(()]"));
        Assert.assertTrue(!isLegal("{(})"));
    }

}
