package dotest.dataDeal.数据结构.graph;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Scanner;

/**
 * @author DongYunxiang
 * @create 2019-11-26
 **/
public class GraphDef {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        int v = cin.nextInt();
        int e = cin.nextInt();

        Graph g = new Graph(v, e);

        for (int i = 0; i < e; i++) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            g.addEdge(a, b);
        }

        g.breadthFirstSearch();
    }
}

class Graph {
    int v;
    int e;
    ListHead[] vertex;

    public Graph(int v, int e) {
        this.v = v;
        this.e = e;
        vertex = new ListHead[v + 1];

        for (int i = 1; i <= v; i++) {
            vertex[i] = new ListHead(i);
        }
    }

    public void addEdge(int a, int b) {
        vertex[a].linkTo(b);
        vertex[b].linkTo(a);
    }

    public void breadthFirstSearch() {
        ArrayQueue<ListHead> q = new ArrayQueue<>(v);
        q.add(vertex[1]);
        vertex[1].visited = true;

        while (!q.isEmpty()) {
            ListHead tmp = q.remove(0);
            System.out.println(tmp.data);

            AdjacentListNode n = tmp.firstArc;

            while (n != null) {
                tmp = vertex[n.nodeIndex];
                if (!tmp.visited) {
                    q.add(tmp);
                    tmp.visited = true;
                }

                n = n.nextArc;
            }
        }
    }
}

class AdjacentListNode {
    public int nodeIndex;
    public int info;

    public AdjacentListNode nextArc;

    public AdjacentListNode(int nodeIndex) {
        this.nodeIndex = nodeIndex;
        nextArc = null;
    }
}

class ListHead {
    int data;
    AdjacentListNode firstArc;

    public boolean visited;

    public ListHead(int data) {
        this.data = data;
        visited = false;
    }

    public void linkTo(int end) {
        if (firstArc == null) {
            firstArc = new AdjacentListNode(end);
            return;
        }

        AdjacentListNode n = firstArc;
        while (n.nextArc != null) {
            n = n.nextArc;
        }

        n.nextArc = new AdjacentListNode(end);
    }
}
