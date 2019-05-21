package dotest.dataDeal.数据结构;

/**
 * @author DongYunxiang
 * @create 2019-05-21
 **/
public class AvlTree<T extends Comparable<T>> {
    private AvlNode<T> root;

    public void insert(T data) {
        if (data == null) throw new NullPointerException("insert data is null");
        if (root == null) {
            root = new AvlNode<>(data);
        }
        insert(this.root, data);
    }

    private void insert(AvlNode<T> root, T data) {
        if (root.data.compareTo(data) > 0) {
            if (root.left != null)
                insert(root.left, data);
            else {
                root.left = new AvlNode<>(data);
                root.left.parent = root;
            }
        } else {
            if (root.right != null)
                insert(root.right, data);
            else {
                root.right = new AvlNode<>(data);
                root.right.parent = root;
            }
        }
        //平衡处理
        /* 从插入的过程回溯回来的时候，计算平衡因子 */
        root.balance = getBalance(root);
        /* 左子树高，应该右旋 */
        if (root.balance >= 2) {
            /* 右孙高，先左旋 */
            if (root.left.balance == -1)
                left_rotate(root.left);
            right_rotate(root);
        }
        if (root.balance <= -2) {
            if (root.right.balance == 1)
                right_rotate(root.right);
            left_rotate(root);
        }
        root.balance = getBalance(root);
        root.depth = getDepth(root);
    }

    /**右旋*/
    private void right_rotate(AvlNode p) {
        /* 一次旋转涉及到的结点包括祖父，父亲，右儿子 */
        AvlNode pParent = p.parent, pRightSon = p.left;
        AvlNode pLeftGrandSon = pRightSon.right;
        /* 左子僭为父 */
        pRightSon.parent = pParent;
        if (pParent != null) {
            if (p == pParent.left)
                pParent.left = pRightSon;
            else if (p == pParent.right)
                pParent.right = pRightSon;
        }
        pRightSon.right = p;
        p.parent = pRightSon;
        /* 右孙变左孙 */
        p.left = pLeftGrandSon;
        if (pLeftGrandSon != null)
            pLeftGrandSon.parent = p;
        /* 重新计算平衡因子 */
        p.depth = getDepth(p);
        p.balance = getBalance(p);
        pRightSon.depth = getDepth(pRightSon);
        pRightSon.balance = getBalance(pRightSon);
    }

    /**左旋*/
    private void left_rotate(AvlNode p) {
        //TODO
    }

    /**计算平衡因子*/
    private int getBalance(AvlNode p) {
        int left_depth = p.left == null ? 0 : p.left.depth;
        int right_depth = p.right == null ? 0 : p.right.depth;
        return left_depth - right_depth;
    }

    /**计算深度*/
    private int getDepth(AvlNode p) {
        int depth = 0;
        if (p.left != null)
            depth = p.left.depth;
        if (p.right != null && depth < p.right.depth)
            depth = p.right.depth;
        depth++;
        return depth;
    }

}

class AvlNode<T extends Comparable<T>> {
    T data;
    /** 当前节点深度*/
    int depth;
    /**平衡因子*/
    int balance;
    AvlNode<T> parent;
    AvlNode<T> left;
    AvlNode<T> right;

    AvlNode(T data) {
        this.data = data;
        depth = 1;
        balance = 0;
        left = null;
        right = null;
    }
}