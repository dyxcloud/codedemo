package dotest.dataDeal;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * 表达式求值
 * 值=乘除项+乘除项
 * 乘除项=括号项*括号项
 * @author DongYunxiang
 * @create 2019-04-03
 **/
@SuppressWarnings("NonAsciiCharacters")
public class 表达式求值递归 {



    public static double get(String str) {
        str = str.replaceAll(" +", "");
        String[] split = str.split("(?<=[-+*/()])|(?=[-+*/()])");
        IntStream.range(0, split.length).forEach(i -> {
            String s = split[i];//获取split的索引, 用于判断负号

        });
        return 0;
    }

    /**
     * 计算乘子的值
     * @param line
     * @return
     */
    public static double Multiplier(String[] line){
        return 0;
    }



}
