package dotest.print;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 * @author DongYunxiang
 * @create 2018-11-20
 **/
public class 三阶魔方阵 {

    public static void main(String[] args) {
        Integer[][] arr = {{8,1,6},{3,5,7},{4,9,2}};
        System.out.println(judge(arr,3));
    }



    public static boolean judge(Integer[][] arr,int size) {
        if (arr.length != size) return false;
        for (Integer[] anArr : arr) {
            if (anArr.length != size) return false;
        }

        //求对角
        int sum1 = 0, sum2 = 0,sumOut=0;
        for (int i = 0; i < size; i++) {
            //求i行
            int sumx = 0;
            for (int x = 0; x < size; x++) {
                sumx += arr[x][i];
            }
            //求i列
            int sumy = 0;
            for (int y = 0; y < size; y++) {
                sumy += arr[i][y];
            }

            if(sumx!=sumy) return false;//判断行列是否相等
            else if(sumOut!=0&&sumOut!=sumx) return false;//判断此次的行列是否与上一次的行列相等
            else sumOut=sumx;
            sum1 += arr[i][i];
            sum2 += arr[size -1 - i][i];
        }
        if(sum1!=sum2) return false;
        if(sumOut!=sum1) return false;
        return true;
    }
}
