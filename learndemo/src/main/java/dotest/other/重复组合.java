package dotest.other;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * 计算n个元素中取n个元素(可重复)有多少种组合
 *
 * @author DongYunxiang
 * @create 2019-03-20
 **/
public class 重复组合 {



    public static long getter(long n) {
        //完整公式n个元素中可重复的取r个 C(n+r-1,r) = (n+r-1)! / ((n-1)!*r!)
        //可理解为按照把r个球用n-1个隔断分为n个部分
        // 一共(n+r-1)个元素的全排列, 再去除隔断的排列情况(n-1)!和小球的排列情况r!
        return C(2 * n - 1, n);
    }

    public static long getter2(long n){
        //TODO
        // f(4)=c(1,4)*c(0,3)+c(2,4)*c(1,3)+c(3,4)*c(2,3)+c(4,4)*c(3,3)=35
        // 4*1+6*3+4*3+1*1
        // n种颜色的取法*这 n 种颜色的组合
        //f(x)=∑C(i,x)*C(i-1,x-1)  1.取x个球中i个颜色的数量组合 2.从x-1个球中取i-1个的组合
        return 0;
    }

    public static long getter3(long n){
        LongStream.rangeClosed(1,n).forEach(x->{
            //从n中颜色中取x种,  n个位置中有x个固定, 还剩n-x个位置由x种颜色自由组合
            //c(n,x)*c(x,n-x)  41*13
        });
        return 0;
    }

    private static long factorial(long n) {
        if (n <= 1) return n;
        return n * factorial(n - 1);
    }

    private static long A(long n, long m) {
        if (m <= 1) return n;
        return n * A(n - 1, m - 1);
    }

    private static long C(long n, long m) {
        return A(n, m) / factorial(m);
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).forEach(n ->
                System.out.println(n + "\t" + getter(n))
        );
    }

}
