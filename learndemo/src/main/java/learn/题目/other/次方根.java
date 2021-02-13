package learn.题目.other;

import junit.framework.TestCase;
import org.junit.Test;

@SuppressWarnings("NonAsciiCharacters")
public class 次方根 {


    @Test
    public void testGetRoot() {
        RootGetter rootGetter = new RootGetter();
        TestCase.assertEquals(3.0, rootGetter.getRoot(9, 2));
        TestCase.assertEquals(3.0, rootGetter.getRoot(27, 3));
        TestCase.assertEquals(3.872, rootGetter.getRoot(15, 2));
    }

    @Test
    public void testGet3(){
        Get3 get3 = new Get3();
        System.out.println(get3.get3(-64));
    }


    class RootGetter{
        /**
         * 获取num的pow次方根
         */
        public double getRoot(long num, int times) {
            final int accuracy = -3;
            int size = getSize(num, times);
            double l = 0;
            while (--size >= accuracy) {
                l += pow(10, size);
                double nextL = l + pow(10, size);
                while (true) {
                    double guess = pow(nextL, times);
                    if (guess > num) {
                        break;
                    } else if (guess == num) {
                        return nextL;
                    } else {
                        l = nextL;
                        nextL = l + pow(10, size);
                    }
                }
            }
            return l;
        }

        /**
         * 获取次方根的位数
         */
        private int getSize(long num, int pow) {
            num = Math.abs(num);
            int i = 0;
            while (true) {
                double base = pow(10, i);
                if (pow(base, pow) > num) {
                    return i;
                }
                i++;
            }
        }

        private double pow(double n, int times) {
            return Math.pow(n,times);
        /*if (times == 0) return 1;
        double result = 1;
        for (int i = 1; i <= Math.abs(times); i++) {
            result *= n;
        }
        return times > 0 ? result : 1 / result;*/
        }

        @Test
        public void testmethod() {
            TestCase.assertEquals(100.0, pow(10, 2));
            TestCase.assertEquals(10.0, pow(10, 1));
            TestCase.assertEquals(1.0, pow(10, 0));
            TestCase.assertEquals(121.0, pow(11, 2));
            TestCase.assertEquals(0.1, pow(10, -1));
            TestCase.assertEquals(0.01, pow(10, -2));

            TestCase.assertEquals(2, getSize(121, 2));
            TestCase.assertEquals(2, getSize(100, 2));
            TestCase.assertEquals(1, getSize(81, 2));
            TestCase.assertEquals(1, getSize(9, 2));
            TestCase.assertEquals(1, getSize(1, 2));
            TestCase.assertEquals(0, getSize(0, 2));
            TestCase.assertEquals(1, getSize(27, 3));
        }
    }

    class Get3{
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
    }

}
