package learn.数据结构.tree;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * @author DongYunxiang
 * @create 2019-05-09
 **/
public class BinarySearchTree<T extends Comparable<T>> implements Iterable<Node<T>> {

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void insert(T t) {
        if (t == null) throw new NullPointerException("insert data is null");
        if (getRoot() == null) {
            setRoot(new Node<>(t));
        }
        Node<T> node = getRoot();
        while (true) {
            if (node.data.compareTo(t) > 0) {
                //小数, 放左边
                if (node.left == null) {
                    node.left = new Node<>(t);
                    node.left.parent = node;
                    break;
                } else {
                    node = node.left;
                }
            } else {
                //大数,放右边
                if (node.right == null) {
                    node.right = new Node<>(t);
                    node.right.parent = node;
                    break;
                } else {
                    node = node.right;
                }
            }
        }
    }

    public boolean contains(T t) {
        if (t == null) return false;
        Node<T> node = getRoot();
        while (node != null) {
            int result = node.data.compareTo(t);
            if (result == 0)
                return true;
            else if (result > 0)
                node = node.left;
            else
                node = node.right;
        }
        return false;
    }

    public void remove(Node<T> n) {
        Node<T> p = n.parent;
        Node<T> next, child;
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
            next = successorIn(n);
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
    }

    /**
     * 搜索中序后继
     *
     * @param n
     * @return
     */
    Node<T> successorIn(Node<T> n) {
        if (n == null) return null;
        Node<T> p;
        if (n.right != null) {
            p = n.right;
            while (p.left != null) {
                p = p.left;
            }
            return p;
        } else {
            p = n.parent;
            while (p != null && p.left != n) {
                n = p;
                p = n.parent;
            }
            return p;
        }
    }

    @Override
    public Iterator<Node<T>> iterator() {
        return new BstIterator();
    }

    private class BstIterator implements Iterator<Node<T>> {

        Node<T> currentNode = getFirstIn();

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Node<T> next() {
            Node<T> n = currentNode;
            currentNode = successorIn(n);
            return n;
        }

        private Node<T> getFirstIn() {
            if (getRoot() == null) return null;
            Node<T> n = getRoot();
            while (n.left != null) {
                n = n.left;
            }
            return n;
        }
    }

    void insert321546(BinarySearchTree<Integer> tree) {
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
    }

    void insert123456(BinarySearchTree<Integer> tree) {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
    }

    void insert654321(BinarySearchTree<Integer> tree) {
        tree.insert(6);
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
    }

    @Test
    public void testinsert() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        insert321546(tree);
        Deque<Node<Integer>> objects = new ArrayDeque<>();
        objects.push(tree.getRoot());
        TreeSearch.dfsInOrder1(tree.getRoot());
    }

    @Test
    public void testContains() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        insert321546(tree);
        TestCase.assertTrue(tree.contains(6));
        TestCase.assertTrue(tree.contains(4));
        TestCase.assertTrue(tree.contains(2));
        TestCase.assertFalse(tree.contains(0));
        TestCase.assertFalse(tree.contains(10));
        TestCase.assertFalse(tree.contains(null));
    }

    @Test
    public void testdebug() {
        BinarySearchTree<Integer> tree0 = new BinarySearchTree<>();
        insert321546(tree0);
        BinarySearchTree<Integer> tree1 = new BinarySearchTree<>();
        insert123456(tree1);
        BinarySearchTree<Integer> tree2 = new BinarySearchTree<>();
        insert654321(tree2);
        System.out.println();
    }

    @Test
    public void testIterator() {
        BinarySearchTree<Integer> tree0 = new BinarySearchTree<>();
        insert321546(tree0);
        // for(Node<Integer> n: tree0){
        //     System.out.print(n.data);
        // }
        // Iterator<Node<Integer>> iterator = tree0.iterator();
        // while ((iterator.hasNext())){
        //     System.out.print(iterator.next().data);
        // }
        tree0.forEach(n -> System.out.print(n.data));
    }


}

class Node<T extends Comparable<T>> {
    T data;
    public Node<T> parent;
    public Node<T> left;
    public Node<T> right;

    Node(T d) {
        this.data = d;
    }

    Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }


    @Override
    public String toString() {
        return "Node{data=" + data + '}';
    }
}
