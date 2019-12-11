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


    /**
     * 跳台阶
     */
    public int JumpFloor(int target) {
        if(target<=2) return target;
        int a=1,b=2;
        for(int i=3;i<=target;i++){
            int tmp = a+b;
            a = b;
            b = tmp;
        }
        return b;
    }

    /**
     * 变态跳台阶
     * f(n) = f(n-1)+f(n-2)+....+f(0)+1
     */
    public int JumpFloorII_(int target) {
        if(target<1) return 0;
        int[] arr = new int[target];
        for(int i=1;i<target;i++){
            arr[i] = JumpFloorII(i);
        }
        arr[0] = 1;
        int result = 0;
        for (int anArr : arr) {
            result += anArr;
        }
        return result;
    }

    public int JumpFloorII(int target) {
        if(target<1) return 0;
        int[] arr = new int[target+1];
        arr[0] = 1;
        for(int i=1;i<arr.length;i++){
            int result = 0;
            for(int j=0;j<i;j++){
                result+=arr[j];
            }
            arr[i] = result;
        }
        return arr[arr.length-1];
    }


    @Test
    public void test2(){
        Assert.assertEquals(8,JumpFloorII(4));
        Assert.assertEquals(0,JumpFloorII(0));
        Assert.assertEquals(1,JumpFloorII(1));
        Assert.assertEquals(2,JumpFloorII(2));
    }


    /**
     * 矩形覆盖
     */

}
