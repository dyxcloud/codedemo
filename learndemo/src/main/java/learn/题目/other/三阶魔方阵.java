package learn.题目.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
//        run0();//不去重穷举
//        run1();//不去重穷举
//        run2();//去重穷举
        run3();//算法生成
        long end = System.currentTimeMillis();
        System.out.println("counter: "+counter);
        System.out.println("runtime(ms): "+(end-start));
        System.out.println("runtime(min): "+TimeUnit.MILLISECONDS.toMinutes(end-start));

    }

    /**
     * 使用魔方阵算法生成
     * (1)将1放在第1行的中间一列。
     * (2)从2开始直到n×n止各数依次按下列规则存放：每一个数存放的行比前一个数的行数减1，列数加1
     * (3)如果上一数的行数为1，则下一个数的行数为n(指最下一行)。例如，1在第一行，则2应放在最下一行，列数同样加1.
     * (4)当上一个数的列数为n时，下一个数的列数应为1，行数减1.例如，2在第3行最后一列，则3应放在第2行第1列。
     * (5)如果按上面规则确定的位置上已有数，或上一个数是第一行第n列时，则把下一个数放在上一个数的下面。
     */
    private static void run3(){
        final int size = 3;
        Integer[][] arr = new Integer[size][size];
        for(int n=1,x=size/2,y=size-1;n<=size*size;n++){
            if(n==1){arr[x][y] = n;}
            else{
                if (x == size - 1 && y == size - 1) {//上一个数的位置在第一行最后一列
                    y = run3Helper(size,y,-1);
                } else if(arr[run3Helper(size, x, 1)][run3Helper(size, y, 1)] != null) {//下一个数的位置已经有数
                    y = run3Helper(size,y,-1);
                }else {
                    x = run3Helper(size, x, 1);
                    y = run3Helper(size, y, 1);
                }
                arr[x][y] = n;
            }
        }
        if(judge(arr)) System.out.println(toStr(arr));
    }

    private static int run3Helper(final int size, int index,int add){
        int result = index+add;
        if(result<0) return 2;
        if(result>=size) return 0;
        return result;
    }

    /**
     * 穷举生成所有方阵,生成时跳过数字重复的情况
     * runtime(ms): 506(8250u)
     * runtime(min): 0
     * @author DongYunxiang
     * @date 18.11.26
     */
    private static void run2(){
        // 遍历[A99]的方式获取所有排列
        run2Helper(new int[]{1,2,3,4,5,6,7,8,9},new ArrayList<>());
        // 数量验证, 是否是所有的三阶方阵的情况

    }

    private static void run2Helper(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            Integer[][] arr = {{list.get(0), list.get(1), list.get(2)}
                    , {list.get(3), list.get(4), list.get(5)}
                    , {list.get(6), list.get(7), list.get(8)}};
            if(judge(arr)) System.out.println(toStr(arr));
        } else {
            for (int n : nums) {
                if (!list.contains(n)) {
                    list.add(n);
                    run2Helper(nums, list);
                    list.remove(list.size() - 1);
                }
            }
        }
    }


    /**
     * 穷举生成所有方阵, 不去重, 使用递归的方式
     * runtime(ms): 84274(8250u)
     * runtime(min): 1
     */
    private static void run1(){
        run1Helper(new int[]{1,2,3,4,5,6,7,8,9},new ArrayList<>());
    }

    private static void run1Helper(int[] nums, ArrayList<Integer> list) {
        if(list.size()==nums.length){
            Integer[][] arr = {{list.get(0), list.get(1), list.get(2)}
                    , {list.get(3), list.get(4), list.get(5)}
                    , {list.get(6), list.get(7), list.get(8)}};
            if(judge(arr)) System.out.println(toStr(arr));
        }else{
            for(int n:nums){
                list.add(n);
                run1Helper(nums,list);
                list.remove(list.size()-1);
            }
        }
    }

    /**
     * 穷举生成所有的方阵
     * runtime(ms): 62201(8250u)
     * runtime(min): 1
     * @return
     */
    private static void run0(){
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



    private static long counter = 0;//校验时计数数字不重复方阵的个数

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
        counter++;

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
