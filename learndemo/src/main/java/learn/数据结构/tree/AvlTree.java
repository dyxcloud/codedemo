package learn.数据结构.tree;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.Iterator;

/**
 * @author DongYunxiang
 * @create 2019-05-21
 **/
public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    private AvlNode<T> root;

    @Override
    public AvlNode<T> getRoot() {
        return root;
    }

    public void setRoot(AvlNode<T> root) {
        this.root = root;
    }

    @Override
    public void insert(T data) {
        if (data == null) throw new NullPointerException("insert data is null");
        if (getRoot() == null) {
            setRoot(new AvlNode<>(data));
        } else {
            insert(getRoot(), data);
        }
    }

    private void insert(AvlNode<T> node, T data) {
        if (node.data.compareTo(data) > 0) {
            if (node.left != null)
                insert(node.left, data);
            else {
                node.left = new AvlNode<>(data);
                node.left.parent = node;
            }
        } else {
            if (node.right != null)
                insert(node.right, data);
            else {
                node.right = new AvlNode<>(data);
                node.right.parent = node;
            }
        }
        takeBalance(node);
    }

    public void remove(AvlNode<T> n) {
        AvlNode<T> p = n.parent;
        AvlNode<T> next, child;
        // 叶子结点，直接删除即可。要考虑待删除结点是root的情况。
        if (n.left == null && n.right == null) {
            if (n == getRoot()) {
                setRoot(null);
            } else if (n == p.left) {
                p.left = null;
            } else if (n == p.right) {
                p.right = null;
            }
        }
        // 内部结点，把它的后继的值拷进来，然后递归删除它的后继。
        else if (n.left != null && n.right != null) {
            next = (AvlNode<T>) successorIn(n);
            n.data = next.data;
            remove(next);
        }
        // 只有一个孩子的结点，把它的孩子交给它的父结点即可。
        else {
            child = n.left != null ? n.left : n.right;
            if (n == getRoot()) {
                child.parent = null;
                setRoot(child);
            } else if (n == p.left) {
                child.parent = p;
                p.left = child;
            } else {
                child.parent = p;
                p.right = child;
            }
        }
        takeBalance(n);
    }

    private void takeBalance(AvlNode<T> node) {
        //平衡处理
        /* 从插入的过程回溯回来的时候，计算平衡因子 */
        node.balance = getBalance(node);
        /* 左子树高，应该右旋 */
        if (node.balance >= 2) {
            /* 右孙高，先左旋 */
            if (node.left.balance == -1)
                left_rotate(node.left);
            right_rotate(node);
        }
        if (node.balance <= -2) {
            if (node.right.balance == 1)
                right_rotate(node.right);
            left_rotate(node);
        }
        node.balance = getBalance(node);
        node.depth = getDepth(node);
    }

    /**
     * 右旋
     *
     * @param p 旋转前的根节点(父)
     */
    private void right_rotate(AvlNode<T> p) {
        AvlNode<T> pParent = p.parent;//祖父
        AvlNode<T> pLeftSon = p.left;//左子
        AvlNode<T> pRightGrandSon = pLeftSon.right;//右孙
        if (getRoot() == p) {
            setRoot(pLeftSon);
        }
        //祖父关系变换
        pLeftSon.parent = pParent;
        if (pParent != null) {
            if (p == pParent.left)
                pParent.left = pLeftSon;
            else if (p == pParent.right)
                pParent.right = pLeftSon;
        }
        //左子为父, 父变右子
        pLeftSon.right = p;
        p.parent = pLeftSon;
        /* 右孙变左孙 */
        p.left = pRightGrandSon;
        if (pRightGrandSon != null)
            pRightGrandSon.parent = p;
        /* 重新计算平衡因子 */
        p.depth = getDepth(p);
        p.balance = getBalance(p);
        pLeftSon.depth = getDepth(pLeftSon);
        pLeftSon.balance = getBalance(pLeftSon);
    }

    /**
     * 左旋
     */
    private void left_rotate(AvlNode<T> p) {
        //右子为父, 父变左子, 左孙变右孙
        AvlNode<T> pParent = p.parent;
        AvlNode<T> pRightSon = p.right;
        AvlNode<T> pLeftGrandSon = pRightSon.left;
        if (getRoot() == p) {
            setRoot(pRightSon);
        }
        //祖父
        pRightSon.parent = pParent;
        if (pParent != null) {
            if (pParent.left == p)
                pParent.left = pRightSon;
            else if (pParent.right == p)
                pParent.right = pRightSon;
        }
        //根节点
        pRightSon.left = p;
        p.parent = pRightSon;
        //孙节点
        if (pLeftGrandSon != null)
            pLeftGrandSon.parent = p;
        p.right = pLeftGrandSon;
        //重计算
        p.depth = getDepth(p);
        p.balance = getBalance(p);
        pRightSon.depth = getDepth(pRightSon);
        pRightSon.balance = getBalance(pRightSon);
    }

    /**
     * 计算平衡因子
     */
    private int getBalance(AvlNode<T> p) {
        int left_depth = p.left == null ? 0 : p.left.depth;
        int right_depth = p.right == null ? 0 : p.right.depth;
        return left_depth - right_depth;
    }

    /**
     * 计算深度
     */
    private int getDepth(AvlNode<T> p) {
        int depth = 0;
        if (p.left != null)
            depth = p.left.depth;
        if (p.right != null && depth < p.right.depth)
            depth = p.right.depth;
        depth++;
        return depth;
    }

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testInsert() {
        AvlTree<Integer> tree = new AvlTree<>();
        insert654321(tree);
        System.out.println(tree);
    }

    @Test
    public void testContains() {
        AvlTree<Integer> tree = new AvlTree<>();
        insert321546(tree);
        TestCase.assertTrue(tree.contains(6));
        TestCase.assertTrue(tree.contains(4));
        TestCase.assertTrue(tree.contains(2));
        TestCase.assertFalse(tree.contains(0));
        TestCase.assertFalse(tree.contains(10));
        TestCase.assertFalse(tree.contains(null));
    }

    @Test
    public void testIterator() {
        AvlTree<Integer> tree0 = new AvlTree<>();
        insert321546(tree0);
        log.clearLog();
        Iterator<Node<Integer>> iterator = tree0.iterator();
        while ((iterator.hasNext())) {
            System.out.print(iterator.next().data);
        }
        // for(Node<Integer> n: tree0){
        //     System.out.print(n.data);
        // }
        // tree0.forEach(n -> System.out.print(n.data));
        // TestCase.assertEquals("123456", log.getLog());
    }

}

class AvlNode<T extends Comparable<T>> extends Node<T> {
    // T data;
    /**
     * 当前节点深度
     */
    int depth;
    /**
     * 平衡因子
     */
    int balance;
    public AvlNode<T> parent;
    public AvlNode<T> left;
    public AvlNode<T> right;


    AvlNode(T data) {
        super(data);
        depth = 1;
        balance = 0;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "AvlNode{data=" + data + '}';
    }
}
