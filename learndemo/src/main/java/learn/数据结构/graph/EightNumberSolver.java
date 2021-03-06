package learn.数据结构.graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 八数码问题
 *
 * @author DongYunxiang
 * @create 2019-11-26
 **/
public class EightNumberSolver {
    public static void main(String args[]) {
        int[] array = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        new EightNumberSolver().breadFirstSearch(array);
    }

    private int[] visited;

    private EightNumberSolver() {
        visited = new int[11340];
    }

    private int moveUp(int[] state) {
        int index = findSpace(state);
        if (index < 6) {
            state[index] = state[index + 3];
            state[index + 3] = 0;
        }
        return Permutation.encode(state, 9);
    }

    private int moveDown(int[] state) {
        int index = findSpace(state);
        if (index > 2) {
            state[index] = state[index - 3];
            state[index - 3] = 0;
        }
        return Permutation.encode(state, 9);
    }

    private int moveLeft(int[] state) {
        int index = findSpace(state);
        if (index % 3 != 2) {
            state[index] = state[index + 1];
            state[index + 1] = 0;
        }
        return Permutation.encode(state, 9);
    }

    private int moveRight(int[] state) {
        int index = findSpace(state);
        if (index % 3 != 0) {
            state[index] = state[index - 1];
            state[index - 1] = 0;
        }
        return Permutation.encode(state, 9);
    }

    private int findSpace(int[] state) {
        int index = -1;
        for (int i = 0; i < 9; i++) {
            if (state[i] == 0)
                index = i;
        }
        return index;
    }

    private boolean isChecked(int n) {
        int a = n / 32;
        int b = n & 31;
        return ((visited[a] & (1 << b)) != 0);
    }

    private void visit(int n) {
        int a = n / 32;
        int b = n & 31;
        visited[a] |= (1 << b);
    }

    /**
     * 传入一个列表, 把他转化为code=0的列表
     */
    private void breadFirstSearch(int[] array) {
        int s = Permutation.encode(array, 9);
        LinkedList<Node> q = new LinkedList<>();
        q.addLast(new Node(s, null));
        while (!q.isEmpty()) {
            Node t = q.poll();

            if (t.n == 0) {//如果是终点, 就向前打印列表
                Node iter = t;
                while (iter != null) {
                    int[] arrayIter = Permutation.decode(iter.n, 9);
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            System.out.print(arrayIter[i * 3 + j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println("*********");

                    iter = iter.previous;
                }
                return;
            }

            int[] state = Permutation.decode(t.n, 9);

            int[] tmp = Arrays.copyOf(state,state.length);
            int n = moveUp(tmp);
            if (n != s && !isChecked(n)) {
                visit(n);
                q.addLast(new Node(n, t));
            }

            tmp = Arrays.copyOf(state,state.length);
            n = moveDown(tmp);
            if (n != s && !isChecked(n)) {
                visit(n);
                q.addLast(new Node(n, t));
            }

            tmp = Arrays.copyOf(state,state.length);
            n = moveLeft(tmp);
            if (n != s && !isChecked(n)) {
                visit(n);
                q.addLast(new Node(n, t));
            }

            tmp = Arrays.copyOf(state,state.length);
            n = moveRight(tmp);
            if (n != s && !isChecked(n)) {
                visit(n);
                q.addLast(new Node(n, t));
            }
        }

        System.out.println("no solution");
    }

    class Node {
        int n;
        Node previous;

        Node(int n, Node prev) {
            this.n = n;
            this.previous = prev;
        }
    }
}
