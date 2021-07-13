import org.junit.Test;

import java.util.Date;

public class ApiTest {

    @Test
    public void ttt() {
        long i = (1000 * 60 * 60 * 24 * 365 * 10L);
        System.out.println(i);
        System.out.println(new Date().getTime() +  i);
        System.out.println(new Date().getTime());
    }

}
