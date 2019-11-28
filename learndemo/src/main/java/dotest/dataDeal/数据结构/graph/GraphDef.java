package dotest.dataDeal.数据结构.graph;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.ArrayDeque;
import java.util.Deque;
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

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();

    static void bfs(Graph g) {
        Deque<ListHead> queue = new ArrayDeque<>(g.v);
        queue.addLast(g.vertex[1]);
        g.vertex[1].visited = true;
        while (!queue.isEmpty()) {
            ListHead tmp = queue.removeFirst();
            System.out.print(tmp.data);
            AdjacentListNode n = tmp.firstArc;
            while (n != null) {
                tmp = g.vertex[n.nodeIndex];
                if (!tmp.visited) {
                    queue.addLast(tmp);
                    tmp.visited = true;
                }
                n = n.nextArc;
            }
        }
    }

    @Test
    public void testbfs(){
        bfs(create());
        TestCase.assertEquals("1235467", log.getLog());
    }

    static void dfs(Graph g, ListHead v) {
        v.visited = true;
        System.out.print(v.data);
        AdjacentListNode n = v.firstArc;
        while (n != null) {
            if (g.vertex[n.nodeIndex].visited) {
                n = n.nextArc;
                continue;
            }
            dfs(g, g.vertex[n.nodeIndex]);
            n = n.nextArc;
        }
    }

    @Test
    public void testdfs(){
        Graph g = create();
        dfs(g,g.vertex[1]);
        TestCase.assertEquals("1253467", log.getLog());
    }

    static void dfs2(Graph g){
        //因为一个顶点的边是单链表存储,不能反向压栈, 所以表现出来就是反向遍历
        ListHead rootHead = g.vertex[1];
        rootHead.visited = true;
        Deque<ListHead> stack = new ArrayDeque<>();
        stack.addFirst(rootHead);
        while (!stack.isEmpty()) {
            ListHead head = stack.removeFirst();
            System.out.print(head.data);
            AdjacentListNode n = head.firstArc;
            while (n != null) {
                ListHead nextHead = g.vertex[n.nodeIndex];
                if (!nextHead.visited) {
                    nextHead.visited = true;
                    stack.addFirst(nextHead);
                }
                n = n.nextArc;
            }
        }
    }

    @Test
    public void testdfs2(){
        dfs2(create());
        TestCase.assertEquals("1534762", log.getLog());
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