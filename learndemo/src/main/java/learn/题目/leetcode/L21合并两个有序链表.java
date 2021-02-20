package learn.题目.leetcode;

import learn.题目.剑指offer.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


/**
 * @author DongYunxiang
 * @create 2021-02-20
 **/
public class L21合并两个有序链表 {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        if (l2.val < l1.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        } else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }

    @Test
    public void ttt() {
        {
            ListNode n4 = new ListNode(4);
            ListNode n2 = new ListNode(2, n4);
            ListNode n1 = new ListNode(1, n2);
            ListNode l4 = new ListNode(4);
            ListNode l3 = new ListNode(3, l4);
            ListNode l1 = new ListNode(1, l3);
            ListNode result = mergeTwoLists(n1, l1);
            List<Integer> integers = Arrays.asList(1, 1, 2, 3, 4, 4);
            Assert.assertArrayEquals(ListNode.getList(result).toArray(), integers.toArray());
        }
    }
}
