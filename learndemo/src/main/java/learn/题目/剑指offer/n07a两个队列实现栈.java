package learn.题目.剑指offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author DongYunxiang
 * @create 2019-12-10
 **/
@SuppressWarnings("NonAsciiCharacters")
public class n07a两个队列实现栈 {

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


    @Test
    public void test(){
        {
            n07a两个队列实现栈 stack = new n07a两个队列实现栈();
            stack.push(1);
            stack.push(2);
            Assert.assertEquals(2,stack.pop());
            Assert.assertEquals(1,stack.pop());
        }
        {
            n07a两个队列实现栈 stack = new n07a两个队列实现栈();
            stack.push(1);
            stack.push(3);
            Assert.assertEquals(3,stack.pop());
            stack.push(2);
            Assert.assertEquals(2,stack.pop());
            Assert.assertEquals(1,stack.pop());
        }
    }
}
