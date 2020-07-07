import java.io.Serializable;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ApiTest  implements Serializable{


    public static ApiTest instance = new ApiTest();

    public static void main(String[] args) throws Exception {
        func();
        func(null);
        func(1);

    }

    public static void func(int...i){
        System.out.println(i);
    }


}