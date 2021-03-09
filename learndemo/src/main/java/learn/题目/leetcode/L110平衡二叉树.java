package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.TreeNode;
import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2021-03-09
 **/
public class L110平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    @Test
    public void tt() {
        {
            TreeNode root = new TreeNode(3
                    , new TreeNode(9)
                    , new TreeNode(29, new TreeNode(15), new TreeNode(7)));
            TestCase.assertTrue(isBalanced(root));
        }
        {
            TreeNode root = new TreeNode(1
                    , new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3))
                    , new TreeNode(2));
            TestCase.assertFalse(isBalanced(root));
        }
        {
            TestCase.assertTrue(isBalanced(null));
        }
    }
}


