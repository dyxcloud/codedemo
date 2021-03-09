package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.TreeNode;
import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class L111二叉树的最小深度 {

    //深度优先 递归法
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        if (root.left == null)
            return 1 + minDepth(root.right);
        if (root.right == null)
            return 1 + minDepth(root.left);
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    //TODO 深度优先中序 迭代法
    public int minDepth1(TreeNode root) {
        if (root == null)
            return 0;
        int min = 100000;
        int currentFloor = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode first = stack.removeFirst();
            if (first != null) {
                currentFloor++;
                if (first.left == null && first.right == null) {
                    min = Math.min(min, currentFloor);
                    currentFloor--;
                    continue;
                }
                stack.addFirst(first.right);
                stack.addFirst(first.left);
            } else {

            }
        }
        return min;
    }

    //TODO 广度优先

    interface Func {
        int minDepth(TreeNode root);
    }

    @Test
    public void tt() {
        Func f = this::minDepth1;
        {
            TreeNode root = new TreeNode(3
                    , new TreeNode(9)
                    , new TreeNode(20, new TreeNode(15), new TreeNode(7)));
            TestCase.assertEquals(2, f.minDepth(root));
        }
        {
            TreeNode root = new TreeNode(2
                    , null, new TreeNode(3
                    , null, new TreeNode(4
                    , null, new TreeNode(5
                    , null, new TreeNode(6)))));
            TestCase.assertEquals(5, f.minDepth(root));
        }
        {
            TreeNode root = new TreeNode(1
                    , new TreeNode(2, new TreeNode(4), new TreeNode(5))
                    , new TreeNode(3));
            TestCase.assertEquals(2, f.minDepth(root));
        }
        {
            TestCase.assertEquals(0, f.minDepth(null));
        }
        {
            TreeNode root = new TreeNode(1);
            TestCase.assertEquals(1, f.minDepth(root));
        }
    }

}
