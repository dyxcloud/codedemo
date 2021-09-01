package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author DongYunxiang
 * @create 2021-07-02
 **/
public class L171Excel表列序号 {

    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int sum = 0;
        for (char c : chars) {
            sum = sum * 26 + (c - 'A' + 1);
        }
        return sum;
    }

    @Test
    public void tt() {
        Assertions.assertEquals(1, titleToNumber("A"));
        Assertions.assertEquals(28, titleToNumber("AB"));
        Assertions.assertEquals(701, titleToNumber("ZY"));
    }
}
