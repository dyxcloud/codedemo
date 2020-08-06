package jdk.泛型;

import java.lang.reflect.Type;

@SuppressWarnings("NonAsciiCharacters")
public class 泛型测试 {


    public static void main(String[] args) {
        Type genericSuperclass = Derived.class.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }
}

class Base<T> { }
class Derived extends Base<String> { }
