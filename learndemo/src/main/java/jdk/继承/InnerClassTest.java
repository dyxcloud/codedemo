package jdk.继承;

/**
 * @author DongYunxiang
 * @create 2019-11-05
 **/
public class InnerClassTest {

    String out;

    class In{
        public void show(){
            method();
            System.out.println(out);
        }
    }

    public static void main(String[] args) {
        InnerClassTest th = new InnerClassTest();
        In in1 = th.new In();
        in1.show();
    }

    public void method(){
        In in = new In();
        in.show();
    }
}
