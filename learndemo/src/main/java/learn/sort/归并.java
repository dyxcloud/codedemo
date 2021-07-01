package learn.sort;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author DongYunxiang
 * @create 2019-05-31
 **/
public class 归并 extends SortFunction{

    public void mergeSort(int[] arr){
        mergeSort(arr,0,arr.length-1);
    }

    private void mergeSort(int[] arr,int start,int end){
        if(end-start<1){
            return;
        }
        // if(end-start==1){
        //     if(arr[start]>arr[end]){
        //         ArrayData.swap(arr,start,end);
        //     }
        //     return;
        // }
        int mid = (start+end)/ 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid+1, end);
    }

    private void merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int p = 0;
        int i=low,j=mid;
        while(i<mid&&j<=high){
            if(arr[i]<arr[j]){
                temp[p++]=arr[i++];
            }else{
                temp[p++]=arr[j++];
            }
        }
        while(i<mid){
            temp[p++]=arr[i++];
        }
        while(j<=high){
            temp[p++]=arr[j++];
        }
        for(p=0,i=low;i<=high;i++,p++) {
            arr[i] = temp[p];
        }
    }

    @Test
    public void testMerge(){
        int[] a = {1,3,7,9,2,4,6,8};
        merge(a,0,4,7);
        System.out.println(Arrays.toString(a));
        TestCase.assertTrue(isSort(a));

        a =new int[]{3,1};
        merge(a,0,1,1);
        System.out.println(Arrays.toString(a));
        TestCase.assertTrue(isSort(a));
    }
    @Test
    public void testSort(){
        int[] arr = getArr();
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        TestCase.assertTrue(isSort(arr));
    }
}
