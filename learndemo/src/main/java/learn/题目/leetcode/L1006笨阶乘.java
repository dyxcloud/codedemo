package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.IntUnaryOperator;

public class L1006笨阶乘 {

    final char[] operators = {'*', '/', '+', '-'};

    public int clumsy0(int N) {
        if (N <= 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        int result = 0;
        int subResult = N--;
        int index = 0;
        while (N > 0) {
            char oper = operators[index % 4];
            switch (oper) {
                case '-':
                    subResult = -N;
                    break;
                case '*':
                    subResult *= N;
                    break;
                case '/':
                    subResult /= N;
                    break;
                case '+':
                    result += subResult;
                    result += N;
                    break;
            }
            if (N == 1 && oper != '+') {
                return result + subResult;
            }
            index++;
            N--;
        }
        return result;
    }

    //四次操作策略不同, 所以迭代的步进应该为4, 迭代内部一次性处理*/+-
    public int clumsy(int N) {
        if (N == 3) {
            return 6;
        } else if (N <= 2) {
            return N;
        }
        int result = 0;
        result += (N * (N - 1) / (N - 2) + (N - 3));
        N -= 4;
        while (N >= 4) {
            result += (-N * (N - 1) / (N - 2) + (N - 3));
            N -= 4;
        }
        return result - clumsy(N);
    }


    @Test
    public void tt() {
        IntUnaryOperator f = this::clumsy;
        Assertions.assertEquals(7, f.applyAsInt(4));
        Assertions.assertEquals(12, f.applyAsInt(10));
        Assertions.assertEquals(1, f.applyAsInt(1));
    }
}
