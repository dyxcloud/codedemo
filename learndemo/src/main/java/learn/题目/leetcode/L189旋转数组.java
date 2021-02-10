package learn.题目.leetcode;

import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("NonAsciiCharacters")
public class L189旋转数组 {

    @Test
    public void test1() {
        {
            int[] arr = {1, 2, 3, 4, 5, 6, 7};
            int[] target = {5, 6, 7, 1, 2, 3, 4};
            rotate(arr, 3);
            Assert.assertArrayEquals(target, arr);
        }
        {
            int[] arr = {1, 2, 3, 4, 5, 6, 7};
            int[] target = {4, 5, 6, 7, 1, 2, 3};
            rotate(arr, 4);
            Assert.assertArrayEquals(target, arr);
        }
        {
            int[] arr = {1, 2, 3, 4, 5, 6, 7};
            int[] target = {7, 1, 2, 3, 4, 5, 6};
            rotate(arr, 1);
            Assert.assertArrayEquals(target, arr);
        }
        {
            int[] arr = {1, 2, 3, 4, 5, 6, 7};
            int[] target = {1, 2, 3, 4, 5, 6, 7};
            rotate(arr, 0);
            Assert.assertArrayEquals(target, arr);
        }
        {
            int[] arr = {1, 2, 3, 4, 5, 6};
            int[] target = {4, 5, 6, 1, 2, 3};
            rotate(arr, 3);
            Assert.assertArrayEquals(target, arr);
        }
        {
            int[] arr = {1, 2, 3, 4, 5, 6};
            int[] target = {3,4,5,6,1,2};
            rotate(arr, 4);
            Assert.assertArrayEquals(target, arr);
        }
    }

    public void rotateMy(int[] nums, final int k) {
        if (k == 0) return;
        if (nums.length < 2) return;
        int i = 0;
        int tmp = nums[i];
        nums[i] = -1;

        while (tmp >= 0) {
            int next = i + k;
            if (next >= nums.length) {
                next -= nums.length;
            }

            //tmp next互换
            int zz = tmp;
            tmp = nums[next];
            nums[next] = zz;

            i = next;

            if (tmp < 0 //一次循环结束
                    && (nums.length % k == 0 && k != 1) //不能错位
                    && i < k - 1) {//最后一次循环i=k-1
                i++;
                tmp = nums[i];
                nums[i] = -1;
            }
        }
    }

    public void rotate(int[] nums, int k) {
        if (nums.length < 2) return;
        if (nums.length == k) return;
        if (k > nums.length) k -= nums.length;
        if (k == 0) return;
        int i = 0;
        int tmp = nums[i];
        nums[i] = Integer.MIN_VALUE;

        while (tmp != Integer.MIN_VALUE) {
            int next = i + k;
            if (next >= nums.length) {
                next -= nums.length;
            }

            //tmp next互换
            int zz = tmp;
            tmp = nums[next];
            nums[next] = zz;

            i = next;

            if (tmp == Integer.MIN_VALUE //一次循环结束
                    && (
                            (nums.length % k == 0 && k != 1&&i<k-1) //不能错位
                            || (isNumber(k, nums.length) && i < getNewLoopCount(k, nums.length))//k位移length次之内 出现length的倍数
            ))  {
                i++;
                tmp = nums[i];
                nums[i] = Integer.MIN_VALUE;
            }
        }
    }

    public boolean isNumber(int k, int length){
        //k位移length次之内 出现length的倍数
        int n=0;
        for(int i=0;i<length-1;i++){
            n+=k;
            if (n >= length && n % length == 0) {
                return true;
            }
        }
        return false;
    }

    //4 6 返回1
    //3 6 返回2
    //2 4 返回1
    public int getNewLoopCount(int k, int length){
        //k位移length次之内 出现length的倍数
        int n=0;
        for(int i=0;i<length-1;i++){
            n+=k;
            if (n > length && n % length == 0) {
                return i-1;
            }
        }
        return 0;
    }
}
