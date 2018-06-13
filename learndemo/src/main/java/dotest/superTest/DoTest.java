package dotest.superTest;

import java.lang.reflect.Method;

public class DoTest {

    public static void show(Fu fu) {
        System.out.println("show fu");
    }
    public static void show(Zi zi) {
        System.out.println("show zi");
    }
    public static void main(String[] args) {
//        new Zi();
        
        Fu zi = new Sub();
        System.err.println(zi instanceof Sub);
        System.err.println(zi instanceof Zi);
        System.err.println(zi instanceof Fu);
    }
}

class Fu {
    public Fu() {
        System.out.println("fu C " + this);
        System.out.println(this.getClass());
        DoTest.show(this);
    }
}
class Zi extends Fu {
    protected Zi() {
        System.out.println("zi C " + this);
        System.out.println(this.getClass());
        DoTest.show(this);
    }
}
class Sub extends Zi{
    
}
