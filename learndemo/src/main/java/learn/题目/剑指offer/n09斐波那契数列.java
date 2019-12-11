package learn.题目.剑指offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author DongYunxiang
 * @create 2019-12-11
 **/
@SuppressWarnings("NonAsciiCharacters")
public class n09斐波那契数列 {

    HashMap<Integer,Integer> cache = new HashMap<>();

    @Deprecated
    public int Fibonacci_(int n) {
        if(n<0) throw new RuntimeException("wrong data");
        if (n < 2) return n;
        if(cache.get(n)!=null){
            return cache.get(n);
        }else{
            int result = Fibonacci_(n - 1) + Fibonacci_(n - 2);
            cache.put(n,result);
            return result;
        }
    }

    public int Fibonacci(int n){
        if (n < 0) throw new RuntimeException("wrong data");
        if (n < 2) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int r = a + b;
            a = b;
            b = r;
        }
        return b;
    }

    @Test
    public void test(){
        Assert.assertEquals(55,Fibonacci(10));
        Assert.assertEquals(102334155,Fibonacci(40));
        Assert.assertEquals(0,Fibonacci(0));
        Assert.assertEquals(1,Fibonacci(1));
    }

}
