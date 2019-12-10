package learn.题目.剑指offer;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2019-12-10
 **/
@SuppressWarnings("NonAsciiCharacters")
public class n08旋转数组的最小数字 {


    public int minNumberInRotateArray(int [] arr) {
        if(arr==null||arr.length==0) return -1;
        if(arr.length==1) return arr[0];
        if(arr[0]<arr[arr.length-1]) return arr[0];

        int l=0,r=arr.length-1;
        int m = (l+r)/2;
        if(arr[l]==arr[m]&&arr[m]==arr[r])
            return fore(arr);

        while(l<r-1){
            m = (l+r)/2;
            if (arr[m - 1] > arr[m] && arr[m] <= arr[m + 1])
                return arr[m];
            else if(arr[r]<=arr[l]&&arr[l]<=arr[m]){
                l = m;//折点在右
            }else if(arr[m]<=arr[r]&&arr[r]<=arr[l]){
                r = m;
            }
        }
        return Math.min(arr[l],arr[r]);
    }

    public int fore(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1]) return arr[i];
        }
        return arr[0];
    }

    @Test
    public void test(){
        Assert.assertEquals(1,minNumberInRotateArray(new int[]{4,5,6,7,1,2,3}));
        Assert.assertEquals(1,minNumberInRotateArray(new int[]{3,4,5,1,2}));
        Assert.assertEquals(1,minNumberInRotateArray(new int[]{4,5,6,7,1}));
        Assert.assertEquals(1,minNumberInRotateArray(new int[]{7,1,2,3,4,5,6}));
        Assert.assertEquals(1,minNumberInRotateArray(new int[]{2,1}));

        Assert.assertEquals(1,minNumberInRotateArray(new int[]{4,5,6,7,1,1,2,3}));
        Assert.assertEquals(1,minNumberInRotateArray(new int[]{1,1,1}));
        Assert.assertEquals(1,minNumberInRotateArray(new int[]{2,2,2,2,2,1,2}));
        Assert.assertEquals(1,minNumberInRotateArray(new int[]{2,1,2,2,2,2,2}));
        Assert.assertEquals(1,minNumberInRotateArray(new int[]{3,3,3,3,3,1,2,2,2}));
        Assert.assertEquals(1,minNumberInRotateArray(new int[]{4,5,6,6,7,1,2,3,4}));

        Assert.assertEquals(-1,minNumberInRotateArray(new int[]{}));
        Assert.assertEquals(-1,minNumberInRotateArray(null));

        Assert.assertEquals(1,minNumberInRotateArray(new int[]{1}));
        Assert.assertEquals(1,minNumberInRotateArray(new int[]{1,2}));
        Assert.assertEquals(1,minNumberInRotateArray(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }
}
