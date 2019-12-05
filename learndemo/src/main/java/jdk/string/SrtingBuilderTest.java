package jdk.string;

import java.io.IOException;

public class SrtingBuilderTest {
    static int time = 100000;

    public static long getTime1() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            String.format("hello%sWorld %s", i, "newword");
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long getTime2() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            String s = "hello" + i + "World " + "newword";
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long getTime3() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            String s = new StringBuilder().append("hello").append(i).append("World ").append("newword").toString();
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long printTime1() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            System.out.println("hello" + i + "World " + "newword");
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long printTime2() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            System.out.printf("hello%sWorld %s\r\n", i, "newword");
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static void main(String[] args) throws IOException {
        // System.out.println(getTime1());
        // System.out.println(getTime2());
        // System.out.println(getTime3());
        long printTime1 = printTime1();
        long printTime2 = printTime2();
        System.out.println(printTime1);
        System.out.println(printTime2);
    }
}
