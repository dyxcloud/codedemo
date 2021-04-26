package learn.题目.leetcode;

import learn.题目.剑指offer.TreeNode;
import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2021-04-26
 **/
public class L897递增顺序搜索树 {

    //二叉树线索化
    TreeNode pre;
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) return null;
        TreeNode head = increasingBST(root.left);

        if (root.left == null) {
            head = root;
        }
        if (pre != null) {
            pre.right = root;
            pre.left = null;
        }
        pre = root;

        TreeNode r = increasingBST(root.right);
        if (r == null) {
            root.left = null;
        }
        return head;
    }

    @Test
    public void tt() {

    }
}
