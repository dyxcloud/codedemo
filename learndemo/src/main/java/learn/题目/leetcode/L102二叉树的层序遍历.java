package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.TreeNode;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;

public class L102二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> subR = new ArrayList<>();
            int times = queue.size();
            while (times > 0) {
                TreeNode poll = queue.poll();
                subR.add(poll.val);
                Optional.ofNullable(poll.left).ifPresent(queue::offer);
                Optional.ofNullable(poll.right).ifPresent(queue::offer);
                times--;
            }
            result.add(subR);
        }
        return result;
    }

    @Test
    public void tt() {
        Function<TreeNode, List<List<Integer>>> f = this::levelOrder;
        {
            TreeNode root = new TreeNode(3
                    , new TreeNode(9)
                    , new TreeNode(20, new TreeNode(15), new TreeNode(7)));
            TestCase.assertEquals(Arrays.asList(Arrays.asList(3), Arrays.asList(9, 20), Arrays.asList(15, 7)), f.apply(root));
        }
    }
}
