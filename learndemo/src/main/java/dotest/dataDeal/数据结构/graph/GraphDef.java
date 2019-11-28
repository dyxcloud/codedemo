package dotest.dataDeal.数据结构.graph;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Scanner;

/**
 * @author DongYunxiang
 * @create 2019-11-26
 **/
public class GraphDef {

    static Graph createByTypeIn(){
        Scanner cin = new Scanner(System.in);
        int v = cin.nextInt();
        int e = cin.nextInt();
        Graph g = new Graph(v, e);
        for (int i = 0; i < e; i++) {
            int a = cin.nextInt();
            int b = cin.nextInt();
            g.addEdge(a, b);
        }
        return g;
    }
    static Graph create(){
        Graph g = new Graph(7, 9);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1,5);
        g.addEdge(2,5);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4,6);
        g.addEdge(4,7);
        g.addEdge(6,7);
        return g;
    }

    public static void main(String[] args) {

        // Graph g = createByTypeIn();
        Graph g = create();
        // g.bfs();
        g.dfs(g.vertex[1]);
    }
}

class Graph {
    int v;
    int e;
    ListHead[] vertex;

    Graph(int v, int e) {
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

    public void bfs() {
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

    public void dfs(ListHead v) {
        v.visited = true;
        System.out.println(v.data);
        AdjacentListNode n = v.firstArc;
        while (n != null) {
            if (vertex[n.nodeIndex].visited) {
                n = n.nextArc;
                continue;
            }
            dfs(vertex[n.nodeIndex]);
            n = n.nextArc;
        }
    }
}

class AdjacentListNode {
    int nodeIndex;
    int info;

    AdjacentListNode nextArc;

    AdjacentListNode(int nodeIndex) {
        this.nodeIndex = nodeIndex;
        nextArc = null;
    }
}

class ListHead {
    int data;
    AdjacentListNode firstArc;

    boolean visited;

    ListHead(int data) {
        this.data = data;
        visited = false;
    }

    void linkTo(int end) {
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
