package dotest.dataDeal.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author DongYunxiang
 * @create 2019-04-15
 **/
public class ArrayData {

    public static final long[] ARR;

    static {
        Random random = new Random();
        ARR = random.longs(0,100).limit(10).toArray();
    }

    public static int[] getIntArr(){
        return Arrays.stream(ARR).mapToInt(l->(int)l).toArray();
    }

    public static void swap(long[] arr, int i1, int i2) {
        long tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    public static void swap(int[] arr,int i1, int i2){
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    public static boolean isSort(long[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]>arr[i]){
                return false;
            }
        }
        return true;
    }

    public static boolean isSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]>arr[i]){
                return false;
            }
        }
        return true;
    }

    @Test
    public void get() {
        System.out.println(Arrays.toString(ARR));
    }
}
