package learn.题目.剑指offer;

import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2019-12-16
 **/
@SuppressWarnings("NonAsciiCharacters")
public class Of17打印1到最大的n位数 {

    public void print1ToMaxOfNDigits(int n) {
        if(n<0) throw new RuntimeException("wrong data n");
        if(n==0) return;
        int[] data = new int[n+1];
        while(data[data.length-1]!=1){
            add(data);
            print(data);
        }
    }
    public void add(int[] data){
        data[0]++;
        for(int i=0;i<data.length-1;i++){
            if(data[i]>9){
                data[i]=0;
                data[i+1]++;
            }else{
                break;
            }
        }
    }
    public void print(int[] data){
        boolean haveData = false;
        for(int i=data.length-2;i>=0;i--){
            if(!haveData&&data[i]!=0) haveData = true;
            if(haveData) System.out.print(data[i]);
        }
        System.out.println();
    }
    @Test
    public void test(){
        print1ToMaxOfNDigits(3);
    }

}
