package show;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author DongYunxiang
 * @create 2018-09-12
 **/
public class BigDecDemo {
    public static void main(String[] args) {
        BigDecimal b = new BigDecimal(1.745);
        System.out.println(b.setScale(2, RoundingMode.HALF_UP));
        BigDecimal b1 = new BigDecimal(0.745);
        System.out.println(b1.setScale(2, RoundingMode.HALF_UP));

        System.out.println(BigDecimal.valueOf(1).divide(BigDecimal.valueOf(3)));
    }
}
