package learn.题目.leetcode;

import learn.题目.剑指offer.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

@SuppressWarnings("NonAsciiCharacters")
public class L105从前序与中序遍历序列构造二叉树 {

/*
 1
2 3

123
213

3, 9, 20, 15, 7
9, 3, 15, 20, 7
 */

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr || il > ir) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        //找中序分界
        int i = il;
        while (i <= ir && inorder[i] != preorder[pl]) {
            i++;
        }
        //找前序分界
        int lengthL = i - il;//左支个数
        root.left = build(preorder, inorder, pl + 1, pl + lengthL, il, i - 1);
        root.right = build(preorder, inorder, pl + lengthL + 1, pr, i + 1, ir);
        return root;
    }

    @Test
    public void tt() {
        BiFunction<int[], int[], TreeNode> func = this::buildTree;
        {
            TreeNode test = new TreeNode(3
                    , new TreeNode(9)
                    , new TreeNode(20, new TreeNode(15), new TreeNode(7)));
            Assertions.assertEquals(test
                    , func.apply(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
        }
        {
            TreeNode test = new TreeNode(-1);
            Assertions.assertEquals(test, func.apply(new int[]{-1}, new int[]{-1}));
        }
    }
}
