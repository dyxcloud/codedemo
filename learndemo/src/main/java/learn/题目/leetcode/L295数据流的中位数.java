package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 动态获取中位数
 *
 * @author DongYunxiang
 * @create 2019-05-30
 **/
@SuppressWarnings("NonAsciiCharacters")
public class L295数据流的中位数 {

    public interface MedianFinder {
        void addNum(int num);

        double findMedian();
    }

    public static class MedianFinderHeap implements MedianFinder {
        /**
         * 高位堆, 最小值在堆顶
         */
        PriorityQueue<Integer> highHeap = new PriorityQueue<>();
        /**
         * 低位堆, 最大值在堆顶
         */
        PriorityQueue<Integer> lowHeap = new PriorityQueue<>(Comparator.reverseOrder());

        public void addNum(int l) {
            if (lowHeap.isEmpty()) {
                lowHeap.offer(l);
            } else {
                if (l <= lowHeap.peek()) {
                    lowHeap.offer(l);
                } else {
                    highHeap.offer(l);
                }
            }
            //reset
            while (highHeap.size() > lowHeap.size()) {
                lowHeap.offer(highHeap.poll());
            }
            while (lowHeap.size() - highHeap.size() > 1) {
                highHeap.offer(lowHeap.poll());
            }
        }

        public double findMedian() {
            if (lowHeap.isEmpty() && highHeap.isEmpty())
                return 0;
            if (lowHeap.isEmpty())
                return highHeap.peek().doubleValue();
            if (highHeap.isEmpty())
                return lowHeap.peek().doubleValue();
            if (lowHeap.size() == highHeap.size()) {
                return (lowHeap.peek().doubleValue() + highHeap.peek()) / 2;
            }
            return lowHeap.peek().doubleValue();
        }
    }

    @Test
    public void testGet() {
        MedianFinder getter;
        {
            getter = new MedianFinderHeap();
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
            getter = new MedianFinderHeap();
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
