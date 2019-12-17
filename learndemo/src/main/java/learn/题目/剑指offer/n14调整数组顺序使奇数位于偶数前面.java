package learn.题目.剑指offer;

import junit.framework.TestCase;
import learn.sort.ArrayData;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author DongYunxiang
 * @create 2019-12-17
 **/
@SuppressWarnings("NonAsciiCharacters")
public class n14调整数组顺序使奇数位于偶数前面 {

    /**
     * 不保留原先相对位置
     */
    @Deprecated
    public void reOrderArray_(int [] array) {
        int l=0,r=array.length-1;
        while(l<r){
            if(l<array.length&&isOdd(array[l])){
                l++;
            }
            if(r>=0&&!isOdd(array[r])){
                r--;
            }
            if(l<r){
                ArrayData.swap(array,l,r);
                l++;
                r--;
            }
        }
    }

    /**
     * 原本相对位置不变
     */
    public void reOrderArray(int [] array) {
        int oddCount=0;
        for(int i:array){
            if(isOdd(i)) oddCount++;
        }
        int[] data = array.clone();
        int i=0,j=oddCount;
        for(int num:data){
            if(isOdd(num)){
                array[i]=num;
                i++;
            }else{
                array[j]=num;
                j++;
            }
        }
    }
    public boolean isOdd(int i){
        return (i&1)==1;
    }
    @Test
    public void testOrder(){
        int[] arr = {1,2,3,4,5,6,7};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
        TestCase.assertTrue(Arrays.equals(arr,new int[] {1,3,5,7,2,4,6}));
    }
}
