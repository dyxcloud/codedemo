package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

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
        TestCase.assertEquals(1, titleToNumber("A"));
        TestCase.assertEquals(28, titleToNumber("AB"));
        TestCase.assertEquals(701, titleToNumber("ZY"));
    }
}
