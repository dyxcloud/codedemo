package jdk.collections;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author DongYunxiang
 * @create 2018-08-23
 **/
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<People> set = new TreeSet<>(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if(o1.age!=o2.age){
                    return o1.age-o2.age;
                }else{
                    return o1.name.compareTo(o2.name);
                }
            }
        });
        set.add(new People(11,"abc"));
        set.add(new People(11,"bcd"));
        for(People p:set){
            System.out.println(p);
        }

        System.out.println(null==null);
    }
}

class People{
    int age;
    String name;
    public People(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
