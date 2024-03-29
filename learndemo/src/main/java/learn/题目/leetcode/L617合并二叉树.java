package learn.题目.leetcode;

import learn.题目.剑指offer.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BiFunction;

/**
 * @author DongYunxiang
 * @create 2021-05-27
 **/
public class L617合并二叉树 {

    public TreeNode mergeTrees0(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        int sum = 0;
        if (root1 != null) {
            sum += root1.val;
        }
        if (root2 != null) {
            sum += root2.val;
        }
        TreeNode root = new TreeNode(sum);
        root.left = mergeTrees0((root1 == null) ? null : root1.left, (root2 == null) ? null : root2.left);
        root.right = mergeTrees0((root1 == null) ? null : root1.right, (root2 == null) ? null : root2.right);
        return root;
    }

    //改进, 如果一个树=null, 就不需要合并了
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }

    @Test
    public void ttt() {
        BiFunction<TreeNode, TreeNode, TreeNode> f = this::mergeTrees;
        {
            TreeNode t1 = new TreeNode(1,
                    new TreeNode(3, new TreeNode(5), null)
                    , new TreeNode(2));
            TreeNode t2 = new TreeNode(2,
                    new TreeNode(1, null, new TreeNode(4))
                    , new TreeNode(3, null, new TreeNode(7)));
            L102二叉树的层序遍历 p = new L102二叉树的层序遍历();
            List<List<Integer>> lists = p.levelOrder(f.apply(t1, t2));
            System.out.println(lists);
        }
    }
}
