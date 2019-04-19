package dotest.dataDeal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的遍历,深度优先/广度优先
 * @author DongYunxiang
 * @create 2018-12-05
 **/
public class TreeSearch {

    /**
     *    A
     *  B   C
     * D E F G
     */

    public static void main(String[] args) {
        TreeSearch ts = new TreeSearch();
        BinaryTreeNode root = ts.initTree();

        System.out.println("\n深度优先, 先序");
        ts.printDFS1(root);
        System.out.println("\n深度优先, 中序");
        ts.printDFS2(root);
        System.out.println("\n深度优先, 后序");
        ts.printDFS3(root);

        System.out.println("\n广度优先");
        ts.printBFS(new LinkedList<>(),root);
    }



    private BinaryTreeNode initTree(){
        BinaryTreeNode d = new BinaryTreeNode('D');
        BinaryTreeNode e = new BinaryTreeNode('E');
        BinaryTreeNode f = new BinaryTreeNode('F');
        BinaryTreeNode g = new BinaryTreeNode('G');
        BinaryTreeNode b = new BinaryTreeNode('B', d, e);
        BinaryTreeNode c = new BinaryTreeNode('C', f, g);
        return  new BinaryTreeNode('A', b, c);
    }

    private void printDFS1(BinaryTreeNode node){
        System.out.print(node.data);
        if(node.leftNode!=null) printDFS1(node.leftNode);
        if(node.rightNode!=null) printDFS1(node.rightNode);
    }

    private void printDFS2(BinaryTreeNode node){
        if(node.leftNode!=null) printDFS2(node.leftNode);
        System.out.print(node.data);
        if(node.rightNode!=null) printDFS2(node.rightNode);
    }

    private void printDFS3(BinaryTreeNode node) {
        if(node.leftNode!=null) printDFS3(node.leftNode);
        if(node.rightNode!=null) printDFS3(node.rightNode);
        System.out.print(node.data);
    }

    /**
     * 使用队列的先进先出特性
     * a 添加a
     * bc 弹出a,添加bc
     * cde 弹出b,添加de
     * defg 弹出c,添加fg
     * 依次弹出
     * @param node
     */
    private void printBFS(Queue<BinaryTreeNode> queue, BinaryTreeNode node){
        System.out.print(node.data);
        if(node.leftNode!=null) queue.offer(node.leftNode);
        if(node.rightNode!=null) queue.offer(node.rightNode);
        BinaryTreeNode next = queue.poll();
        if(next!=null) printBFS(queue,next);
    }

    class BinaryTreeNode {
        char data;
        BinaryTreeNode leftNode = null, rightNode = null;

        BinaryTreeNode(char data) {
            this.data = data;
        }

        BinaryTreeNode(char data, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }
}
