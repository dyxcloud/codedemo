package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author DongYunxiang
 * @create 2021-06-28
 **/
public class L146LRU缓存机制 {

    static class LRUCache {

        int maxSize;
        Deque<Integer> keys;
        Map<Integer, Integer> data;

        public LRUCache(int capacity) {
            maxSize = capacity;
            keys = new ArrayDeque<>(capacity);
            data = new HashMap<>((int) (capacity / 0.75) + 1);
        }

        public int get(int key) {
            return 0;
        }

        public void put(int key, int value) {
            if (keys.size() < maxSize) {
                if (data.containsKey(key)) {
                    
                } else {
                    data.put(key, value);
                    keys.addFirst(key);
                }
            } else {

            }
        }
    }

    @Test
    public void tt() {
        LRUCache lRUCache = new LRUCache(2);
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
}
