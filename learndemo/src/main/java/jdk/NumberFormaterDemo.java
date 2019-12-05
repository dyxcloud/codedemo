package jdk;

import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * @author DongYunxiang
 * @create 2018-09-12
 **/
public class NumberFormaterDemo {
    public static void main(String[] args) {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(1);
        nf.setRoundingMode(RoundingMode.HALF_UP);

        System.out.println(nf.format(99.55));
        System.out.println(nf.format(-99.55));


    }
}
