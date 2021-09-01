package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import learn.题目.剑指offer.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

public class L101对称二叉树 {

    //递归
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return isReverse(root.left, root.right);
    }

    private boolean isReverse(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        if (l.val != r.val) {
            return false;
        }
        return isReverse(l.left, r.right) && isReverse(l.right, r.left);
    }

    //迭代
    public boolean isSymmetric1(TreeNode root) {
        Queue<TreeNode> ql = new LinkedList<>(Collections.singletonList(root.left));
        Queue<TreeNode> qr = new LinkedList<>(Collections.singletonList(root.right));
        while (!ql.isEmpty() && !qr.isEmpty()) {
            TreeNode pl = ql.poll();
            TreeNode pr = qr.poll();
            if (pl == null && pr == null) {
                continue;
            }
            if (pl == null || pr == null) {
                return false;
            }
            if (pl.val != pr.val) {
                return false;
            }
            ql.offer(pl.left);
            ql.offer(pl.right);
            qr.offer(pr.right);
            qr.offer(pr.left);
        }
        return ql.isEmpty() && qr.isEmpty();
    }

    //迭代 一个队列
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root.left, root.right));
        while (!q.isEmpty()) {
            TreeNode pl = q.poll();
            TreeNode pr = q.poll();
            if (pl == null && pr == null) {
                continue;
            }
            if (pl == null || pr == null) {
                return false;
            }
            if (pl.val != pr.val) {
                return false;
            }
            q.offer(pl.left);
            q.offer(pr.right);
            q.offer(pl.right);
            q.offer(pr.left);
        }
        return true;
    }

    interface Func {
        boolean isSymmetric(TreeNode root);
    }

    @Test
    public void ttt() {
        Func f = this::isSymmetric2;
        {
            TreeNode root = new TreeNode(1
                    , new TreeNode(2, new TreeNode(3), new TreeNode(4))
                    , new TreeNode(2, new TreeNode(4), new TreeNode(3)));
            Assertions.assertTrue(f.isSymmetric(root));
        }
        {
            TreeNode root = new TreeNode(1
                    , new TreeNode(2, null, new TreeNode(3))
                    , new TreeNode(2, null, new TreeNode(3)));
            Assertions.assertFalse(f.isSymmetric(root));
        }
        {
            TreeNode root = new TreeNode(9
                    , new TreeNode(-42, null, new TreeNode(76, null, new TreeNode(13)))
                    , new TreeNode(-42, new TreeNode(76, null, new TreeNode(13)), null));
            Assertions.assertFalse(f.isSymmetric(root));
        }
    }
}
