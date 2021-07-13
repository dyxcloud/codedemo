package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author DongYunxiang
 * @create 2021-03-02
 **/
public class L83删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        int pre = head.val;
        ListNode preNode = head;
        ListNode node = head.next;
        while (node != null) {
            if (node.val != pre) {
                preNode.next = node;
                pre = node.val;
                preNode = node;
            } else {
                preNode.next = null;
            }
            node = node.next;
        }
        return head;
    }

    @Test
    public void tt() {
        {
            ListNode root = new ListNode(1, new ListNode(1, new ListNode(2)));
            TestCase.assertEquals(Arrays.asList(1, 2), ListNode.getList(deleteDuplicates(root)));
        }
        {
            ListNode root = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
            TestCase.assertEquals(Arrays.asList(1, 2, 3), ListNode.getList(deleteDuplicates(root)));
        }
    }
}
