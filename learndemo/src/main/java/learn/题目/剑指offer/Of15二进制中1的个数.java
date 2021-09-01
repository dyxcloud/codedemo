package learn.题目.剑指offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.IntUnaryOperator;

/**
 * @author DongYunxiang
 * @create 2019-12-13
 **/
@SuppressWarnings("NonAsciiCharacters")
public class Of15二进制中1的个数 {

    @Deprecated
    public int hammingWeight1(int n) {
        int result = 0;//从低位开始,逐位判断是否为1
        for (int flag = 1; flag != 0; flag = flag << 1) {
            if ((n & flag) != 0) result++;
        }
        return result;
    }

    public int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            n = n & (n - 1);//操作后消去最低位的1
            result++;
        }
        return result;
    }

    public int hammingWeight2(int n) {
        return Integer.bitCount(n);
    }

    @Test
    public void testNumberOf1() {
        IntUnaryOperator f = this::hammingWeight2;
        Assertions.assertEquals(2, f.applyAsInt(9));
        Assertions.assertEquals(1, f.applyAsInt(-2147483648));
        Assertions.assertEquals(32, f.applyAsInt(-1));
        Assertions.assertEquals(0, f.applyAsInt(0));
    }

}
