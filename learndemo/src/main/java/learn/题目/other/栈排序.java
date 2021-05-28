package learn.题目.other;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author DongYunxiang
 * @create 2021-05-27
 **/
public class 栈排序 {

    public void sortStack(Deque<Integer> stack) {
        Deque<Integer> tmp = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            //依次从stack中弹出数,和tmp栈顶比较, 如果比tmp栈顶小, 就把tmp弹出压回stack
            Integer pop = stack.pop();
            if (!tmp.isEmpty() && pop < tmp.peek()) {
                do {
                    Integer tPop = tmp.pop();
                    stack.push(tPop);
                } while (!tmp.isEmpty() && pop < tmp.peek());
            }
            tmp.push(pop);
        }
        while(!tmp.isEmpty()){
            stack.push(tmp.pop());
        }
    }

    @Test
    public void tt() {
        Consumer<Deque<Integer>> f = this::sortStack;
        {
            ArrayDeque<Integer> stack = new ArrayDeque<>(Arrays.asList(3, 2, 4, 7, 1, 0));
            System.out.println(stack);
            f.accept(stack);
            System.out.println(stack);
        }
        {
            ArrayDeque<Integer> stack = new Random().ints(0, 100).boxed().limit(10).collect(Collectors.toCollection(ArrayDeque::new));
            System.out.println(stack);
            f.accept(stack);
            System.out.println(stack);
        }
    }
}
