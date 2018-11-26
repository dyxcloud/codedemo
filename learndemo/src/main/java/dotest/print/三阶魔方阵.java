package dotest.print;

import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author DongYunxiang
 * @create 2018-11-20
 **/
public class 三阶魔方阵 {

    public static void main(String[] args) {
//        Integer[][] arr = {{4,3,8},{9,5,1},{2,7,6}};
//        Integer[][] arr = {{1,1,1},{1,1,1},{1,1,1}};
//        System.out.println(toStr(arr));
//        System.out.println(judge(arr));

        long start = System.currentTimeMillis();
        runAll0();
        long end = System.currentTimeMillis();
        System.out.println("runtime(ms): "+(end-start));
        System.out.println("runtime(min): "+TimeUnit.MILLISECONDS.toMinutes(end-start));

    }

    /**
     * 穷举生成所有方阵,生成时跳过数字重复的情况
     * @author DongYunxiang
     * @date 18.11.26
     */
    private static void runAll1(){
        // TODO run1 遍历[A99]的方式获取所有排列
        // 数量验证, 是否是所有的三阶方阵的情况

    }

    /**
     * //穷举生成所有的方阵
     * runtime(ms): 62201(8250u)
     * runtime(min): 1
     * @return
     */
    private static void runAll0(){
        int size = 10;
        Integer[][] arr = new Integer[3][3];
        for(int i1 = 1;i1<size;i1++){
            arr[0][0] = i1;
            for(int i2 = 1;i2<size;i2++){
                arr[0][1] = i2;
                for(int i3 = 1;i3<size;i3++){
                    arr[0][2] = i3;
                    for(int j1 = 1;j1<size;j1++){
                        arr[1][0] = j1;
                        for(int j2 = 1;j2<size;j2++){
                            arr[1][1] = j2;
                            for(int j3 = 1;j3<size;j3++){
                                arr[1][2] = j3;
                                for(int k1 = 1;k1<size;k1++){
                                    arr[2][0] = k1;
                                    for(int k2 = 1;k2<size;k2++){
                                        arr[2][1] = k2;
                                        for(int k3 = 1;k3<size;k3++){
                                            arr[2][2] = k3;
                                            if(judge(arr)) System.out.println(toStr(arr));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * 判断此方阵是否符合条件
     * @param arr
     * @return
     */
    private static boolean judge(Integer[][] arr) {
        int size = 3;
        // 判断二维数组长宽
        if (arr.length != size) return false;
        for (Integer[] anArr : arr) {
            if (anArr.length != size) return false;
        }

        //判断数字是否有重复1-9
        int memberCount[] = new int[10];
        memberCount[0] = 1;//0设置为正常值防止下面检测异常
        Arrays.stream(arr).forEach(col-> Arrays.stream(col).forEach(n->memberCount[n]++));
        //获取二维数组中出现次数不为1的数字的个数
        long get = Arrays.stream(memberCount).filter(count->count!=1).count();
        if(get!=0) return false;

        //判断行列的和
        int sum1 = 0, sum2 = 0,sumOut=0;//两个对角和行列的和
        for (int i = 0; i < size; i++) {
            //求i行
            int sumRow = 0;
            for (int x = 0; x < size; x++) {
                sumRow += arr[x][i];
            }
            //求i列
            int sumCol = 0;
            for (int y = 0; y < size; y++) {
                sumCol += arr[i][y];
            }

            if(sumRow!=sumCol) return false;//判断行列是否相等
            else if(sumOut!=0&&sumOut!=sumRow) return false;//在不是第一行第一列的情况下,判断此次的行列是否与上一次的行列相等
            else sumOut=sumRow;
            sum1 += arr[i][i];
            sum2 += arr[size -1 - i][i];
        }
        return sum1 == sum2 && sumOut == sum1;//两个对角相等,且和行列相等
    }


    private static String toStr(Integer[][] arr) {
        return "arr:" +"\r\n" +
                "\t" + arr[0][2] +
                "\t" + arr[1][2] +
                "\t" + arr[2][2] + "\r\n" +
                "\t" + arr[0][1] +
                "\t" + arr[1][1] +
                "\t" + arr[2][1] + "\r\n" +
                "\t" + arr[0][0] +
                "\t" + arr[1][0] +
                "\t" + arr[2][0] + "\r\n";
    }
}
