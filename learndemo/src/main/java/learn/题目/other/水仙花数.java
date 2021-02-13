package learn.题目.other;

import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2019-04-15
 **/
public class 水仙花数 {

    @Test
    public void ttt(){
        m1();
    }

    void m1() {
        int x = 99999999;//遍历10~99999999中的自幂数
        int k = 0;
        for (int i = 10; i <= x; i++) {
            if (i % (x / 50) == 0) {    //打印遍历完成进度。
                k = k + 2;
                System.out.print(k + "%   ");
            }
            if (mishu(i))
                System.out.println(i);
        }
    }

    boolean mishu(int x) {
        int k = 0;
        int[] s = chaifen(x);
        for (int value : s) {
            k = k + pingfang(value, s.length);
        }
        return x == k;
    }

    int pingfang(int x, int y) {
        x = (int) Math.pow(x, y);
        // System.out.println(x);
        return x;
    }

    int[] chaifen(int x) {
        int l = String.valueOf(x).length();
        int[] s = new int[l];
        for (int i = 0; i < l; i++) {
            // System.out.println("--------"+ (pingfang(10,(l-i-1))));
            s[i] = x / (pingfang(10, (l - i - 1))) % 10;
        }
        return s;
    }

    static void m2() {
        int count = 0;
        for (int n = 100; n < 1000; n++) {
            if (isWant(n)) {
                System.out.println(n);
                count++;
            }
        }
        System.out.println("水仙花数共有:" + count + "个");
    }

    static boolean isWant(int n) {
        int x = n / 100;
        int y = n % 100 / 10;
        int z = n % 10;
        return n == x * x * x + y * y * y + z * z * z;
    }
}
