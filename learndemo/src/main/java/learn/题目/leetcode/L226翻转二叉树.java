package learn.题目.leetcode;

import learn.题目.剑指offer.TreeNode;

/**
 * @author DongYunxiang
 * @create 2021-04-26
 **/
public class L226翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode l = root.left;
        root.left = root.right;
        root.right = l;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


}
