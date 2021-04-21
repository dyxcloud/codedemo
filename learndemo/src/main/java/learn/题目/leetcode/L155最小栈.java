package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class L155最小栈 {

    //记录最小值
    public static class MinStack{

        Deque<Integer> stack;
        Integer min;

        public MinStack() {
            stack = new ArrayDeque<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                min = val;
            } else {
                min = Math.min(min, val);
            }
            stack.push(val);
        }

        public void pop() {
            Integer pop = stack.pop();
            if (min.equals(pop)) {
                if (stack.isEmpty()) {
                    min = null;
                } else {
                    min = stack.stream().min(Integer::compareTo).get();
                }
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

    //TODO 辅助栈

    //头插 辅助属性

    @Test
    public void ttt() {
        {
            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            TestCase.assertEquals(-3, minStack.getMin());
            minStack.pop();
            TestCase.assertEquals(0, minStack.top());
            TestCase.assertEquals(-2, minStack.getMin());
        }
        {
            MinStack minStack = new MinStack();
            minStack.push(512);
            minStack.push(-1024);
            minStack.push(-1024);
            minStack.push(512);
            minStack.pop();
            TestCase.assertEquals(-1024, minStack.getMin());
            minStack.pop();
            TestCase.assertEquals(-1024, minStack.getMin());
            minStack.pop();
            TestCase.assertEquals(512, minStack.getMin());
        }
    }

}
