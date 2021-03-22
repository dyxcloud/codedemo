package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.ListNode;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class L82删除排序链表中的重复元素II {

    //解法0 第一次遍历记录重复节点 第二次遍历删除重复节点
    public ListNode deleteDuplicates0(ListNode head) {
        Queue<Integer> deps = new LinkedList<>();
        ListNode root = new ListNode(-1000, head);
        ListNode node = root.next;
        ListNode pre = root;
        while (node != null) {
            if (node.val == pre.val) {
                //第一次
                if (pre.next == node) {
                    deps.offer(node.val);
                }
                node = node.next;
            } else {
                pre = node;
                node = node.next;
            }
        }
        node = root.next;
        pre = root;
        while (node != null) {
            Integer peek = deps.peek();
            if (peek == null) {
                break;
            } else if (peek > node.val) {
                pre = node;
                node = node.next;
            } else if (peek == node.val) {
                pre.next = node.next;
                node = node.next;
            } else {
                deps.poll();
            }
        }
        return root.next;
    }

    //解法1 双指针
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = new ListNode(-1, head);
        ListNode prepre = root;
        ListNode n = prepre.next.next;
        ListNode depHead = null;
        while (n != null) {
            if (prepre.next.val == n.val) {
                n = n.next;
                depHead = prepre.next;
            } else {
                if (prepre.next.next != n) {
                    prepre.next = n;
                    depHead = null;
                    n = n.next;
                } else {
                    prepre = prepre.next;
                    n = n.next;
                }
            }
        }
        if (prepre.next == depHead) {
            prepre.next = null;
        } else {
            prepre.next.next = null;
        }
        return root.next;
    }

    //解法2 递归
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        while (head.next != null && head.val == head.next.val) {
            ListNode node = head.next;
            while (node.val == head.val) {
                if (node.next == null) {
                    return null;
                }
                node = node.next;
            }
            head = node;
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }

    interface Func {
        ListNode deleteDuplicates(ListNode head);
    }

    @Test
    public void tt() {
        Func f = this::deleteDuplicates;
        {
            ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
            TestCase.assertEquals(Arrays.asList(1, 2, 5), ListNode.getList(f.deleteDuplicates(head)));
        }
        {
            ListNode head = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
            TestCase.assertEquals(Arrays.asList(2, 3), ListNode.getList(f.deleteDuplicates(head)));
        }
        {
            ListNode head = new ListNode(1);
            TestCase.assertEquals(Collections.singletonList(1), ListNode.getList(f.deleteDuplicates(head)));
        }
        {
            TestCase.assertNull(f.deleteDuplicates(null));
        }
        {
            ListNode head = new ListNode(1, new ListNode(1));
            TestCase.assertNull(f.deleteDuplicates(head));
        }
        {
            ListNode head = new ListNode(1, new ListNode(2, new ListNode(2)));
            TestCase.assertEquals(Collections.singletonList(1), ListNode.getList(f.deleteDuplicates(head)));
        }
        {
            ListNode head = new ListNode(1, new ListNode(2));
            TestCase.assertEquals(Arrays.asList(1, 2), ListNode.getList(f.deleteDuplicates(head)));
        }
    }
}
