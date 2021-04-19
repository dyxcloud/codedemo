package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;

/**
 * @author DongYunxiang
 * @create 2021-04-19
 **/
public class L203移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode root = new ListNode(-1, head);
        ListNode pre = root;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return root.next;
    }

    @Test
    public void ttt() {
        BiFunction<ListNode, Integer, ListNode> f = this::removeElements;
        {
            ListNode root = ListNode.creatList(1, 2, 6, 3, 4, 5, 6);
            TestCase.assertEquals(Arrays.asList(1, 2, 3, 4, 5), ListNode.getList(f.apply(root, 6)));
        }
        {
            TestCase.assertEquals(null, f.apply(null, 1));
        }
        {
            ListNode root = ListNode.creatList(7, 7, 7, 7);
            TestCase.assertEquals(null, f.apply(root, 7));
        }
    }

}
