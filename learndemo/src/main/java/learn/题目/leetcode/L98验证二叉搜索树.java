package learn.题目.leetcode;

import learn.题目.剑指offer.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NonAsciiCharacters")
public class L98验证二叉搜索树 {

    /**
     * dfs递归获取极值验证
     */
    public boolean isValidBST0(TreeNode root) {
        return checkAndGetLR(root) != null;
    }

    /**
     * 如果不是bst返回null, 否则返回中序第一位和最后一位
     */
    private int[] checkAndGetLR(TreeNode node) {
        int[] result = null;
        int l, r;
        if (node.left != null) {
            if (node.left.val >= node.val)
                return null;
            int[] lr = checkAndGetLR(node.left);
            if (lr == null || lr[1] >= node.val) return null;
            result = lr;
            l = lr[0];
        } else {
            l = node.val;
        }
        if (node.right != null) {
            if (node.right.val <= node.val)
                return null;
            int[] lr = checkAndGetLR(node.right);
            if (lr == null || lr[0] <= node.val) return null;
            result = lr;
            r = lr[1];
        } else {
            r = node.val;
        }
        if (result == null) result = new int[2];
        result[0] = l;
        result[1] = r;
        return result;
    }

    /**
     * 递归验证上下限
     */
    public boolean isValidBST1(TreeNode root) {
        return checkRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkRange(TreeNode node, long low, long high) {
        if (node == null) return true;
        if (node.val <= low || node.val >= high) {
            return false;
        }
        if (!checkRange(node.left, low, node.val)) return false;
        if (!checkRange(node.right, node.val, high)) return false;
        return true;
    }


    /**
     * 中序遍历,验证是否升序
     */
    long val = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val > val) {
            val = root.val;
        } else {
            return false;
        }
        if (!isValidBST(root.right)) return false;
        return true;
    }

    @Test
    public void tt() {
        Predicate<TreeNode> func = this::isValidBST;
        {
            TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
            assertTrue(func.test(root));
        }
        {
            TreeNode root = new TreeNode(2, new TreeNode(2), new TreeNode(2));
            assertFalse(func.test(root));
        }
        {
            TreeNode root = new TreeNode(5
                    , new TreeNode(1)
                    , new TreeNode(4, new TreeNode(3), new TreeNode(6)));
            assertFalse(func.test(root));
        }
        {
            TreeNode root = new TreeNode(5
                    , new TreeNode(4)
                    , new TreeNode(6, new TreeNode(3), new TreeNode(7)));
            assertFalse(func.test(root));
        }
    }
}

