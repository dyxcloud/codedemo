import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.function.Function;

public class ApiTest {

    @Test
    public void ttt() {
        float a = 0.33f;
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(a));
        System.out.println(bigDecimal);
        System.out.println(bigDecimal.doubleValue());
         
    }

    private <T, R> R limit(Function<T, R> func, T arg) {
        return func.apply(arg);
    }

}






