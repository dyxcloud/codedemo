package learn.题目.剑指offer;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2019-12-16
 **/
@SuppressWarnings("NonAsciiCharacters")
public class n11数值的整数次方 {

    @Deprecated
    public double Power_(double base, int exponent) {
        boolean isLessThan0 = exponent<0;
        if(isLessThan0) exponent = -exponent;
        double result = 1;
        for(int i=0;i<exponent;i++){
            result*=base;
        }
        if(isLessThan0) result = 1/result;
        return result;
    }
    public double Power(double base, int exponent){
        if (exponent == 0) return 1;

        boolean isLessThan0 = exponent < 0;
        if (isLessThan0) exponent = -exponent;
        if (exponent == 1) return isLessThan0 ? 1 / base : base;

        double result = 1;
        boolean isOdd = (exponent & 1) == 1;
        result = Power(base * base, exponent / 2);
        if (isOdd) result = result* base;
        return isLessThan0 ? 1 / result : result;
    }
    @Test
    public void testPower(){
        TestCase.assertEquals(9.0,Power(3,2));
        TestCase.assertEquals(1.0/9,Power(3,-2));
        TestCase.assertEquals(1.0,Power(3,0));
    }


}
