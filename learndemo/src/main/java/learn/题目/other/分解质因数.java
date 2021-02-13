package learn.题目.other;

import java.util.Scanner;

/**
 * @author DongYunxiang
 * @create 2019-04-15
 **/
public class 分解质因数 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("请输入N的值：");
        int N=in.nextInt();
        new 分解质因数().fenjie(N);
    }

    public void fenjie(int N){
        for(int i=2;i<=N;i++){
            if(N%i==0){
                System.out.print(i);
                if(N!=i){
                    System.out.print("*");
                }
                fenjie(N/i);
            }
        }
        System.exit(0);
    }
}
