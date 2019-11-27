package dotest.dataDeal.数据结构;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;
import java.util.Queue;

/**
 * 树的遍历,深度优先/广度优先
 *
 * @author DongYunxiang
 * @create 2018-12-05
 **/
public class TreeSearch {

    /**
     * A
     * B   C
     * D E F G
     */
    private static Node<Character> initTree() {
        Node<Character> d = new Node<>('D');
        Node<Character> e = new Node<>('E');
        Node<Character> f = new Node<>('F');
        Node<Character> g = new Node<>('G');
        Node<Character> b = new Node<>('B', d, e);
        Node<Character> c = new Node<>('C', f, g);
        return new Node<>('A', b, c);
    }

    public static void dfsPreOrder1(Node node) {
        System.out.print(node.data);
        if (node.getLeft() != null) dfsPreOrder1(node.getLeft());
        if (node.getRight() != null) dfsPreOrder1(node.getRight());
    }

    //迭代遍历二叉树
    // 使用辅助变量记录node的遍历情况
    public static void dfsPreOrder2(Deque<Node> stack) {
        Node current;
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst();
            System.out.print(node.data);
            Optional.ofNullable(node.getRight()).ifPresent(stack::addFirst);
            Optional.ofNullable(node.getLeft()).ifPresent(stack::addFirst);
            // if (node.getRight() != null) stack.addFirst(node.getRight());
            // if (node.getLeft() != null) stack.addFirst(node.getLeft());
        }
    }

    public static void dfsPreOrder3(){
        //TODO 前序遍历二叉树 非递归实现
    }

    //中序遍历的特性显示他遍历一个有序二叉树时总是升序
    public static void dfsInOrder1(Node node) {
        if (node.getLeft() != null) dfsInOrder1(node.getLeft());
        System.out.print(node.data);
        if (node.getRight() != null) dfsInOrder1(node.getRight());
    }

    public static void dfsInOrder2(Deque<Node> stack) {
        Node current;
        while (!stack.isEmpty()) {
            current = stack.getFirst();
            if (current.state == 0) {
                if (current.getLeft() != null) stack.addFirst(current.getLeft());
            } else if (current.state == 1) {
                System.out.print(current.data);
            } else if (current.state == 2) {
                if (current.getRight() != null) stack.addFirst(current.getRight());
            } else if (current.state == 3) {
                stack.removeFirst();
            }
            current.state++;
        }
    }

    public static void dfsPostOrder1(Node node) {
        if (node.getLeft() != null) dfsPostOrder1(node.getLeft());
        if (node.getRight() != null) dfsPostOrder1(node.getRight());
        System.out.print(node.data);
    }

    public static void dfsPostOrder2(Deque<Node> stack) {
        Node current;
        while (!stack.isEmpty()) {
            current = stack.getFirst();
            if (current.state == 0) {
                if (current.getLeft() != null) stack.addFirst(current.getLeft());
            } else if (current.state == 1) {
                if (current.getRight() != null) stack.addFirst(current.getRight());
            } else if (current.state == 2) {
                System.out.print(current.data);
            } else if (current.state == 3) {
                stack.removeFirst();
            }
            current.state++;
        }
    }

    /**
     * 使用队列的先进先出特性
     * a 添加a
     * bc 弹出a,添加bc
     * cde 弹出b,添加de
     * defg 弹出c,添加fg
     * 依次弹出
     */
    public static void bfs1(Queue<Node> queue) {
        if (queue == null || queue.isEmpty()) return;
        Node node = queue.remove();
        System.out.print(node.data);
        if (node.getLeft() != null) queue.add(node.getLeft());
        if (node.getRight() != null) queue.add(node.getRight());
        bfs1(queue);
    }

    public static void bfs2(Deque<Node> stack) {
        //TODO loop
    }

    public static void printTree(Deque<Node> stack) {
        //TODO 打印二叉树 结构图
    }

    private static Node<Character> root;

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @BeforeClass
    public static void init() {
        root = initTree();
    }

    @Test
    public void testPreOrder() {
        dfsPreOrder1(root);
        TestCase.assertEquals("ABDECFG", log.getLog());

        Deque<Node> nodes = new ArrayDeque<>();
        nodes.push(root);
        log.clearLog();
        dfsPreOrder2(nodes);
        TestCase.assertEquals("ABDECFG", log.getLog());
    }

    @Test
    public void testInOrder() {
        System.out.println("\n深度优先, 中序");
        log.clearLog();
        dfsInOrder1(root);
        TestCase.assertEquals("DBEAFCG", log.getLog());

        Deque<Node> stack = new ArrayDeque<>();
        stack.addFirst(root);
        log.clearLog();
        dfsInOrder2(stack);
        TestCase.assertEquals("DBEAFCG", log.getLog());
    }

    @Test
    public void testPostOrder() {
        System.out.println("\n深度优先, 后序");
        log.clearLog();
        dfsPostOrder1(root);
        TestCase.assertEquals("DEBFGCA", log.getLog());

        Deque<Node> stack = new ArrayDeque<>();
        stack.addFirst(root);
        log.clearLog();
        dfsPostOrder2(stack);
        TestCase.assertEquals("DEBFGCA", log.getLog());
    }

    @Test
    public void testBfs() {
        System.out.println("\n广度优先");
        Deque<Node> objects = new ArrayDeque<>();
        objects.push(root);
        log.clearLog();
        bfs1(objects);
        TestCase.assertEquals("ABCDEFG", log.getLog());
    }
}
