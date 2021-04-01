package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class L24两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode b = head.next;
        head.next = b.next;
        b.next = head;
        head.next = swapPairs(head.next);
        return b;
    }

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = new ListNode(-1, head);
        ListNode root = pre;
        ListNode a, b;
        while (head != null && head.next != null) {
            a = head;
            b = head.next;
            a.next = b.next;
            b.next = a;
            pre.next = b;
            pre = a;
            head = a.next;
        }
        return root.next;
    }

    interface Func {
        ListNode swapPairs(ListNode head);
    }

    @Test
    public void tt() {
        Func f = this::swapPairs1;
        {
            ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
            TestCase.assertEquals(Arrays.asList(2, 1, 4, 3), ListNode.getList(f.swapPairs(head)));
        }
        {
            TestCase.assertNull(f.swapPairs(null));
        }
        {
            ListNode head = new ListNode(1);
            TestCase.assertEquals(Collections.singletonList(1), ListNode.getList(f.swapPairs(head)));
        }
    }
}
