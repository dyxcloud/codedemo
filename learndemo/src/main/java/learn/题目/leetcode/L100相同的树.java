package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import learn.题目.剑指offer.TreeNode;
import org.junit.jupiter.api.Test;

public class L100相同的树 {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean a = p == null;
        boolean b = q == null;
        if (a & b) return true;
        if (a ^ b) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    @Test
    public void tt() {
        {
            TreeNode p = new TreeNode(1);
            p.left = new TreeNode(2);
            p.right = new TreeNode(3);
            TreeNode q = new TreeNode(1);
            q.left = new TreeNode(2);
            q.right = new TreeNode(3);
            Assertions.assertTrue(isSameTree(p, q));
        }
        {
            TreeNode p = new TreeNode(1);
            p.left = new TreeNode(2);
            TreeNode q = new TreeNode(1);
            q.right = new TreeNode(2);
            Assertions.assertFalse(isSameTree(p, q));
        }
        {
            TreeNode p = new TreeNode(1);
            p.left = new TreeNode(2);
            p.right = new TreeNode(1);
            TreeNode q = new TreeNode(1);
            q.left = new TreeNode(1);
            q.right = new TreeNode(2);
            Assertions.assertFalse(isSameTree(p, q));
        }
    }
}
