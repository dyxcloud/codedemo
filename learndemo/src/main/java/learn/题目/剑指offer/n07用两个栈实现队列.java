package learn.题目.剑指offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author DongYunxiang
 * @create 2019-12-10
 **/
@SuppressWarnings("NonAsciiCharacters")
public class n07用两个栈实现队列 {

    class MyQueue{
        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();

        public void push(int node) {
            in.push(node);
        }

        public int pop() {//out不保持空,作为输出保存区
            if (out.isEmpty())
                while (!in.isEmpty())
                    out.push(in.pop());
            if (out.isEmpty())
                throw new RuntimeException("queue is empty");
            return out.pop();
        }

        @Deprecated
        public int pop_() {//out保持空
            while(!in.empty()){
                out.push(in.pop());
            }
            Integer result = out.pop();
            while(!out.empty()){
                in.push(out.pop());
            }
            return result;
        }
    }

    @Test
    public void test0(){
        {
            MyQueue queue = new MyQueue();
            queue.push(1);
            queue.push(2);
            Assert.assertEquals(1,queue.pop());
            Assert.assertEquals(2,queue.pop());
        }
        {
            MyQueue queue = new MyQueue();
            queue.push(1);
            queue.push(3);
            Assert.assertEquals(1,queue.pop());
            queue.push(2);
            Assert.assertEquals(3,queue.pop());
            Assert.assertEquals(2,queue.pop());
        }
    }


    /**
     * 两个队列实现栈
     */
    class MyStack{
        Queue<Integer> queueA = new ArrayDeque<>();
        Queue<Integer> queueB = new ArrayDeque<>();

        public void push(int node) {
            if(queueA.isEmpty())
                queueB.offer(node);
            else
                queueA.offer(node);
        }

        public int pop() {
            Queue<Integer> q1;
            Queue<Integer> q0;
            if(queueA.isEmpty()){
                q0 = queueA;
                q1 = queueB;
            }else{
                q0 = queueB;
                q1 = queueA;
            }
            while(!q1.isEmpty()){
                Integer poll = q1.poll();
                if(q1.isEmpty()){
                    return poll;
                }else{
                    q0.offer(poll);
                }
            }
            throw new RuntimeException("no data");
        }
    }


    @Test
    public void test(){
        {
            MyStack stack = new MyStack();
            stack.push(1);
            stack.push(2);
            Assert.assertEquals(2,stack.pop());
            Assert.assertEquals(1,stack.pop());
        }
        {
            MyStack stack = new MyStack();
            stack.push(1);
            stack.push(3);
            Assert.assertEquals(3,stack.pop());
            stack.push(2);
            Assert.assertEquals(2,stack.pop());
            Assert.assertEquals(1,stack.pop());
        }
    }
}