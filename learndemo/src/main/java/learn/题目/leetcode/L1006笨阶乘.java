package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

public class L1006笨阶乘 {

    final char[] operators = {'*', '/', '+', '-'};

    public int clumsy(int N) {
        if (N <= 0) {
            return 0;
        }
        if(N==1){
            return 1;
        }
        int result = 0;
        int subResult = N--;
        int index = 0;
        while (N > 0) {
            char oper = operators[index%4];
            switch (oper){
                case '-':
                    subResult = -N;
                    if(N==1){
                        return result+subResult;
                    }
                    break;
                case '*':
                    subResult*=N;
                    if(N==1){
                        return result+subResult;
                    }
                    break;
                case '/':
                    subResult/=N;
                    if(N==1){
                        return result+subResult;
                    }
                    break;
                case '+':
                    result+=subResult;
                    result+=N;
                    subResult = 1;
                    break;
            }
            index++;
            N--;
        }
        return result;
    }

    @Test
    public void tt() {
        TestCase.assertEquals(7, clumsy(4));
        TestCase.assertEquals(12, clumsy(10));
        TestCase.assertEquals(1, clumsy(1));
    }
}
