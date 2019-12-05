package learn.数据结构;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author DongYunxiang
 * @create 2019-05-30
 **/
public class HeapDemo {

    private class Student {
        public int age;
        public String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    @Test
    public void testSortStudent(){
        PriorityQueue<Student> students = new PriorityQueue<>(Comparator.comparingInt(o -> o.age));
        Student s1 = new Student(3, "小q");
        Student s2 = new Student(13, "小w");
        Student s3 = new Student(34, "小e");
        Student s4 = new Student(13, "小r");
        Student s5 = new Student(24, "小t");
        Student s6 = new Student(9, "小y");
        students.offer(s1);
        students.offer(s2);
        students.offer(s3);
        students.offer(s4);
        students.offer(s5);
        students.offer(s6);
        while(!students.isEmpty()){
            System.out.println(students.poll());
        }
    }

    @Test
    public void testGetMid(){

    }
}
