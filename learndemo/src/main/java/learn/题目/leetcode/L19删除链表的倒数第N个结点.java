package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author DongYunxiang
 * @create 2021-03-26
 **/
public class L19删除链表的倒数第N个结点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode(-1, head);
        ListNode slow = root, fast = root;
        while (n > 0) {
            if (fast == null) {
                return head;
            }
            fast = fast.next;
            n--;
        }
        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
            }
        }
        slow.next = slow.next.next;
        return root.next;
    }

    @Test
    public void tt() {
        {
            ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
            TestCase.assertEquals(Arrays.asList(1, 2, 3, 5), ListNode.getList(removeNthFromEnd(root, 2)));
        }
        {
            ListNode root = new ListNode(1);
            TestCase.assertEquals(Collections.emptyList(), ListNode.getList(removeNthFromEnd(root, 1)));
        }
        {
            ListNode root = new ListNode(1, new ListNode(2));
            TestCase.assertEquals(Arrays.asList(1), ListNode.getList(removeNthFromEnd(root, 1)));
        }
        {
            ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
            TestCase.assertEquals(Arrays.asList(2, 3, 4, 5), ListNode.getList(removeNthFromEnd(root, 5)));
        }
        {
            ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
            TestCase.assertEquals(Arrays.asList(1, 2, 3, 4, 5), ListNode.getList(removeNthFromEnd(root, 10)));
        }
    }

}
