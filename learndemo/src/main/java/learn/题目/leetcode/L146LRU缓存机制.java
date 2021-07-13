package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author DongYunxiang
 * @create 2021-06-28
 **/
public class L146LRU缓存机制 {

    static class LRUCache {

        HashMap<Integer, Node> data;
        int maxSize;
        final Node root;
        Node last;

        public LRUCache(int capacity) {
            maxSize = capacity;
            data = new HashMap<>((int) (capacity / 0.75) + 1);
            root = new Node(-1, -1);
        }

        private void unlink(Node node) {
            if (last == node) {
                if (node.pre != root) {
                    last = node.pre;
                } else {
                    last = null;
                }
            } else {
                node.next.pre = node.pre;
            }
            node.pre.next = node.next;
        }

        private void linkHead(Node node) {
            if (last == null) {
                last = node;
            }
            //修改后继的pre
            if (root.next != null) {
                root.next.pre = node;
            }
            //修改node
            node.next = root.next;
            node.pre = root;
            //修改前驱的next
            root.next = node;
        }

        public int get(int key) {
            if (!data.containsKey(key)) {
                return -1;
            }
            Node node = data.get(key);
            if (root.next != node) {
                unlink(node);
                linkHead(node);
            }
            return node.value;
        }

        public void put(int key, int value) {
            if (data.containsKey(key)) {
                Node node = data.get(key);
                node.value = value;
                if (root.next != node) {
                    unlink(node);
                    linkHead(node);
                }
            } else if (data.size() >= maxSize) {
                //删除last
                data.remove(last.key);
                unlink(last);
                //插入node
                Node node = new Node(key, value);
                data.put(key, node);
                linkHead(node);
            } else {
                //插入node
                Node node = new Node(key, value);
                data.put(key, node);
                linkHead(node);
            }
        }

        static class Node {
            int key;
            int value;
            Node pre;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public String toString() {
                Integer p = null;
                if (pre != null) p = pre.key;
                Integer n = null;
                if (next != null) n = next.key;
                return "Node{" +
                        "key=" + key +
                        ", value=" + value +
                        ", pre=" + p +
                        ", next=" + n +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "LRUCache{" +
                    "data=" + data.keySet() +
                    ", maxSize=" + maxSize +
                    ", root=" + root +
                    ", last=" + last +
                    '}';
        }
    }

    static class LRUCache1 {

        LinkedHashMap<Integer, Integer> data;
        int maxSize;

        public LRUCache1(int capacity) {
            data = new LinkedHashMap<>((int) (capacity / 0.75) + 1,0.75F,true);
            maxSize = capacity;
        }

        public int get(int key) {
            return data.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            if (!data.containsKey(key) && data.size() >= maxSize){
                Set<Integer> integers = data.keySet();
                Integer next = integers.iterator().next();
                data.remove(next);
            }
            data.put(key, value);
        }
    }

    static class LRUCache2 extends LinkedHashMap<Integer,Integer> {

        int maxSize;
        
        public LRUCache2(int capacity) {
            super((int) (capacity / 0.75) + 1,0.75F,true);
            maxSize = capacity;
        }

        public int get(int key) {
            return getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key,value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size()>maxSize;
        }
    }

    @Test
    public void tt() {
        LRUCache2 lRUCache;
        {
            lRUCache = new LRUCache2(1);
            lRUCache.put(2, 1);
            TestCase.assertEquals(1, lRUCache.get(2));
        }
        {
            lRUCache = new LRUCache2(2);
            lRUCache.put(1, 1); // 缓存是 {1=1}
            lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
            TestCase.assertEquals(1, lRUCache.get(1));
            lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
            TestCase.assertEquals(-1, lRUCache.get(2));
            lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
            TestCase.assertEquals(-1, lRUCache.get(1));
            TestCase.assertEquals(3, lRUCache.get(3));
            TestCase.assertEquals(4, lRUCache.get(4));
        }
        {
            lRUCache = new LRUCache2(1);
            lRUCache.put(2, 1); // 缓存是 {1=1}
            TestCase.assertEquals(1, lRUCache.get(2));
            lRUCache.put(3, 2); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
            TestCase.assertEquals(-1, lRUCache.get(2));
            TestCase.assertEquals(2, lRUCache.get(3));
        }
        {
            lRUCache = new LRUCache2(2);
            lRUCache.put(2, 1);
            lRUCache.put(2, 2);
            TestCase.assertEquals(2, lRUCache.get(2));
            lRUCache.put(1, 1);
            lRUCache.put(4, 1);
            TestCase.assertEquals(-1, lRUCache.get(2));
        }
    }
}
