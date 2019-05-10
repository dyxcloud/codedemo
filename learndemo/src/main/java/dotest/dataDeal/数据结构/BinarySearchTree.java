package dotest.dataDeal.数据结构;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author DongYunxiang
 * @create 2019-05-09
 **/
public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public Node<T> getRoot(){
        return root;
    }

    public boolean insert(T t){
        if(t==null) throw new NullPointerException("insert data is null");
        if(root==null){
            root=new Node<>(t);
            return true;
        }
        Node<T> node = root;
        while(true){
            if(node.data.compareTo(t)>0){
                //小数, 放左边
                if(node.left==null){
                    node.left= new Node<>(t);
                    break;
                }else {
                    node = node.left;
                }
            }else{
                //大数,放右边
                if(node.right==null){
                    node.right=new Node<>(t);
                    break;
                }else {
                    node = node.right;
                }
            }
        }
        return true;
    }

    public boolean contains(T t){
        if(t==null) return false;
        Node<T> node = root;
        while(node!=null){
            int result = node.data.compareTo(t);
            if(result==0)
                return true;
            if(result>0){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return false;
    }



    @Test
    public void testinsert(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);
        Deque<Node> objects = new ArrayDeque<>();
        objects.push(tree.getRoot());
        TreeSearch.bfs1(objects);
    }

    @Test
    public void testContains(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);

        TestCase.assertTrue(tree.contains(6));
        TestCase.assertTrue(tree.contains(4));
        TestCase.assertTrue(tree.contains(2));
        TestCase.assertFalse(tree.contains(0));
        TestCase.assertFalse(tree.contains(10));
        TestCase.assertFalse(tree.contains(null));
    }

    @Test
    public void testdebug(){
        BinarySearchTree<Integer> tree0 = new BinarySearchTree<Integer>(){{
            insert(3);
            insert(2);
            insert(1);
            insert(5);
            insert(4);
            insert(6);
        }};
        BinarySearchTree<Integer> tree1 = new BinarySearchTree<Integer>(){{
            insert(1);
            insert(2);
            insert(3);
            insert(4);
            insert(5);
            insert(6);
        }};
        BinarySearchTree<Integer> tree2 = new BinarySearchTree<Integer>(){{
            insert(6);
            insert(5);
            insert(4);
            insert(3);
            insert(2);
            insert(1);
        }};
        System.out.println();
    }


}
class Node<T extends Comparable<T>> {
    T data;
    Node<T> left;
    Node<T> right;

    Node(T d) {
        this.data = d;
    }

    Node(T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}