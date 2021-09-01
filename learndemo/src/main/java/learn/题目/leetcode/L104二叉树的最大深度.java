package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import learn.题目.剑指offer.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author DongYunxiang
 * @create 2021-03-08
 **/
public class L104二叉树的最大深度 {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepth1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int floor = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
                size--;
            }
            floor++;
        }
        return floor;
    }

    @Test
    public void tt() {
        {
            TreeNode root = new TreeNode(3
                    , new TreeNode(9)
                    , new TreeNode(20, new TreeNode(15), new TreeNode(7)));
            Assertions.assertEquals(3, maxDepth1(root));
        }
    }
}
