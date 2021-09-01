package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import learn.题目.剑指offer.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class L143重排链表 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //快慢指针获取中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;
        //反转后部分
        ListNode dummyHead = new ListNode(-1);
        while (secondHead != null) {
            ListNode tmp = dummyHead.next;
            dummyHead.next = secondHead;
            ListNode next = secondHead.next;
            secondHead.next = tmp;
            secondHead = next;
        }
        secondHead = dummyHead.next;
        //双指针合并
        while (head != null && secondHead != null) {
            ListNode firstNext = head.next;
            ListNode secondNext = secondHead.next;
            head.next = secondHead;
            secondHead.next = firstNext;

            head = firstNext;
            secondHead = secondNext;
        }
    }

    @Test
    public void tt() {
        {
            ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
            reorderList(listNode);
            Assertions.assertEquals(Arrays.asList(1, 4, 2, 3), ListNode.getList(listNode));
        }
        {
            ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
            reorderList(listNode);
            Assertions.assertEquals(Arrays.asList(1, 5, 2, 4, 3), ListNode.getList(listNode));
        }
        {
            ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3)));
            reorderList(listNode);
            Assertions.assertEquals(Arrays.asList(1, 3, 2), ListNode.getList(listNode));
        }
        {
            ListNode listNode = new ListNode(1, new ListNode(2));
            reorderList(listNode);
            Assertions.assertEquals(Arrays.asList(1, 2), ListNode.getList(listNode));
        }
        {
            ListNode listNode = new ListNode(1);
            reorderList(listNode);
            Assertions.assertEquals(Arrays.asList(1), ListNode.getList(listNode));
        }
        {
            ListNode listNode = null;
            reorderList(listNode);
            Assertions.assertNull(listNode);
        }
    }
}
