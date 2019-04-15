package dotest.dataDeal;

/**
 * @author DongYunxiang
 * @create 2019-04-15
 **/
public class 水仙花数 {

    public static void main(String args[]) {
        Math1 m = new Math1();
        int x=99999999;//遍历10~99999999中的自幂数
        int k=0;
        for (int i = 10; i <= x; i++){
            if(i%(x/50)==0){    //打印遍历完成进度。
                k=k+2;
                System.out.print(k+"%   ");
            }

            if (m.mishu(i) == true)
                System.out.println(i);
        }
    }

    /*    */ public static void main2(String[] args) {
        int count = 0;
        /* 7 */ for (int n = 100; n < 1000; n++) {
            /* 8 */ if (math(n)) {
                /* 9 */ System.out.println(n);
                count++;
                /*    */ }
            /*    */ }
        System.out.println("水仙花数共有:" + count + "个");
        /*    */ }

    public static boolean math(int n) {
        /* 15 */ int x = n / 100;
        // 百位
        /* 16 */ int y = n % 100 / 10;
        // 十位
        /* 17 */ int z = n % 10;
        // 个位
        /* 18 */ if (n == x * x * x + y * y * y + z * z * z) {
            /* 19 */ return true;
            /*    */ }
        /* 21 */ return false;
        /*    */ }
}

class Math1 {

    public boolean mishu(int x) {
        int k = 0;
        int[] s = chaifen(x);
        for (int i = 0; i < s.length; i++) {
            k=k+pingfang(s[i],s.length);
        }
        if(x==k)
            return true;
        else
            return false;
    }

    public int pingfang(int x, int y) {
        x = (int) Math.pow(x, y);
        // System.out.println(x);
        return x;
    }

    public int[] chaifen(int x) {
        int l = String.valueOf(x).length();
        int[] s = new int[l];
        for (int i = 0; i < l; i++) {
            // System.out.println("--------"+ (pingfang(10,(l-i-1))));
            s[i] = x / (pingfang(10, (l - i - 1))) % 10;
        }
        return s;
    }
}