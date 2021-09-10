package learn.数据结构.tree;

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
}
