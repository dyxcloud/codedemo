package learn.题目.leetcode;

import learn.题目.剑指offer.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

@SuppressWarnings("NonAsciiCharacters")
public class L142环形链表II {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        //快慢指针计算环的长度
        int slowSize = 0, fastSize = 0;
        ListNode slow = head, fast = head;
        do {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            fastSize += 2;
            slow = slow.next;
            slowSize += 1;
        } while (slow != fast);
        int length = fastSize - slowSize - 1;
        //间隔双指针,获取结果
        slow = head;
        fast = head;
        while (length > 0) {
            fast = fast.next;
            length--;
        }
        while (fast.next != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    @Test
    public void tt() {
        UnaryOperator<ListNode> func = this::detectCycle;
        {
            ListNode l0 = new ListNode(3);
            ListNode l1 = new ListNode(2);
            ListNode l2 = new ListNode(0);
            ListNode l3 = new ListNode(-4);
            l0.next = l1;
            l1.next = l2;
            l2.next = l3;
            l3.next = l1;
            Assertions.assertSame(l1, func.apply(l0));
        }
        {
            ListNode l0 = new ListNode(1);
            ListNode l1 = new ListNode(2);
            l0.next = l1;
            l1.next = l0;
            Assertions.assertSame(l0, func.apply(l0));
        }
        {
            ListNode l0 = new ListNode(1);
            l0.next = l0;
            Assertions.assertSame(l0, func.apply(l0));
        }
        {
            ListNode l0 = new ListNode(1);
            Assertions.assertNull(func.apply(l0));
        }
    }
}
