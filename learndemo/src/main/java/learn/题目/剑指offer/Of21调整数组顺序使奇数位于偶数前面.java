package learn.题目.剑指offer;

import org.junit.jupiter.api.Assertions;
import learn.sort.SortFunction;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author DongYunxiang
 * @create 2019-12-17
 **/
@SuppressWarnings("NonAsciiCharacters")
public class Of21调整数组顺序使奇数位于偶数前面 {

    /**
     * 不保留原先相对位置
     */
    @Deprecated
    public void reOrderArray_(int [] nums) {
        int l=0,r=nums.length-1;
        while(l<r){
            while(l<nums.length&&isOdd(nums[l])){
                l++;
                if(l>=r) break;
            }
            while(r>=0&&!isOdd(nums[r])){
                r--;
                if(l>=r) break;
            }
            if(l<r){
                SortFunction.swap(nums,l,r);
                l++;
                r--;
            }
        }
    }

    /**
     * 原本相对位置不变
     */
    public void reOrderArray(int [] nums) {
        int oddCount=0;
        for(int i:nums){
            if(isOdd(i)) oddCount++;
        }
        int[] data = nums.clone();
        int i=0,j=oddCount;
        for(int num:data){
            if(isOdd(num)){
                nums[i]=num;
                i++;
            }else{
                nums[j]=num;
                j++;
            }
        }
    }
    public boolean isOdd(int i){
        return (i&1)==1;
    }
    @Test
    public void testOrder(){
        // {
        //     int[] arr = {1,2,3,4,5,6,7};
        //     reOrderArray(arr);
        //     System.out.println(Arrays.toString(arr));
        //     Assertions.assertTrue(Arrays.equals(arr,new int[] {1,3,5,7,2,4,6}));
        // }
        {
            int[] arr = {2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1};
            reOrderArray_(arr);
            System.out.println(Arrays.toString(arr));
            Assertions.assertTrue(Arrays.equals(arr,new int[] {1,5,  3,5,13,1,11,  1,11,11, 18,8  ,12  ,16  ,16,2}));
        }
    }
}
