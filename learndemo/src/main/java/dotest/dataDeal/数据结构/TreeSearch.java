package dotest.dataDeal.数据结构;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
        Node root = initTree();

        System.out.println("\n深度优先, 先序");
        dfsPreOrder1(root);
        System.out.println();
        Stack<Node> nodes = new Stack<>();
        nodes.push(root);
        dfsPreOrder2(nodes);

        System.out.println("\n深度优先, 中序");
        dfsInOrder1(root);

        System.out.println("\n深度优先, 后序");
        dfsPostOrder1(root);

        System.out.println("\n广度优先");
        ArrayDeque<Node> objects = new ArrayDeque<>();
        objects.push(root);
        bfs1(objects);
    }



    public static Node initTree(){
        Node<Character> d = new Node<>('D');
        Node<Character> e = new Node<>('E');
        Node<Character> f = new Node<>('F');
        Node<Character> g = new Node<>('G');
        Node<Character> b = new Node<>('B', d, e);
        Node<Character> c = new Node<>('C', f, g);
        return  new Node<>('A', b, c);
    }

    public static void dfsPreOrder1(Node node){
        System.out.print(node.data);
        if(node.left!=null) dfsPreOrder1(node.left);
        if(node.right!=null) dfsPreOrder1(node.right);
    }

    public static void dfsPreOrder2(Stack<Node> stack){
        if(stack==null || stack.empty()) return;
        Node pop = stack.pop();
        System.out.print(pop.data);
        if(pop.right!=null) stack.push(pop.right);
        if(pop.left!=null) stack.push(pop.left);
        dfsPreOrder2(stack);
    }

    public static void dfsInOrder1(Node node){
        if(node.left!=null) dfsInOrder1(node.left);
        System.out.print(node.data);
        if(node.right!=null) dfsInOrder1(node.right);
    }

    public static void dfsInOrder2(Stack<Node> stack){
        //TODO loop
    }

    public static void dfsPostOrder1(Node node) {
        if(node.left!=null) dfsPostOrder1(node.left);
        if(node.right!=null) dfsPostOrder1(node.right);
        System.out.print(node.data);
    }

    public static void dfsPostOrder2(Stack<Node> stack){
        //TODO loop
    }

    /**
     * 使用队列的先进先出特性
     * a 添加a
     * bc 弹出a,添加bc
     * cde 弹出b,添加de
     * defg 弹出c,添加fg
     * 依次弹出
     */
    public static void bfs1(Queue<Node> queue){
        //TODO
        if(queue==null||queue.isEmpty()) return;
        Node node = queue.poll();
        System.out.print(node.data);
        if(node.left!=null) queue.offer(node.left);
        if(node.right!=null) queue.offer(node.right);
        Node next = queue.poll();
        if(next!=null) bfs1(queue);
    }

    public static void bfs2(Stack<Node> stack){
        //TODO loop
    }
    
}
