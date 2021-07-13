package learn.题目.leetcode;

import learn.题目.剑指offer.ListNode;

public class L237删除链表中的节点 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
