package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class L82删除排序链表中的重复元素II {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = new ListNode(-1, head);
        ListNode prepre = root;
        ListNode n = prepre.next.next;
        ListNode depHead = null;
        while (n != null) {
            if (prepre.next.val == n.val) {
                n = n.next;
                depHead = prepre.next;
            } else {
                if (prepre.next.next != n) {
                    prepre.next = n;
                    depHead = null;
                    n = n.next;
                } else {
                    prepre = prepre.next;
                    n = n.next;
                }
            }
        }
        if (prepre.next == depHead) {
            prepre.next = null;
        } else {
            prepre.next.next = null;
        }
        return root.next;
    }

    @Test
    public void tt() {
        {
            ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
            TestCase.assertEquals(Arrays.asList(1, 2, 5), ListNode.getList(deleteDuplicates(head)));
        }
        {
            ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
            TestCase.assertEquals(Arrays.asList(2, 3), ListNode.getList(deleteDuplicates(head)));
        }
        {
            ListNode head = new ListNode(1);
            TestCase.assertEquals(Collections.singletonList(1), ListNode.getList(deleteDuplicates(head)));
        }
        {
            TestCase.assertNull(deleteDuplicates(null));
        }
        {
            ListNode head = new ListNode(1, new ListNode(1));
            TestCase.assertNull(deleteDuplicates(head));
        }
        {
            ListNode head = new ListNode(1, new ListNode(2, new ListNode(2)));
            TestCase.assertEquals(Collections.singletonList(1), ListNode.getList(deleteDuplicates(head)));
        }
        {
            ListNode head = new ListNode(1, new ListNode(2));
            TestCase.assertEquals(Arrays.asList(1, 2), ListNode.getList(deleteDuplicates(head)));
        }
    }
}
