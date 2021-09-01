package learn.题目.leetcode;

import org.junit.jupiter.api.Assertions;
import learn.题目.剑指offer.ListNode;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

/**
 * @author DongYunxiang
 * @create 2021-04-13
 **/
public class L160相交链表 {

    // 501xyz41xyz
    // 41xyz501xyz
    //两条链表相加长度一定相等, 第一个相同位置的值相等的结点就是交点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    @Test
    public void ttt() {
        BiFunction<ListNode, ListNode, ListNode> f = this::getIntersectionNode;
        {
            ListNode same = new ListNode(8, new ListNode(4, new ListNode(5)));
            ListNode l1 = new ListNode(5, new ListNode(0, new ListNode(1, same)));
            ListNode l2 = new ListNode(4, new ListNode(1, same));
            Assertions.assertEquals(same, f.apply(l1, l2));
        }
        {
            ListNode same = new ListNode(2, new ListNode(4));
            ListNode l1 = new ListNode(0, new ListNode(9, new ListNode(1, same)));
            ListNode l2 = new ListNode(3, same);
            Assertions.assertEquals(same, f.apply(l1, l2));
        }
        {
            ListNode l1 = new ListNode(2, new ListNode(6, new ListNode(4)));
            ListNode l2 = new ListNode(1, new ListNode(5));
            Assertions.assertEquals(null, f.apply(l1, l2));
        }
    }

}
