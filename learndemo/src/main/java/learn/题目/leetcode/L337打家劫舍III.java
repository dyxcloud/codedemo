package learn.题目.leetcode;

import learn.题目.剑指offer.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L337打家劫舍III {

    /**
     * DP
     * f(root) = max{
     * root + f(ll) + f(lr) + f(rl) + f(rr)
     * f(l) + f(r)
     * }
     */
    Map<TreeNode, Integer> cache = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (cache.containsKey(root)) {
            return cache.get(root);
        }
        int sum1 = root.val;
        if (root.left != null) {
            sum1 += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            sum1 += (rob(root.right.left) + rob(root.right.right));
        }
        int sum2 = rob(root.left) + rob(root.right);
        if (sum1 < sum2) {
            sum1 = sum2;
        }
        cache.put(root, sum1);
        return sum1;
    }

    @Test
    public void tt() {
        ToIntFunction<TreeNode> func = this::rob;
        {
            TreeNode root = new TreeNode(3
                    , new TreeNode(2, null, new TreeNode(3))
                    , new TreeNode(3, null, new TreeNode(1)));
            Assertions.assertEquals(7, func.applyAsInt(root));
        }
        {
            TreeNode root = new TreeNode(3
                    , new TreeNode(4, new TreeNode(1), new TreeNode(3))
                    , new TreeNode(5, null, new TreeNode(1)));
            Assertions.assertEquals(9, func.applyAsInt(root));
        }
    }
}
