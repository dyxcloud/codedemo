import java.io.Serializable;
import java.util.stream.IntStream;

public class ApiTest  implements Serializable{


    public static void main(String[] args) {
        IntStream.rangeClosed(0,-5).forEach(System.out::println);

    }



}
class A{
    void show(){}
}
class B extends A{
    void show(){}
}