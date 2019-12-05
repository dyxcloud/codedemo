import java.io.Serializable;

public class ApiTest  implements Serializable{


    public static void main(String[] args) {
        B b = new B();

    }



}
class A{
    void show(){}
}
class B extends A{
    void show(){}
}