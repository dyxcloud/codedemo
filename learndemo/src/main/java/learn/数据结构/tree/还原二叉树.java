package learn.数据结构.tree;

import org.junit.Test;

@SuppressWarnings({"NonAsciiCharacters"})
public class 还原二叉树 {

    /*
     * A
     * B   C
     * D E F G
     * 前序:ABDECFG
     * 中序:DBEAFCG
     * 后序:DEBFGCA
     */

    @Test
    public void testRecovery() {
        {
            char[] preArr = {'A', 'B', 'D', 'E', 'C', 'F', 'G'};
            char[] inArr = {'D', 'B', 'E', 'A', 'F', 'C', 'G'};
            Node<Character> node = recoveryTreeByPreAndIn(preArr, inArr);
            TreeSearch.printATree(node);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        {
            char[] preArr = {'A', 'B', 'C',};
            char[] inArr = {'B', 'A', 'C',};
            Node<Character> node = recoveryTreeByPreAndIn(preArr, inArr);
            TreeSearch.printATree(node);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        {
            char[] preArr = {'A', 'B', 'D', 'E', 'C'};
            char[] inArr = {'D', 'B', 'E', 'A', 'C'};
            Node<Character> node = recoveryTreeByPreAndIn(preArr, inArr);
            TreeSearch.printATree(node);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        {
            char[] preArr = {'A', 'B'};
            char[] inArr = {'B', 'A'};
            Node<Character> node = recoveryTreeByPreAndIn(preArr, inArr);
            TreeSearch.printATree(node);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
        {
            char[] preArr = {'A', 'B', 'D', 'E', 'C', 'F', 'G'};
            char[] inArr = {'D', 'B', 'E', 'A', 'F', 'C', 'G'};
            Node<Character> node = recoveryTreeByPreAndIn(preArr, inArr);
            TreeSearch.printATree(node);
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        }
    }

    public Node<Character> recoveryTreeByPreAndIn(char[] preArr, char[] inArr) {
        // System.out.println(Arrays.toString(preArr) + "\t<pre in>\t" + Arrays.toString(inArr));
        if (preArr == null || preArr.length == 0) {
            return null;
        }
        if (preArr.length != inArr.length) {
            throw new RuntimeException("wrong arr length");
        }
        char root = preArr[0];
        Node<Character> rootNode = new Node<>(root);
        if (preArr.length == 1) {
            return rootNode;
        }
        //找出在中序的index 获取两个子中序数组
        int inSepIndex = findIndex(inArr, root);
        char[] inLArr = new char[inSepIndex];
        char[] inRArr = new char[inArr.length - inSepIndex - 1];
        System.arraycopy(inArr, 0, inLArr, 0, inLArr.length);
        System.arraycopy(inArr, inSepIndex + 1, inRArr, 0, inRArr.length);
        //后中序数组的第一位就是前序子数组的第一位
        char[] preLArr = new char[inLArr.length];
        char[] preRArr = new char[inRArr.length];
        System.arraycopy(preArr, 1, preLArr, 0, preLArr.length);
        System.arraycopy(preArr, 1 + preLArr.length, preRArr, 0, preRArr.length);
        //递归处理左右子数组,并赋值到根数组
        rootNode.setLeft(recoveryTreeByPreAndIn(preLArr, inLArr));
        rootNode.setRight(recoveryTreeByPreAndIn(preRArr, inRArr));
        return rootNode;
    }

    private int findIndex(char[] arr, char target) {
        int rootIndexIn = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                rootIndexIn = i;
                break;
            }
        }
        return rootIndexIn;
    }


}
