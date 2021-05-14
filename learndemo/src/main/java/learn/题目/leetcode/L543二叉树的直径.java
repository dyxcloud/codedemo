package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.TreeNode;
import org.junit.Test;

import java.util.function.ToIntFunction;

/**
 * @author DongYunxiang
 * @create 2021-05-14
 **/
public class L543二叉树的直径 {

    public int diameterOfBinaryTree(TreeNode root) {
        //TODO L543二叉树的直径
        return 0;
    }

    @Test
    public void ttt() {
        ToIntFunction<TreeNode> f = this::diameterOfBinaryTree;
        {
            TreeNode root = new TreeNode(1
                    , new TreeNode(2, new TreeNode(4), new TreeNode(5))
                    , new TreeNode(3));
            TestCase.assertEquals(3, f.applyAsInt(root));
        }
    }
}
