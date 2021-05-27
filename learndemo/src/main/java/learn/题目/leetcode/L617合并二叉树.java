package learn.题目.leetcode;

import learn.题目.剑指offer.TreeNode;
import org.junit.Test;

import java.util.List;
import java.util.function.BiFunction;

/**
 * @author DongYunxiang
 * @create 2021-05-27
 **/
public class L617合并二叉树 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return null;
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
