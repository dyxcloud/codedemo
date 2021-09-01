package learn.题目.leetcode;

import learn.题目.剑指offer.Of7重建二叉树;
import learn.题目.剑指offer.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author DongYunxiang
 * @create 2021-03-08
 **/
public class L108将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        if (l < r) {
            root.left = sortedArrayToBST(nums, l, mid - 1);
            root.right = sortedArrayToBST(nums, mid + 1, r);
        }
        return root;
    }

    @Test
    public void tt() {
        {
            TreeNode treeNode = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
            List<Integer> integers = Of7重建二叉树.dfsPreOrder(treeNode);
            System.out.println(integers);
        }
        {
            TreeNode treeNode = sortedArrayToBST(new int[]{1, 3});
            List<Integer> integers = Of7重建二叉树.dfsPreOrder(treeNode);
            System.out.println(integers);
        }
    }
}
