package learn.题目.剑指offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2019-12-13
 **/
@SuppressWarnings("NonAsciiCharacters")
public class n10二进制中1的个数 {

    @Deprecated
    public int NumberOf1_(int n) {
        int result = 0;//从低位开始,逐位判断是否为1
        for (int flag = 1; flag != 0; flag = flag << 1) {
            if ((n & flag) != 0) result++;
        }
        return result;
    }
    public int NumberOf1(int n) {
        int result = 0;
        while(n!=0){
            n = n & (n-1);//操作后消去最低位的1
            result++;
        }
        return result;
    }
    @Test
    public void testNumberOf1(){
        Assert.assertEquals(2,NumberOf1(9));
        Assert.assertEquals(1,NumberOf1(-2147483648));
        Assert.assertEquals(32,NumberOf1(-1));
        Assert.assertEquals(0,NumberOf1(0));
    }

}
