package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.ListNode;
import org.junit.Test;

import java.util.Arrays;

@SuppressWarnings("NonAsciiCharacters")
public class L61旋转链表 {

    //双指针法
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        //双指针找倒数k
        ListNode fast = head;
        int len = 1;
        while (k > 0) {
            if (fast.next == null) {
                k = --k % len;
                if (k == 0) {
                    return head;
                }
                fast = head;
                // System.out.println(len);
                // System.out.println(k);
                // System.out.println(fast);
            }
            fast = fast.next;
            len++;
            k--;
        }
        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // System.out.println(fast);
        // System.out.println(slow);
        ListNode newHead = slow.next;
        fast.next = head;
        slow.next = null;
        return newHead;
    }

    //制作闭环
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode n = head;
        int len = 1;
        while (n.next != null) {
            len++;
            n = n.next;
        }
        n.next = head;
        k = k % len;
        k = len - k;
        while (k > 0) {
            n = n.next;
            k--;
        }
        ListNode newOne = n.next;
        n.next = null;
        return newOne;
    }

    interface Func {
        ListNode rotateRight(ListNode head, int k);
    }

    @Test
    public void tt() {
        Func f = this::rotateRight1;
        {
            ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
            TestCase.assertEquals(Arrays.asList(4, 5, 1, 2, 3), ListNode.getList(f.rotateRight(head, 2)));
        }
        {
            ListNode head = new ListNode(0, new ListNode(1, new ListNode(2)));
            TestCase.assertEquals(Arrays.asList(2, 0, 1), ListNode.getList(f.rotateRight(head, 4)));
        }
        {
            ListNode head = new ListNode(1, new ListNode(2));
            TestCase.assertEquals(Arrays.asList(1, 2), ListNode.getList(f.rotateRight(head, 2)));
        }
        {
            TestCase.assertEquals(null, f.rotateRight(null, 0));
        }
    }
}
