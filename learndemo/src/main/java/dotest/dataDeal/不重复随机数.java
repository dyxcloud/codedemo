package dotest.dataDeal;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author DongYunxiang
 * @create 2019-04-15
 **/
public class 不重复随机数 {

    void m1(){
        Random rd=new Random();
        ArrayList<Integer> list=new ArrayList<Integer>();
        for (int i = 0; i < 14; i++) {
            list.add(i);
        }
        int[] ars=new int[12];
        for (int i = 0; i < ars.length; i++) {
            int index=rd.nextInt(list.size());
            ars[i]=list.remove(index);
        }
        for (int i : ars) {
            System.out.println(i);
        }
    }

    void m2(){
        /*
         * 打印10个0~12之间的随机数,且不能重复
         */
        Random rd = new Random();
        int[] arrays = new int[4];
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = rd.nextInt(4);
            for (int j = 0; j < i; j++) {
                if (arrays[i] == arrays[j]) {
                    arrays[i] = rd.nextInt(5);
                    j = -1;
                }
            }
        }
        for (int s : arrays) {
            System.out.println(s);
        }
    }
}
