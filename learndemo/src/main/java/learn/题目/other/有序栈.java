package learn.题目.other;

import junit.framework.TestCase;
import learn.sort.ArrayData;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.function.Consumer;

/**
 * @author DongYunxiang
 * @create 2021-05-27
 **/
public class 有序栈 {

    public void sortStack(Deque<Integer> stack) {
        Deque<Integer> tmp = new ArrayDeque<>();
        tmp.push(stack.pop());
        while(!stack.isEmpty()){
            //取出一个数, 把stack中比这个数小的数都放进tmp
            
            //放pop, 再依次放tmp
            
            Integer pop = stack.pop();
            
        }
        stack.addAll(tmp);
    }

    @Test
    public void tt() {
        Consumer<Deque<Integer>> f = this::sortStack;
        {
            ArrayDeque<Integer> stack = new ArrayDeque<>(Arrays.asList(3, 2, 4, 7, 1, 0));
            f.accept(stack);
            System.out.println(stack);
        }
    }
}
