package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author DongYunxiang
 * @create 2021-05-13
 **/
public class L448找到所有数组中消失的数字 {

    //辅助数组
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] log = new int[nums.length + 1];
        for (int num : nums) {
            log[num]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < log.length; i++) {
            if (log[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }

    //无额外空间
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i]);
            index--;
            if(nums[index]>0){
                nums[index] = -nums[index];
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }

    @Test
    public void tt() {
        Function<int[], List<Integer>> f = this::findDisappearedNumbers1;
        {
            TestCase.assertEquals(Arrays.asList(5, 6)
                    , f.apply(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        }
    }
}
