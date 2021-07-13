package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.TreeNode;
import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2021-03-09
 **/
public class L110平衡二叉树 {

    //从上至下判断
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //从下至上判断
    public boolean isBalanced1(TreeNode root) {
        return hight(root) >= 0;
    }

    //如果平衡返回高度, 如果不平衡返回-1
    private int hight(TreeNode root) {
        if (root == null)
            return 0;
        int l = hight(root.left);
        int r = hight(root.right);
        if (l == -1 || r == -1)
            return -1;
        if (Math.abs(l - r) > 1)
            return -1;
        return 1 + Math.max(l, r);
    }

    @Test
    public void tt() {
        {
            TreeNode root = new TreeNode(3
                    , new TreeNode(9)
                    , new TreeNode(29, new TreeNode(15), new TreeNode(7)));
            TestCase.assertTrue(isBalanced1(root));
        }
        {
            TreeNode root = new TreeNode(1
                    , new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3))
                    , new TreeNode(2));
            TestCase.assertFalse(isBalanced1(root));
        }
        {
            TestCase.assertTrue(isBalanced1(null));
        }
    }
}


