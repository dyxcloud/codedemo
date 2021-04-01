package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.ListNode;
import org.junit.Test;

import java.util.Arrays;

public class L61旋转链表 {

    public ListNode rotateRight(ListNode head, int k) {
        return null;
    }

    interface Func {
        ListNode rotateRight(ListNode head, int k);
    }

    @Test
    public void tt() {
        Func f = this::rotateRight;
        {
            ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
            TestCase.assertEquals(Arrays.asList(4, 5, 1, 2, 3), ListNode.getList(f.rotateRight(head, 2)));
        }
        {
            ListNode head = new ListNode(0, new ListNode(1, new ListNode(2)));
            TestCase.assertEquals(Arrays.asList(2, 0, 1), ListNode.getList(f.rotateRight(head, 4)));
        }
    }
}
