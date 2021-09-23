package learn.题目.leetcode;

import learn.题目.剑指offer.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

@SuppressWarnings("NonAsciiCharacters")
public class L148排序链表 {
    
    /*
    链表不适合随机访问, 所以排序时只能相邻元素交换, 即只能使用稳定的排序算法
    有:插入/冒泡/归并
    其中归并排序 时间复杂度O(nlogn) 空间复杂度o(1)
     */

    /**
     * 自顶向下归并, 递归调用, 空间复杂度O(logn)
     */
    public ListNode sortList0(ListNode head) {
        return mergeSort(head, null);
    }

    private ListNode mergeSort(ListNode head, ListNode tail) {
        if (head == null) return null;
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        //快慢指针
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast == tail) {
                break;
            } else {
                fast = fast.next;
            }
        }
        ListNode l1 = mergeSort(head, slow);
        ListNode l2 = mergeSort(slow, tail);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) return node2;
        if (node2 == null) return node1;
        ListNode root;
        if (node1.val < node2.val) {
            root = node1;
            node1 = node1.next;
        } else {
            root = node2;
            node2 = node2.next;
        }
        ListNode current = root;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                current.next = node1;
                node1 = node1.next;
            } else {
                current.next = node2;
                node2 = node2.next;
            }
            current = current.next;
        }
        if (node1 == null) {
            current.next = node2;
        } else {
            current.next = node1;
        }
        return root;
    }

    /**
     * 自底向上归并, 空间复杂度O(1)
     */
    public ListNode sortList(ListNode head) {
        
        return null;
    }
    
    @Test
    public void tt() {
        UnaryOperator<ListNode> func = this::sortList;
        {
            ListNode root = ListNode.creatList(4, 2, 1, 3);
            ListNode target = ListNode.creatList(1, 2, 3, 4);
            Assertions.assertEquals(ListNode.getList(target), ListNode.getList(func.apply(root)));
        }
        {
            ListNode root = ListNode.creatList(-1, 5, 3, 4, 0);
            ListNode target = ListNode.creatList(-1, 0, 3, 4, 5);
            Assertions.assertEquals(ListNode.getList(target), ListNode.getList(func.apply(root)));
        }
        {
            Assertions.assertNull(func.apply(null));
        }
    }
}
