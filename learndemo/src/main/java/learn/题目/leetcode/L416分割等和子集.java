package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

@SuppressWarnings("NonAsciiCharacters")
public class L416分割等和子集 {

    public boolean canPartition0(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        // System.out.println(sum);
        cache = new HashSet<>();
        // Arrays.sort(nums);//不需要排序 因为cache记录的就是 当前num+total时 后半段所有可能组合是否能达到target
        return walk(nums, 0, 0, sum);
    }

    Set<String> cache = new HashSet<>();

    /**
     * 回溯
     */
    private boolean walk(int[] nums, int index, int total, final int target) {
        if (index >= nums.length) return false;
        // System.out.println(index + ">>>>>>" + nums[index] + ">>>>>" + total);
        for (int i = index; i < nums.length; i++) {
            //构建缓存(num+total) 如果已经在缓存中一定是无法加和到target的 
            String cacheKey = nums[i] + ">" + total;
            if (cache.contains(cacheKey)) {
                continue;
            } else {
                cache.add(cacheKey);
            }
            int sum = total + nums[i];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                boolean test = walk(nums, i + 1, sum, target);
                if (test) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * DP
     * \  1 5 11 5
     * 0  Y Y Y  Y
     * 1  Y Y Y  Y
     * 2  N N N  N
     * 3  N N N  N
     * 4  N N N  N
     * 5  N Y Y  Y
     * 6  N Y Y  Y
     * 7  N
     * 8  N
     * 9  N
     * 10 N
     * 11 N
     * <p>
     * i: 0~i范围 j:目标和
     * f(i,j) = {
     * num[i]>j: f(i-1,j)
     * num[i]<j: f(i-1,j) || f(i-1,j-num[i])
     * }
     */
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) return false;
        int sum = 0;
        int max = 0;
        for (int n : nums) {
            sum += n;
            if (n > max) {
                max = n;
            }
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        if (max > sum) {
            return false;
        }
        boolean[][] dp = new boolean[nums.length][sum + 1];
        //i=0只可能有一个Y
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) { //跳过i=0 
            for (int j = 1; j <= sum; j++) { //跳过j=0
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = true;
                }
            }
        }
        return dp[nums.length - 1][sum];
    }


    @Test
    public void tt() {
        Predicate<int[]> func = this::canPartition;
        /*
         * 22/2=11
         * 回溯
         */
        Assertions.assertTrue(func.test(new int[]{1, 5, 11, 5}));
        Assertions.assertFalse(func.test(new int[]{9, 5}));
        Assertions.assertFalse(func.test(new int[]{1, 2, 3, 5}));
        Assertions.assertFalse(func.test(new int[]{4, 4, 4, 4, 4, 4, 4, 4, 8, 8, 8, 8, 8, 8, 8, 8, 12, 12, 12, 12, 12, 12, 12, 12, 16, 16, 16, 16, 16, 16, 16, 16, 20, 20, 20, 20, 20, 20, 20, 20, 24, 24, 24, 24, 24, 24, 24, 24, 28, 28, 28, 28, 28, 28, 28, 28, 32, 32, 32, 32, 32, 32, 32, 32, 36, 36, 36, 36, 36, 36, 36, 36, 40, 40, 40, 40, 40, 40, 40, 40, 44, 44, 44, 44, 44, 44, 44, 44, 48, 48, 48, 48, 48, 48, 48, 48, 52, 52, 52, 52, 52, 52, 52, 52, 56, 56, 56, 56, 56, 56, 56, 56, 60, 60, 60, 60, 60, 60, 60, 60, 64, 64, 64, 64, 64, 64, 64, 64, 68, 68, 68, 68, 68, 68, 68, 68, 72, 72, 72, 72, 72, 72, 72, 72, 76, 76, 76, 76, 76, 76, 76, 76, 80, 80, 80, 80, 80, 80, 80, 80, 84, 84, 84, 84, 84, 84, 84, 84, 88, 88, 88, 88, 88, 88, 88, 88, 92, 92, 92, 92, 92, 92, 92, 92, 96, 96, 96, 96, 96, 96, 96, 96, 97, 99}));
        Assertions.assertFalse(func.test(new int[]{100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 99, 97}));
    }
}
