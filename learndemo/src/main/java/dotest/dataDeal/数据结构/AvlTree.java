package dotest.dataDeal.数据结构;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * @author DongYunxiang
 * @create 2019-05-21
 **/
public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    private AvlNode<T> root;

    @Override
    public AvlNode<T> getRoot(){
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
        }else{
            insert(getRoot(), data);
        }
    }

    private void insert(AvlNode<T> node, T data) {
        if (node.data.compareTo(data) > 0) {
            if (node.getLeft() != null)
                insert(node.getLeft(), data);
            else {
                node.setLeft(new AvlNode<>(data));
                node.getLeft().setParent(node);
            }
        } else {
            if (node.getRight() != null)
                insert(node.getRight(), data);
            else {
                node.setRight(new AvlNode<>(data));
                node.getRight().setParent(node);
            }
        }
        takeBalance(node);
    }

    public void remove(AvlNode<T> n) {
        AvlNode<T> p = n.getParent();
        AvlNode<T> next, child;
        // 叶子结点，直接删除即可。要考虑待删除结点是root的情况。
        if (n.getLeft() == null && n.getRight() == null) {
            if (n == getRoot()) {
                setRoot(null);
            } else if (n == p.getLeft()) {
                p.setLeft(null);
            } else if (n == p.getRight()) {
                p.setRight(null);
            }
        }
        // 内部结点，把它的后继的值拷进来，然后递归删除它的后继。
        else if (n.getLeft() != null && n.getRight() != null) {
            next = (AvlNode<T>) successorIn(n);
            n.data = next.data;
            remove(next);
        }
        // 只有一个孩子的结点，把它的孩子交给它的父结点即可。
        else {
            child = n.getLeft()!=null? n.getLeft():n.getRight();
            if (n == getRoot()) {
                child.setParent(null);
                setRoot(child);
            }else if (n == p.getLeft()) {
                child.setParent(p);
                p.setLeft(child);
            } else {
                child.setParent(p);
                p.setRight(child);
            }
        }
        takeBalance(n);
    }

    private void takeBalance(AvlNode<T> node){
        //平衡处理
        /* 从插入的过程回溯回来的时候，计算平衡因子 */
        node.balance = getBalance(node);
        /* 左子树高，应该右旋 */
        if (node.balance >= 2) {
            /* 右孙高，先左旋 */
            if (node.getLeft().balance == -1)
                left_rotate(node.getLeft());
            right_rotate(node);
        }
        if (node.balance <= -2) {
            if (node.getRight().balance == 1)
                right_rotate(node.getRight());
            left_rotate(node);
        }
        node.balance = getBalance(node);
        node.depth = getDepth(node);
    }

    /**
     * 右旋
     * @param p 旋转前的根节点(父)
     */
    private void right_rotate(AvlNode<T> p) {
        AvlNode<T> pParent = p.getParent();//祖父
        AvlNode<T> pLeftSon = p.getLeft();//左子
        AvlNode<T> pRightGrandSon = pLeftSon.getRight();//右孙
        if(getRoot()==p){
            setRoot(pLeftSon);
        }
        //祖父关系变换
        pLeftSon.setParent(pParent);
        if (pParent != null) {
            if (p == pParent.getLeft())
                pParent.setLeft(pLeftSon);
            else if (p == pParent.getRight())
                pParent.setRight(pLeftSon);
        }
        //左子为父, 父变右子
        pLeftSon.setRight(p);
        p.setParent(pLeftSon);
        /* 右孙变左孙 */
        p.setLeft(pRightGrandSon);
        if (pRightGrandSon != null)
            pRightGrandSon.setParent(p);
        /* 重新计算平衡因子 */
        p.depth = getDepth(p);
        p.balance = getBalance(p);
        pLeftSon.depth = getDepth(pLeftSon);
        pLeftSon.balance = getBalance(pLeftSon);
    }

    /**左旋*/
    private void left_rotate(AvlNode<T> p) {
        //右子为父, 父变左子, 左孙变右孙
        AvlNode<T> pParent = p.getParent();
        AvlNode<T> pRightSon = p.getRight();
        AvlNode<T> pLeftGrandSon = pRightSon.getLeft();
        if(getRoot()==p){
            setRoot(pRightSon);
        }
        //祖父
        pRightSon.setParent(pParent);
        if(pParent!=null){
            if(pParent.getLeft()==p)
                pParent.setLeft(pRightSon);
            else if(pParent.getRight()==p)
                pParent.setRight(pRightSon);
        }
        //根节点
        pRightSon.setLeft( p);
        p.setParent(pRightSon);
        //孙节点
        if(pLeftGrandSon!=null)
            pLeftGrandSon.setParent( p);
        p.setRight(pLeftGrandSon);
        //重计算
        p.depth = getDepth(p);
        p.balance = getBalance(p);
        pRightSon.depth = getDepth(pRightSon);
        pRightSon.balance = getBalance(pRightSon);
    }

    /**计算平衡因子*/
    private int getBalance(AvlNode<T> p) {
        int left_depth = p.getLeft() == null ? 0 : p.getLeft().depth;
        int right_depth = p.getRight() == null ? 0 : p.getRight().depth;
        return left_depth - right_depth;
    }

    /**计算深度*/
    private int getDepth(AvlNode<T> p) {
        int depth = 0;
        if (p.getLeft() != null)
            depth = p.getLeft().depth;
        if (p.getRight() != null && depth < p.getRight().depth)
            depth = p.getRight().depth;
        depth++;
        return depth;
    }

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    @Test
    public void testInsert(){
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
        while ((iterator.hasNext())){
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
    /** 当前节点深度*/
    int depth;
    /**平衡因子*/
    int balance;
    private AvlNode<T> parent;
    private AvlNode<T> left;
    private AvlNode<T> right;


    AvlNode(T data) {
        super(data);
        depth = 1;
        balance = 0;
        left = null;
        right = null;
    }

    @Override
    public AvlNode<T> getParent() {
        return parent;
    }

    public void setParent(AvlNode<T> parent) {
        this.parent = parent;
    }

    @Override
    public AvlNode<T> getLeft() {
        return left;
    }

    public void setLeft(AvlNode<T> left) {
        this.left = left;
    }

    @Override
    public AvlNode<T> getRight() {
        return right;
    }

    public void setRight(AvlNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "AvlNode{data=" + data + '}';
    }
}