package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.ListNode;
import org.junit.Test;

import java.util.function.BiFunction;

/**
 * @author DongYunxiang
 * @create 2021-04-13
 **/
public class L160相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        if (headA == headB) {
            return headA;
        }
        ListNode n1 = headA;
        while (n1.next != null) {
            n1 = n1.next;
        }
        n1.next = headB;
        ListNode fast = headA;
        ListNode result = null;
        while (fast != null) {
            if (fast.next == null) {
                break;
            }
            fast = fast.next.next;
            headA = headA.next;
            if (fast == headA) {
                result = headA;
                break;
            }
        }
        n1.next = null;
        return result;
    }

    @Test
    public void ttt() {
        BiFunction<ListNode, ListNode, ListNode> f = this::getIntersectionNode;
        {
            ListNode same = new ListNode(8, new ListNode(4, new ListNode(5)));
            ListNode l1 = new ListNode(5, new ListNode(0, new ListNode(1, same)));
            ListNode l2 = new ListNode(4, new ListNode(1, same));
            TestCase.assertEquals(same, f.apply(l1, l2));
        }
        {
            ListNode same = new ListNode(2, new ListNode(4));
            ListNode l1 = new ListNode(0, new ListNode(9, new ListNode(1, same)));
            ListNode l2 = new ListNode(3, same);
            TestCase.assertEquals(same, f.apply(l1, l2));
        }
        {
            ListNode l1 = new ListNode(2, new ListNode(6, new ListNode(4)));
            ListNode l2 = new ListNode(1, new ListNode(5));
            TestCase.assertEquals(null, f.apply(l1, l2));
        }
    }

}
