package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.ToIntFunction;

public class L111二叉树的最小深度 {

    //深度优先 递归法
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int deep = Integer.MAX_VALUE;
        if (root.right != null)
            deep = Math.min(deep, minDepth(root.right));
        if (root.left != null)
            deep = Math.min(deep, minDepth(root.left));
        return 1 + deep;
    }

    //广度优先
    //关联 L104二叉树的最大深度
    public int minDepthBfs(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int floor = 1;
        int currentCount = 1;
        int nextCount = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left == null && poll.right == null) {
                break;
            }
            if (poll.right != null) {
                queue.offer(poll.right);
                nextCount++;
            }
            if (poll.left != null) {
                queue.offer(poll.left);
                nextCount++;
            }
            currentCount--;
            if (currentCount == 0) {
                floor++;
                currentCount = nextCount;
                nextCount = 0;
            }
        }
        return floor;
    }

    @Test
    public void tt() {
        ToIntFunction<TreeNode> f = this::minDepthBfs;
        {
            TreeNode root = new TreeNode(3
                    , new TreeNode(9)
                    , new TreeNode(20, new TreeNode(15), new TreeNode(7)));
            TestCase.assertEquals(2, f.applyAsInt(root));
        }
        {
            TreeNode root = new TreeNode(2
                    , null, new TreeNode(3
                    , null, new TreeNode(4
                    , null, new TreeNode(5
                    , null, new TreeNode(6)))));
            TestCase.assertEquals(5, f.applyAsInt(root));
        }
        {
            TreeNode root = new TreeNode(1
                    , new TreeNode(2, new TreeNode(4), new TreeNode(5))
                    , new TreeNode(3));
            TestCase.assertEquals(2, f.applyAsInt(root));
        }
        {
            TestCase.assertEquals(0, f.applyAsInt(null));
        }
        {
            TreeNode root = new TreeNode(1);
            TestCase.assertEquals(1, f.applyAsInt(root));
        }
    }

}
