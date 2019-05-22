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

    private void insert(AvlNode<T> root, T data) {
        if (root.data.compareTo(data) > 0) {
            if (root.getLeft() != null)
                insert(root.getLeft(), data);
            else {
                root.setLeft(new AvlNode<>(data));
                root.getLeft().setParent(root);
            }
        } else {
            if (root.getRight() != null)
                insert(root.getRight(), data);
            else {
                root.setRight(new AvlNode<>(data));
                root.getRight().setParent(root);
            }
        }
        //平衡处理
        /* 从插入的过程回溯回来的时候，计算平衡因子 */
        root.balance = getBalance(root);
        /* 左子树高，应该右旋 */
        if (root.balance >= 2) {
            /* 右孙高，先左旋 */
            if (root.getLeft().balance == -1)
                left_rotate(root.getLeft());
            right_rotate(root);
        }
        if (root.balance <= -2) {
            if (root.getRight().balance == 1)
                right_rotate(root.getRight());
            left_rotate(root);
        }
        root.balance = getBalance(root);
        root.depth = getDepth(root);
    }

    /**
     * 右旋
     * @param p 旋转前的根节点(父)
     */
    private void right_rotate(AvlNode<T> p) {
        AvlNode<T> pParent = p.getParent();//祖父
        AvlNode<T> pRightSon = p.getLeft();//左子
        AvlNode<T> pLeftGrandSon = pRightSon.getRight();//右孙
        if(getRoot()==p){
            setRoot(pRightSon);
        }
        //祖父关系变换
        pRightSon.setParent(pParent);
        if (pParent != null) {
            if (p == pParent.getLeft())
                pParent.setLeft(pRightSon);
            else if (p == pParent.getRight())
                pParent.setRight(pRightSon);
        }
        //左子为父, 父变右子
        pRightSon.setRight(p);
        p.setParent(pRightSon);
        /* 右孙变左孙 */
        p.setLeft(pLeftGrandSon);
        if (pLeftGrandSon != null)
            pLeftGrandSon.setParent(p);
        /* 重新计算平衡因子 */
        p.depth = getDepth(p);
        p.balance = getBalance(p);
        pRightSon.depth = getDepth(pRightSon);
        pRightSon.balance = getBalance(pRightSon);
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
                pRightSon = pParent.getLeft();
            else if(pParent.getRight()==p)
                pRightSon = pParent.getRight();
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