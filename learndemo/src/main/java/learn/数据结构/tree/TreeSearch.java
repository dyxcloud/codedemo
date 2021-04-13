package learn.数据结构.tree;

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
    public static Node<Character> initTree3() {
        Node<Character> d = new Node<>('D');
        Node<Character> e = new Node<>('E');
        Node<Character> f = new Node<>('F');
        Node<Character> g = new Node<>('G');
        Node<Character> b = new Node<>('B', d, e);
        // Node<Character> b = new Node<>('B');
        // b.setLeft(d);
        Node<Character> c = new Node<>('C', f, g);
        return new Node<>('A', b, c);
    }

    public static Node<Character> initTree2() {
        Node<Character> b = new Node<>('B');
        Node<Character> c = new Node<>('C');
        return new Node<>('A', b, c);
    }

    private static Node<Character> root;

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @BeforeClass
    public static void init() {
        root = initTree3();
    }

    public static void dfsPreOrder1(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        dfsPreOrder1(node.left);
        dfsPreOrder1(node.right);
    }

    //迭代遍历二叉树
    //先后将右子树和左子放入栈中，利用栈后入先出的原理遍历。
    public static void dfsPreOrder2(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data);
            Optional.ofNullable(node.right).ifPresent(stack::push);
            Optional.ofNullable(node.left).ifPresent(stack::push);
        }
    }

    //循环左子数，将右子树放入栈中。左子树为空时，依次弹栈，从最下层开始访问右子树
    public static void dfsPreOrder3(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        Node node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                System.out.print(node.data);
                stack.push(node);//已打印的放进stack
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();//拿出此节点的右节点
                node = node.right;
            }
        }
    }

    @Test
    public void testPreOrder() {
        dfsPreOrder1(root);
        TestCase.assertEquals("ABDECFG", log.getLog());
        log.clearLog();
        dfsPreOrder2(root);
        TestCase.assertEquals("ABDECFG", log.getLog());
        log.clearLog();
        dfsPreOrder3(root);
        TestCase.assertEquals("ABDECFG", log.getLog());
    }

    //中序遍历的特性显示他遍历一个有序二叉树时总是升序
    public static void dfsInOrder1(Node node) {
        if (node == null) {
            return;
        }
        dfsInOrder1(node.left);
        System.out.print(node.data);
        dfsInOrder1(node.right);
    }

    public static void dfsInOrder2(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        Node node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);//依次压栈到树的最左端
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.data);
                node = node.right;
            }
        }
    }

    @Test
    public void testInOrder() {
        System.out.println("\n深度优先, 中序");
        log.clearLog();
        dfsInOrder1(root);
        TestCase.assertEquals("DBEAFCG", log.getLog());
        log.clearLog();
        dfsInOrder2(root);
        TestCase.assertEquals("DBEAFCG", log.getLog());
    }

    public static void dfsPostOrder1(Node node) {
        if (node == null) {
            return;
        }
        dfsPostOrder1(node.left);
        dfsPostOrder1(node.right);
        System.out.print(node.data);
    }

    public static void dfsPostOrder2(Node root) {
        // TODO
    }

    @Test
    public void testPostOrder() {
        System.out.println("\n深度优先, 后序");
        log.clearLog();
        dfsPostOrder1(root);
        TestCase.assertEquals("DEBFGCA", log.getLog());
        log.clearLog();
        dfsPostOrder2(root);
        TestCase.assertEquals("DEBFGCA", log.getLog());
    }

    /**
     * 使用队列的先进先出特性
     * a 添加a
     * bc 弹出a,添加bc
     * cde 弹出b,添加de
     * defg 弹出c,添加fg
     * 依次弹出
     */
    public static void bfs(Node root) {
        Queue<Node> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            Node node = deque.poll();
            System.out.print(node.data);
            Optional.ofNullable(node.left).ifPresent(deque::offer);
            Optional.ofNullable(node.right).ifPresent(deque::offer);
        }
    }

    @Test
    public void testBfs() {
        System.out.println("\n广度优先");
        log.clearLog();
        bfs(root);
        TestCase.assertEquals("ABCDEFG", log.getLog());
    }


    public static void printATree(Node<Character> node) {
        if (node == null) return;
        if (node.left != null) {
            System.out.println(node.data + " left= " + node.left.data);
        }
        if (node.right != null) {
            System.out.println(node.data + " right= " + node.right.data);
        }
        if (node.left != null) {
            printATree(node.left);
        }
        if (node.right != null) {
            printATree(node.right);
        }
    }

    @Test
    public void testprint() {
        Node<Character> node = initTree3();
        printATree(node);
    }
}
