package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import learn.题目.剑指offer.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;

public class L144二叉树的前序遍历 {

    //递归
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    //迭代
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            result.add(pop.val);
            Optional.ofNullable(pop.right).ifPresent(stack::push);
            Optional.ofNullable(pop.left).ifPresent(stack::push);
        }
        return result;
    }

    //迭代
    //循环左子数，将右子树放入栈中。左子树为空时，依次弹栈，从最下层开始访问右子树
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return result;
    }

    @Test
    public void tt() {
        Function<TreeNode, List<Integer>> f = this::preorderTraversal2;
        {
            TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
            Assertions.assertEquals(Arrays.asList(1, 2, 3), f.apply(root));
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
            Assertions.assertEquals(Arrays.asList(1, 2), f.apply(root));
        }
        {
            TreeNode root = new TreeNode(1, null, new TreeNode(2));
            Assertions.assertEquals(Arrays.asList(1, 2), f.apply(root));
        }
    }
}
