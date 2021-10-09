package learn.题目.leetcode;

import learn.题目.剑指offer.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

@SuppressWarnings("NonAsciiCharacters")
public class L236二叉树的最近公共祖先 {
    interface Func {
        TreeNode apply(TreeNode root, TreeNode p, TreeNode q);
    }

    /**
     * 双端队列记录纵向路径, 寻找队列共同元素
     * 不能直接记录前序遍历路径, 因为不能区分前序节点是否是父节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> pQueue = new ArrayDeque<>();
        Deque<TreeNode> qQueue = new ArrayDeque<>();
        trace(root, p, pQueue);
        trace(root, q, qQueue);
        TreeNode result = null;
        while (qQueue.peekFirst() != null
                && pQueue.peekFirst() != null
                && qQueue.peekFirst() == pQueue.peekFirst()) {
            result = qQueue.pollFirst();
            pQueue.pollFirst();
        }
        return result;
    }

    public boolean trace(TreeNode root, TreeNode target, Deque<TreeNode> trace) {
        if (root == null) return false;
        if (root == target) {
            trace.push(root);
            return true;
        }
        boolean tl = trace(root.left, target, trace);
        boolean tr = trace(root.right, target, trace);
        boolean find = tl || tr;
        if (find) trace.push(root);
        return find;
    }

    @Test
    public void tt() {
        Func func = this::lowestCommonAncestor;
        {
            TreeNode p = new TreeNode(5,
                    new TreeNode(6)
                    , new TreeNode(2, new TreeNode(7), new TreeNode(4)));
            TreeNode q = new TreeNode(1, new TreeNode(0), new TreeNode(8));
            TreeNode root = new TreeNode(3, p, q);
            Assertions.assertEquals(root, func.apply(root, p, q));
        }
        {
            TreeNode q = new TreeNode(4);
            TreeNode p = new TreeNode(5,
                    new TreeNode(6)
                    , new TreeNode(2, new TreeNode(7), q));
            TreeNode root = new TreeNode(3, p, new TreeNode(1, new TreeNode(0), new TreeNode(8)));
            Assertions.assertEquals(p, func.apply(root, p, q));
        }
        {
            TreeNode q = new TreeNode(2);
            TreeNode p = new TreeNode(1, q, null);
            Assertions.assertEquals(p, func.apply(p, p, q));
        }
    }
}
