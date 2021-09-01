package learn.题目.剑指offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author DongYunxiang
 * @create 2019-12-16
 **/
@SuppressWarnings("NonAsciiCharacters")
public class Of16数值的整数次方 {

    @Deprecated
    public double myPow_(double base, int exponent) {
        boolean isLessThan0 = exponent<0;
        if(isLessThan0) exponent = -exponent;
        double result = 1;
        for(int i=0;i<exponent;i++){
            result*=base;
        }
        if(isLessThan0) result = 1/result;
        return result;
    }
    public double myPow(double base, int exponentInt){
        long exponent = exponentInt;
        if (exponent == 0) return 1;
        boolean isLessThan0 = exponent < 0;
        if (isLessThan0) exponent = -exponent;
        if (exponent == 1) return isLessThan0 ? 1 / base : base;

        double result;
        boolean isOdd = (exponent & 1) == 1;
        result = myPow(base * base, (int)(exponent / 2));
        if (isOdd) result = result* base;
        return isLessThan0 ? 1 / result : result;
    }
    @Test
    public void testPower(){
        Assertions.assertEquals(9.0, myPow(3,2));
        Assertions.assertEquals(1.0/9, myPow(3,-2));
        Assertions.assertEquals(1.0, myPow(3,0));
        Assertions.assertEquals(0.0, myPow(2.0,-2147483648));
    }


}
