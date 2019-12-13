package learn.题目.剑指offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2019-12-13
 **/
@SuppressWarnings("NonAsciiCharacters")
public class n10二进制中1的个数 {

    public int NumberOf1(int n) {
        int result = 0;
        int flag = 1;
        while(flag!=0){
            if((n&flag)!=0) result++;
            flag = flag<<1;
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
