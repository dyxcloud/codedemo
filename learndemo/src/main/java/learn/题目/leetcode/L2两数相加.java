package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author DongYunxiang
 * @create 2021-03-23
 **/
public class L2两数相加 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode n = root;
        int incr = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + incr;
            if (sum > 9) {
                incr = 1;
                sum -= 10;
            } else {
                incr = 0;
            }
            n.next = new ListNode(sum);
            n = n.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode last = l1 == null ? l2 : l1;
        while (last != null) {
            int sum = last.val + incr;
            if (sum > 9) {
                incr = 1;
                sum -= 10;
            } else {
                incr = 0;
            }
            n.next = new ListNode(sum);
            if (incr == 0) {
                n.next.next = last.next;
                break;
            }
            n = n.next;
            last = last.next;
        }
        if (incr != 0) {
            n.next = new ListNode(incr);
        }
        return root.next;
    }

    @Test
    public void tt() {
        {
            ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
            ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
            TestCase.assertEquals(Arrays.asList(7, 0, 8), ListNode.getList(addTwoNumbers(l1, l2)));
        }
        {
            ListNode l1 = new ListNode(9, new ListNode(1, new ListNode(6)));
            ListNode l2 = new ListNode(0);
            TestCase.assertEquals(Arrays.asList(9, 1, 6), ListNode.getList(addTwoNumbers(l1, l2)));
        }
        {
            ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
            ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
            TestCase.assertEquals(Arrays.asList(8, 9, 9, 9, 0, 0, 0, 1), ListNode.getList(addTwoNumbers(l1, l2)));
        }
        {
            ListNode l1 = new ListNode(0);
            ListNode l2 = new ListNode(0);
            TestCase.assertEquals(Collections.singletonList(0), ListNode.getList(addTwoNumbers(l1, l2)));
        }
    }

}
