import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.junit.Test;

import java.io.Serializable;

public class ApiTest implements Serializable {


    @Test
    public void ttt() {
        System.out.println(ObjectSizeCalculator.getObjectSize(true));
        System.out.println(ObjectSizeCalculator.getObjectSize(1));
        Object o = new Object();
        System.out.println(ObjectSizeCalculator.getObjectSize(o));
        String s = new String();
        System.out.println(ObjectSizeCalculator.getObjectSize(s));
        s = new String("1");
        System.out.println(ObjectSizeCalculator.getObjectSize(s));
        s = new String("aa");
        System.out.println(ObjectSizeCalculator.getObjectSize(s));
        s = new String("aaaa");
        System.out.println(ObjectSizeCalculator.getObjectSize(s));
    }




}