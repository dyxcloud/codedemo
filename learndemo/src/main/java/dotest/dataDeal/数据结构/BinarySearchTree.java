package dotest.dataDeal.数据结构;

/**
 * @author DongYunxiang
 * @create 2019-05-09
 **/
public class BinarySearchTree<T extends Comparable<T>> {

    public Node<T> root;

    public boolean insert(T t){
        //TODO insert
        return true;
    }

    class Node<T extends Comparable<T>> {
        public T data;
        public Node left;
        public Node right;

        public Node(T d) {
            this.data = d;
        }
    }
}
