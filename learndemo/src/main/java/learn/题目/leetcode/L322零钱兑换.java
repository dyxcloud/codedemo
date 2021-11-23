package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.ToIntBiFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L322零钱兑换 {

    /**
     * BFS 依照剩余总数展开可能的分支, 找到凑齐的情况时直接返回层数
     * 超时
     */
    public int coinChange0(int[] coins, int amount) {
        if (amount == 0) return 0;
        Set<Integer> set = new HashSet<>();//算过的amount忽略, 因为一定是之前的层数小
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(amount);
        set.add(amount);
        int currentFloor = 0;
        int preFloorCount = 1;
        int currentFloorCount = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int i : coins) {
                if (i == poll) {
                    return ++currentFloor;
                } else if (i < poll) {
                    int newAmount = poll - i;
                    if (!set.contains(newAmount)) {
                        queue.offer(newAmount);
                        set.add(newAmount);
                        currentFloorCount++;
                    }
                }
            }
            preFloorCount--;
            if (preFloorCount == 0) {
                currentFloor++;
                preFloorCount = currentFloorCount;
                currentFloorCount = 0;
            }
        }
        return -1;
    }


    /**
     * DP f(n) = 1 + min{f(n-c0)......f(n-ci)}
     * f(11) = 1+ min{f(10), f(9), f(6)}
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        f1: for (int a = 1; a <= amount; a++) {
            int min = Integer.MAX_VALUE;
            for (int c : coins) {
                int val = a - c;
                if (val == 0) {
                    dp[a] = 1;
                    continue f1;
                } else if (val > 0 && dp[val] > 0) {
                    if (min > dp[val]) {
                        min = dp[val];
                    }
                }
            }
            dp[a] = (min == Integer.MAX_VALUE) ? -1 : 1 + min;
        }
        // System.out.println(Arrays.toString(dp));
        return dp[amount];
    }


    @Test
    public void tt() {
        ToIntBiFunction<int[], Integer> func = this::coinChange0;
        Assertions.assertEquals(3, func.applyAsInt(new int[]{1, 2, 5}, 11));
        Assertions.assertEquals(-1, func.applyAsInt(new int[]{2}, 3));
        Assertions.assertEquals(0, func.applyAsInt(new int[]{2}, 0));
        Assertions.assertEquals(1, func.applyAsInt(new int[]{1}, 1));
        Assertions.assertEquals(2, func.applyAsInt(new int[]{1}, 2));
        Assertions.assertEquals(20, func.applyAsInt(new int[]{1, 2, 5}, 100));
        Assertions.assertEquals(20, func.applyAsInt(new int[]{186, 419, 83, 408}, 6249));
    }

}
