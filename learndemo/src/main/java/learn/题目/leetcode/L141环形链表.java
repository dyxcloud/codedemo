package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.ListNode;
import org.junit.Test;

import java.util.function.Predicate;

/**
 * @author DongYunxiang
 * @create 2021-04-12
 **/
public class L141环形链表 {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        while (fast != null) {
            if (fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            head = head.next;
            if (fast == head) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void ttt() {
        Predicate<ListNode> f = this::hasCycle;
        {
            ListNode n = new ListNode(-4);
            ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, n)));
            n.next = head;
            TestCase.assertTrue(f.test(head));
        }
        {
            ListNode n = new ListNode(2);
            ListNode head = new ListNode(1, n);
            n.next = head;
            TestCase.assertTrue(f.test(head));
        }
        {
            ListNode head = new ListNode(1, new ListNode(2));
            TestCase.assertFalse(f.test(head));
        }
        {
            ListNode head = new ListNode(1);
            TestCase.assertFalse(f.test(head));
        }
    }
}
