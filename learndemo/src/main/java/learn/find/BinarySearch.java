package learn.find;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class BinarySearch {


    public int bs(int[] arr, int des) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (des > arr[mid]) {
                low = mid + 1;
            } else if (des < arr[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public int bsr(int[] arr, int des, int low, int high) {
        if (low > high || des > arr[high] || des < arr[low])
            return -1;
        int mid = (low + high) / 2;
        if (des > arr[mid]) {
            return bsr(arr, des, mid + 1, high);
        } else if (des < arr[mid]) {
            return bsr(arr, des, low, mid - 1);
        } else {
            return mid;
        }
    }

    @Test
    public void test() {
        {
            int[] arr = IntStream.rangeClosed(0, 9999999).toArray();// 生成一个0到n的顺序数组
            int target = 5645789;
            Assert.assertEquals(target, bs(arr, target));
            target = -1;
            Assert.assertEquals(-1, bs(arr, target));
        }
    }


    public void find(char[] ar1, char[] ar2) {
        char[] longar = ar1.length > ar2.length ? ar1 : ar2;
        int l = 0;
        int r = Math.min(ar1.length, ar2.length) - 1;
        int mid = l + (r - l) / 2;
        while (l <= r) {
            if (ar1[mid] == ar2[mid]) {
                if (ar1[mid + 1] != ar2[mid]) {
                    System.out.println(longar[mid + 1]);
                    break;
                }
                //右边
                l = mid;
            } else {
                //左边
                r = mid;
            }
        }
    }


    @Test
    public void testfind() {
        char[] ar1 = {'a', 'b', 'c', 'e', 'f'};
        char[] ar2 = {'a', 'b', 'c', 'd', 'e', 'f'};
        find(ar1, ar2);
    }
}
