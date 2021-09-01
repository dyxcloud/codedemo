package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import learn.题目.剑指offer.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;

public class L94二叉树的中序遍历 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    @Test
    public void tt() {
        Function<TreeNode, List<Integer>> f = this::inorderTraversal1;
        {
            TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
            Assertions.assertEquals(Arrays.asList(1, 3, 2), f.apply(root));
        }
        {
            Assertions.assertEquals(Arrays.asList(), f.apply(null));
        }
        {
            TreeNode root = new TreeNode(1);
            Assertions.assertEquals(Arrays.asList(1), f.apply(root));
        }
        {
            TreeNode root = new TreeNode(1, new TreeNode(2), null);
            Assertions.assertEquals(Arrays.asList(2, 1), f.apply(root));
        }
        {
            TreeNode root = new TreeNode(1, null, new TreeNode(2));
            Assertions.assertEquals(Arrays.asList(1, 2), f.apply(root));
        }
    }
}
