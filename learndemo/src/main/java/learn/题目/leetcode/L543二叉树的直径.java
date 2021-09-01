package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import learn.题目.剑指offer.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

/**
 * @author DongYunxiang
 * @create 2021-05-14
 **/
public class L543二叉树的直径 {

    //遍历树, 求出每一个node的直径
    static class Solution1 {

        int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) {
                return 0;
            }
            length(root);
            return max;
        }

        //经过根节点的直径
        public int length(TreeNode node) {
            if(node==null) return 0;
            int l = maxDepth(node.left);
            int r = maxDepth(node.right);
            max = Math.max(l+r, max);
            length(node.left);
            length(node.right);
            return l + r;
        }

        Map<TreeNode, Integer> maxDepthCache = new HashMap<>();

        //最大深度
        public int maxDepth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            Integer cache = maxDepthCache.get(node);
            if (cache != null) {
                return cache;
            }
            if (node.left == null && node.right == null) {
                return 1;
            }
            int result = 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
            maxDepthCache.putIfAbsent(node, result);
            return result;
        }
    }

    //优化, 计算深度的时候已经可以求出节点的直径
    static class Solution10 {

        int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            maxDepth(root);
            return max;
        }

        //最大深度
        public int maxDepth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            if (node.left == null && node.right == null) {
                return 1;
            }
            int l = maxDepth(node.left);
            int r = maxDepth(node.right);
            //同时求出这个node的直径
            max = Math.max(max, l + r);
            return 1 + Math.max(l, r);
        }
    }

    @Test
    public void ttt() {
        ToIntFunction<TreeNode> f = new Solution10()::diameterOfBinaryTree;
        {
            TreeNode root = new TreeNode(2
                    , new TreeNode(3, new TreeNode(4), null)
                    , null);
            Assertions.assertEquals(2, f.applyAsInt(root));
        }
        {
            TreeNode root = new TreeNode(1
                    , new TreeNode(2, new TreeNode(4), new TreeNode(5))
                    , new TreeNode(3));
            Assertions.assertEquals(3, f.applyAsInt(root));
        }
    }
}
