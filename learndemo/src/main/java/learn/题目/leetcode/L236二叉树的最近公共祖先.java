package learn.题目.leetcode;

import learn.题目.剑指offer.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class L236二叉树的最近公共祖先 {
    interface Func {
        TreeNode apply(TreeNode root, TreeNode p, TreeNode q);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return null;
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
