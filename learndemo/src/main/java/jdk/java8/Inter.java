package jdk.java8;

public interface Inter {

    void getName();

    default void show(String s){
        System.out.println(s);
    }

    static void hello(){
        System.out.println("this is a interface");
    }

    static void main(String[] args) {
        Inter.hello();

        Inter m1 =()-> System.out.println("name is m1");
        m1.getName();
        m1.show("show word");
    }
}
