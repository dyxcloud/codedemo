package learn.题目.剑指offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author DongYunxiang
 * @create 2019-12-11
 **/
@SuppressWarnings("NonAsciiCharacters")
public class Of10斐波那契数列 {

    HashMap<Integer,Integer> cache = new HashMap<>();
    @Deprecated
    public int fib_(int n) {
        if(n<0) throw new RuntimeException("wrong data");
        if (n < 2) return n;
        if(cache.get(n)!=null){
            return cache.get(n);
        }else{
            int result = fib_(n - 1) + fib_(n - 2);
            cache.put(n,result);
            return result;
        }
    }

    public int fib(int n){
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
        Assertions.assertEquals(55, fib(10));
        Assertions.assertEquals(102334155, fib(40));
        Assertions.assertEquals(0, fib(0));
        Assertions.assertEquals(1, fib(1));
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
     * f(1) = 1
     * f(2) = f(1)+1
     * f(n) = f(n-1)+f(n-2)+....+f(1)+1
     * f(n) = 最后剩1层的情况+最后剩2层的情况+最后剩3层的情况+....+最后剩n-1层的情况+1
     */
    public int JumpFloorII(int target) {
        int[] arr = new int[target+1];
        arr[0] = 1;
        for(int i=1;i<arr.length;i++){
            for(int j=0;j<i;j++){
                arr[i]+=arr[j];
            }
        }
        return arr[arr.length-1];
    }

    @Test
    public void test2(){
        Assertions.assertEquals(8,JumpFloorII(4));
        Assertions.assertEquals(1,JumpFloorII(1));
        Assertions.assertEquals(2,JumpFloorII(2));
    }


    /**
     * 矩形覆盖
     */
    public int RectCover(int target) {
        if(target<3) return target;
        int result = 0;
        int a=1,b=2;
        for(int i=3;i<=target;i++){
            int tmp = a+b;
            a = b;
            b = tmp;
        }
        return b;
    }

}
