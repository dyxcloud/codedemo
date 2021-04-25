package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class L155最小栈 {

    //记录最小值
    public static class MinStack {

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

    //辅助栈
    public static class MinStack1 {

        Deque<Integer> stack;
        Deque<Integer> getMinStack;

        public MinStack1() {
            stack = new ArrayDeque<>();
            getMinStack = new ArrayDeque<>();
        }

        public void push(int val) {

            if (getMinStack.isEmpty()) {
                getMinStack.push(val);
            } else {
                getMinStack.push(Math.min(getMinStack.peek(), val));
            }
            stack.push(val);
        }

        public void pop() {
            Integer pop = stack.pop();
            getMinStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return getMinStack.peek();
        }
    }

    //头插 辅助属性
    public static class MinStack2 {

        MinNode top;

        public MinStack2() {
        }

        public void push(int val) {
            if (top == null) {
                top = new MinNode(val, val, null);
            } else {
                top = new MinNode(val, Math.min(top.min, val), top);
            }
        }

        public void pop() {
            top = top.next;
        }

        public int top() {
            return top.val;
        }

        public int getMin() {
            return top.min;
        }

        class MinNode {
            int val;
            int min;
            MinNode next;

            public MinNode(int val, int min, MinNode next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
    }

    @Test
    public void ttt() {
        {
            MinStack2 minStack = new MinStack2();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            TestCase.assertEquals(-3, minStack.getMin());
            minStack.pop();
            TestCase.assertEquals(0, minStack.top());
            TestCase.assertEquals(-2, minStack.getMin());
        }
        {
            MinStack2 minStack = new MinStack2();
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
