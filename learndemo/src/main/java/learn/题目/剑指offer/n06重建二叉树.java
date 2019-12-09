package learn.题目.剑指offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author DongYunxiang
 * @create 2019-12-09
 **/
@SuppressWarnings("NonAsciiCharacters")
public class n06重建二叉树 {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) return null;
        TreeNode root = new TreeNode(pre[0]);
        int inP=-1;
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                inP = i;
                break;
            }
        }
        int[] lIn = new int[inP];
        System.arraycopy(in,0,lIn,0,lIn.length);
        int[] lPre = new int[inP];
        System.arraycopy(pre,1,lPre,0,lPre.length);
        int[] rIn = new int[in.length-inP-1];
        System.arraycopy(in,inP+1,rIn,0,rIn.length);
        int[] rPre = new int[in.length-inP-1];
        System.arraycopy(pre,lPre.length+1,rPre,0,rPre.length);
        root.left = reConstructBinaryTree(lPre,lIn);
        root.right = reConstructBinaryTree(rPre,rIn);
        return root;
    }

    @Test
    public void test(){
        {
            int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
            int[] in =  new int[]{4, 7, 2, 1, 5, 3, 8, 6};
            TreeNode result = reConstructBinaryTree(pre,in);
            Assert.assertTrue(Arrays.equals(dfsPreOrder(result).stream().mapToInt(Integer::intValue).toArray(),pre));
            Assert.assertTrue(Arrays.equals(dfsInOrder(result).stream().mapToInt(Integer::intValue).toArray(),in));
        }
        {
            int[] pre = new int[]{1,2,3};
            int[] in =  new int[]{2,1,3};
            TreeNode result = reConstructBinaryTree(pre,in);
            Assert.assertTrue(Arrays.equals(dfsPreOrder(result).stream().mapToInt(Integer::intValue).toArray(),pre));
            Assert.assertTrue(Arrays.equals(dfsInOrder(result).stream().mapToInt(Integer::intValue).toArray(),in));
        }
        {
            int[] pre = new int[]{1,2,4,5,3,6,7};
            int[] in =  new int[]{4,2,5,1,6,3,7};
            TreeNode result = reConstructBinaryTree(pre,in);
            Assert.assertTrue(Arrays.equals(dfsPreOrder(result).stream().mapToInt(Integer::intValue).toArray(),pre));
            Assert.assertTrue(Arrays.equals(dfsInOrder(result).stream().mapToInt(Integer::intValue).toArray(),in));
        }
        {
            int[] pre = new int[]{1,2,4};
            int[] in =  new int[]{4,2,1};
            TreeNode result = reConstructBinaryTree(pre,in);
            Assert.assertTrue(Arrays.equals(dfsPreOrder(result).stream().mapToInt(Integer::intValue).toArray(),pre));
            Assert.assertTrue(Arrays.equals(dfsInOrder(result).stream().mapToInt(Integer::intValue).toArray(),in));
        }
        {
            int[] pre = new int[]{1,3,7};
            int[] in =  new int[]{1,3,7};
            TreeNode result = reConstructBinaryTree(pre,in);
            Assert.assertTrue(Arrays.equals(dfsPreOrder(result).stream().mapToInt(Integer::intValue).toArray(),pre));
            Assert.assertTrue(Arrays.equals(dfsInOrder(result).stream().mapToInt(Integer::intValue).toArray(),in));
        }
        {
            int[] pre = new int[]{1};
            int[] in =  new int[]{1};
            TreeNode result = reConstructBinaryTree(pre,in);
            Assert.assertTrue(Arrays.equals(dfsPreOrder(result).stream().mapToInt(Integer::intValue).toArray(),pre));
            Assert.assertTrue(Arrays.equals(dfsInOrder(result).stream().mapToInt(Integer::intValue).toArray(),in));
        }
        //root=null
        {
            int[] pre = new int[]{};
            int[] in =  new int[]{};
            TreeNode result = reConstructBinaryTree(pre,in);
            Assert.assertTrue(Arrays.equals(dfsPreOrder(result).stream().mapToInt(Integer::intValue).toArray(),pre));
            Assert.assertTrue(Arrays.equals(dfsInOrder(result).stream().mapToInt(Integer::intValue).toArray(),in));
        }
    }


    public List<Integer> dfsPreOrder(TreeNode node){
        LinkedList<Integer> result = new LinkedList<>();
        if(node==null) return result;
        result.add(node.val);
        result.addAll(dfsPreOrder(node.left));
        result.addAll(dfsPreOrder(node.right));
        return result;
    }

    public List<Integer> dfsInOrder(TreeNode node){
        LinkedList<Integer> result = new LinkedList<>();
        if(node==null) return result;
        result.addAll(dfsInOrder(node.left));
        result.add(node.val);
        result.addAll(dfsInOrder(node.right));
        return result;
    }

}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }