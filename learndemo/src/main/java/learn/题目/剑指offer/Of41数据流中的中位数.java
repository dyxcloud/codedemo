package learn.题目.剑指offer;

import learn.题目.leetcode.L295数据流的中位数;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class Of41数据流中的中位数 {


    @Test
    public void testGet() {
        L295数据流的中位数.MedianFinder getter;
        {
            getter = new L295数据流的中位数.MedianFinderHeap();
            getter.addNum(1);
            Assertions.assertEquals(1.0, getter.findMedian());
            getter.addNum(2);
            Assertions.assertEquals(1.5, getter.findMedian());
            getter.addNum(3);
            Assertions.assertEquals(2.0, getter.findMedian());
            getter.addNum(4);
            Assertions.assertEquals(2.5, getter.findMedian());
            getter.addNum(5);
            Assertions.assertEquals(3.0, getter.findMedian());
            getter.addNum(6);
            Assertions.assertEquals(3.5, getter.findMedian());
        }
        {
            getter = new L295数据流的中位数.MedianFinderHeap();
            getter.addNum(-1);
            Assertions.assertEquals(-1.0, getter.findMedian());
            getter.addNum(-2);
            Assertions.assertEquals(-1.5, getter.findMedian());
            getter.addNum(-3);
            Assertions.assertEquals(-2.0, getter.findMedian());
            getter.addNum(-4);
            Assertions.assertEquals(-2.5, getter.findMedian());
            getter.addNum(-5);
            Assertions.assertEquals(-3.0, getter.findMedian());
        }
    }
}
