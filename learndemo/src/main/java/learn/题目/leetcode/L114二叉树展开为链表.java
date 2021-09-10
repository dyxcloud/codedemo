package learn.题目.leetcode;

import learn.题目.剑指offer.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

@SuppressWarnings("NonAsciiCharacters")
public class L114二叉树展开为链表 {

/*
 1
2 3

1
 2
  3
 */

    public void flatten(TreeNode root) {
        if (root == null) return;
        helper(root);
    }

    /**
     * 返回前序last元素
     */
    private TreeNode helper(TreeNode root) {
        TreeNode l = root.left;
        TreeNode r = root.right;
        TreeNode last = root;
        if (l != null) {
            TreeNode lEnd = helper(l);
            root.left = null;
            root.right = l;
            lEnd.right = r;
            last = lEnd;
        }
        if (r != null) {
            last = helper(r);
        }
        return last;
    }

    @Test
    public void tt() {
        Consumer<TreeNode> func = this::flatten;
        {
            TreeNode root = new TreeNode(1
                    , new TreeNode(2, new TreeNode(3), new TreeNode(4))
                    , new TreeNode(5, null, new TreeNode(6)));
            TreeNode test = new TreeNode(1, null
                    , new TreeNode(2, null
                    , new TreeNode(3, null
                    , new TreeNode(4, null
                    , new TreeNode(5, null
                    , new TreeNode(6, null, null))))));
            func.accept(root);
            Assertions.assertEquals(test, root);
        }
        {
            TreeNode root = new TreeNode(1
                    , new TreeNode(2)
                    , null);
            TreeNode test = new TreeNode(1, null
                    , new TreeNode(2));
            func.accept(root);
            Assertions.assertEquals(test, root);
        }
        {
            TreeNode root = null;
            TreeNode test = null;
            func.accept(root);
            Assertions.assertEquals(test, root);
        }
        {
            TreeNode root = new TreeNode(0);
            TreeNode test = new TreeNode(0);
            func.accept(root);
            Assertions.assertEquals(test, root);
        }
    }
}
