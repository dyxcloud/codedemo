package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import learn.题目.剑指offer.ListNode;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author DongYunxiang
 * @create 2021-04-12
 **/
public class L876链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        while (fast != null) {
            if (fast.next == null) {
                break;
            }
            fast = fast.next.next;
            head = head.next;
        }
        return head;
    }

    @Test
    public void ttt() {
        Function<ListNode, ListNode> f = this::middleNode;
        {
            ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
            Assertions.assertEquals(3, f.apply(head).val);
        }
        {
            ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
            Assertions.assertEquals(4, f.apply(head).val);
        }
        {
            ListNode head = new ListNode(1);
            Assertions.assertEquals(1, f.apply(head).val);
        }
    }

}
