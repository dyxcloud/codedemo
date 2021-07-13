package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.TreeNode;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;

public class L145二叉树的后序遍历 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || root.right == pre) {
                result.add(root.val);
                stack.pop();
                pre = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return result;
    }

    @Test
    public void tt() {
        Function<TreeNode, List<Integer>> f = this::postorderTraversal1;
        {
            TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
            TestCase.assertEquals(Arrays.asList(3, 2, 1), f.apply(root));
        }
    }
}
