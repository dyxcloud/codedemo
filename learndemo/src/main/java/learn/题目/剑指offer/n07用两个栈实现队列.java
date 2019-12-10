package learn.题目.剑指offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author DongYunxiang
 * @create 2019-12-10
 **/
@SuppressWarnings("NonAsciiCharacters")
public class n07用两个栈实现队列 {

    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(int node) {
        in.push(node);

    }

    public int pop() {
        if (out.isEmpty())
            while (!in.isEmpty())
                out.push(in.pop());
        if (out.isEmpty())
            throw new RuntimeException("queue is empty");
        return out.pop();
    }

    @Deprecated
    public int pop_() {
        while(!in.empty()){
            out.push(in.pop());
        }
        Integer result = out.pop();
        while(!out.empty()){
            in.push(out.pop());
        }
        return result;
    }

    @Test
    public void test(){
        {
            n07用两个栈实现队列 queue = new n07用两个栈实现队列();
            queue.push(1);
            queue.push(2);
            Assert.assertEquals(1,queue.pop());
            Assert.assertEquals(2,queue.pop());
        }
        {
            n07用两个栈实现队列 queue = new n07用两个栈实现队列();
            queue.push(1);
            queue.push(3);
            Assert.assertEquals(1,queue.pop());
            queue.push(2);
            Assert.assertEquals(3,queue.pop());
            Assert.assertEquals(2,queue.pop());
        }
    }
}
