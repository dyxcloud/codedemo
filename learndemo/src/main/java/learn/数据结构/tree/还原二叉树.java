package learn.数据结构.tree;

@SuppressWarnings({"NonAsciiCharacters"})
public class 还原二叉树 {

    /**
     * A
     * B   C
     * D E F G
     * 前序:ABDECFG
     * 中序:DBEAFCG
     * 后序:DEBFGCA
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





}
