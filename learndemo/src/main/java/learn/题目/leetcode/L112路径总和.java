package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import learn.题目.剑指offer.TreeNode;
import org.junit.jupiter.api.Test;

public class L112路径总和 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        int target = targetSum - root.val;
        return hasPathSum(root.left, target) || hasPathSum(root.right, target);
    }

    interface Func {
        boolean hasPathSum(TreeNode root, int targetSum);
    }

    @Test
    public void tt() {
        Func f = this::hasPathSum;
        {
            TreeNode root = new TreeNode(5
                    , new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null)
                    , new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));
            Assertions.assertTrue(f.hasPathSum(root, 22));
        }
        {
            TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
            Assertions.assertFalse(f.hasPathSum(root, 5));
        }
        {
            TreeNode root = new TreeNode(1, new TreeNode(2), null);
            Assertions.assertFalse(f.hasPathSum(root, 0));
        }
        {
            TreeNode root = new TreeNode(1, new TreeNode(2), null);
            Assertions.assertFalse(f.hasPathSum(root, 1));
        }
        {
            Assertions.assertFalse(f.hasPathSum(null, 0));
        }
    }
}
