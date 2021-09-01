package learn.数据结构;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * 给定方程a_1{x_1}^3 + a_2{x_2}^3 + a_3{x_3}^3+ a_4{x_4}^3+ a_5{x_5}^3 = 0，
 * 请写一个程序，从控制台输入a_1,a_2,a_3,a_4,a_5，然后求共有多少整数解，
 * 其中限定-50 \le x_1,x_2, x_3, x_4, x_5 < 50。
 * @author DongYunxiang
 * @create 2019-05-22
 **/
public class HashTable {

    public static void solve(int a1, int a2, int a3, int a4, int a5) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = -50; i < 50; i++) {
            for (int j = -50; j < 50; j++) {
                for (int k = -50; k < 50; k++) {
                    int t = a1 * i * i * i + a2 * j * j * j + a3 * k * k * k;
                    m.merge(t, 1, (a, b) -> a + b);
                }
            }
        }

        int sum = 0;
        for (int i = -50; i < 50; i++) {
            for (int j = -50; j < 50; j++) {
                int t = a4 * i * i * i + a5 * j * j * j;
                Integer p = m.get(-t);
                if (p != null)
                    sum += p;
            }
        }
        System.out.print(sum);
    }

    @Test
    public void testRun(){
        solve(1,1,1,1,1);
    }
}
