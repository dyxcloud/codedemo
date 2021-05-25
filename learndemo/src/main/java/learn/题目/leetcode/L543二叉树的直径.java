package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

/**
 * @author DongYunxiang
 * @create 2021-05-14
 **/
public class L543二叉树的直径 {

    static class Solution1 {

        int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) {
                return 0;
            }
            max = Math.max(length(root), max);
            diameterOfBinaryTree(root.left);
            diameterOfBinaryTree(root.right);
            return max;
        }

        //经过根节点的直径
        public int length(TreeNode node) {
            int l = maxDepth(node.left);
            int r = maxDepth(node.right);
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

    @Test
    public void ttt() {
        ToIntFunction<TreeNode> f = new Solution1()::diameterOfBinaryTree;
        {
            TreeNode root = new TreeNode(2
                    , new TreeNode(3, new TreeNode(4), null)
                    , null);
            TestCase.assertEquals(2, f.applyAsInt(root));
        }
        {
            TreeNode root = new TreeNode(1
                    , new TreeNode(2, new TreeNode(4), new TreeNode(5))
                    , new TreeNode(3));
            TestCase.assertEquals(3, f.applyAsInt(root));
        }
    }
}
