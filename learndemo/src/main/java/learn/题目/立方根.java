package learn.题目;

import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2019-05-30
 **/
public class 立方根 {

    public double get3(double x) {
        double low = 0;
        double high = x;
        double mid;
        while(Math.abs(high)>Math.abs(low)){
            mid = low/2+high/2;
            double r = Math.abs(mid*mid*mid);
            if(Math.abs(r-Math.abs(x))<0.001){
                return mid;
            }else if(r>Math.abs(x)){
                high = mid;
            }else if(r<Math.abs(x)){
                low = mid;
            }
        }
        throw new RuntimeException("not found");
    }

    @Test
    public void testGet3(){
        System.out.println(get3(-64));
    }
}
