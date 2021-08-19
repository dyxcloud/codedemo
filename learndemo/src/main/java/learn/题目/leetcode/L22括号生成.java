package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L22括号生成 {

    List<String> result;
    int length;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        length = n;
        helper(new StringBuilder("("), 1);
        return result;
    }

    /**
     * @param sb 结果字符串
     * @param l  已输入"("的个数
     */
    private void helper(StringBuilder sb, int l) {
        if (sb.length() >= length * 2) {
            result.add(sb.toString());
            return;
        }
        if (sb.length() == 2 * l) {
            helper(sb.append("("), l + 1);
        } else if (l == length) {
            helper(sb.append(")"), l);
        } else {
            helper(sb.append("("), l + 1);
            sb.deleteCharAt(sb.length() - 1);
            helper(sb.append(")"), l);
        }
        sb.deleteCharAt(sb.length() - 1);
    }

    @Test
    public void tt() {
        IntFunction<List<String>> func = this::generateParenthesis;
        TestCase.assertEquals(Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"), func.apply(3));
        TestCase.assertEquals(Collections.singletonList("()"), func.apply(1));
    }
}
