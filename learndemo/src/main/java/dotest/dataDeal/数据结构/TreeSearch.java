package dotest.dataDeal.数据结构;

import junit.framework.TestCase;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

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
    private static Node<Character> initTree3() {
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

    private static Node<Character> initTree2(){
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
        System.out.print(node.data);
        if (node.getLeft() != null) dfsPreOrder1(node.getLeft());
        if (node.getRight() != null) dfsPreOrder1(node.getRight());
    }

    //迭代遍历二叉树
    public static void dfsPreOrder2(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.removeFirst();
            System.out.print(node.data);
            Optional.ofNullable(node.getRight()).ifPresent(stack::addFirst);
            Optional.ofNullable(node.getLeft()).ifPresent(stack::addFirst);
        }
    }

    public static void dfsPreOrder3(Node root){
        Deque<Node> stack = new ArrayDeque<>();
        Node node = root;
        while(!stack.isEmpty()||node!=null){
            while(node!=null){
                System.out.print(node.data);
                stack.addFirst(node);//已打印的放进stack
                node = node.getLeft();
            }
            if(!stack.isEmpty()){
                node = stack.removeFirst();//拿出此节点的右节点
                node = node.getRight();
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
        if (node.getLeft() != null) dfsInOrder1(node.getLeft());
        System.out.print(node.data);
        if (node.getRight() != null) dfsInOrder1(node.getRight());
    }

    public static void dfsInOrder2(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        Node node = root;
        while(!stack.isEmpty()||node!=null){
            while(node!=null){
                stack.addFirst(node);//依次压栈到树的最左端
                node = node.getLeft();
            }
            if(!stack.isEmpty()){
                node = stack.removeFirst();
                System.out.print(node.data);
                node = node.getRight();
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
        if (node.getLeft() != null) dfsPostOrder1(node.getLeft());
        if (node.getRight() != null) dfsPostOrder1(node.getRight());
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
    public static void bfs(Deque<Node> deque) {
        while(!deque.isEmpty()){
            Node node = deque.removeFirst();
            System.out.print(node.data);
            Optional.ofNullable(node.getLeft()).ifPresent(deque::addLast);
            Optional.ofNullable(node.getRight()).ifPresent(deque::addLast);
        }
    }

    @Test
    public void testBfs() {
        System.out.println("\n广度优先");
        Deque<Node> objectss = new ArrayDeque<>();
        objectss.push(root);
        log.clearLog();
        bfs(objectss);
        TestCase.assertEquals("ABCDEFG", log.getLog());
    }
}
