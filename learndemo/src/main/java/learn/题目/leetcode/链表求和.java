package learn.题目.leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author DongYunxiang
 * @create 2020-07-07
 **/
@SuppressWarnings({"NonAsciiCharacters"})
public class 链表求和 {

    /**
     * 给定两个用链表表示的整数，每个节点包含一个数位。
     * 这些数位是反向存放的，也就是个位排在链表首部。
     * 编写函数对这两个整数求和，并用链表形式返回结果。
     * <p>
     * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
     * 输出：2 -> 1 -> 9，即912
     * <p>
     * 进阶：假设这些数位是正向存放的，请再做一遍。示例：
     * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
     * 输出：9 -> 1 -> 2，即912
     */

    @Test
    public void testfunc() {
        {
            ListNode l1 = ListNode.create(2, 4, 3);
            ListNode l2 = ListNode.create(5, 6, 4);
            Integer[] r = {7, 0, 8};
            TestCase.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbers(l1, l2)).toArray()));
        }
        {
            ListNode l1 = ListNode.create(9, 7, 8);
            ListNode l2 = ListNode.create(6, 8, 5);
            Integer[] r = {5, 6, 4, 1};
            TestCase.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbers(l1, l2)).toArray()));
        }
        {
            ListNode l1 = ListNode.create(1, 2, 3, 4, 5);
            ListNode l2 = ListNode.create(1, 2, 3, 4, 5);
            Integer[] r = {2, 4, 6, 8, 0, 1};
            TestCase.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbers(l1, l2)).toArray()));
        }
        {
            ListNode l1 = ListNode.create(1, 2, 3);
            ListNode l2 = ListNode.create(1, 2, 3, 4, 5);
            Integer[] r = {2, 4, 6, 4, 5};
            TestCase.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbers(l1, l2)).toArray()));
        }
        {
            ListNode l1 = null;
            ListNode l2 = ListNode.create(1, 2, 3, 4, 5);
            Integer[] r = {1, 2, 3, 4, 5};
            TestCase.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbers(l1, l2)).toArray()));
        }
        {
            ListNode l1 = null;
            ListNode l2 = null;
            Integer[] r = {};
            TestCase.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbers(l1, l2)).toArray()));
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        int v = l1.val + l2.val;
        if (v > 9) {
            ListNode node = new ListNode(v - 10);
            node.next = addTwoNumbers(addTwoNumbers(l1.next, new ListNode(1)), l2.next);
            return node;
        } else {
            ListNode node = new ListNode(v);
            node.next = addTwoNumbers(l1.next, l2.next);
            return node;
        }
    }


    @Test
    public void testCreate() {
        ListNode listNode = ListNode.create(1, 2, 3, 4, 5);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public static ListNode create(int... arr) {
            if (arr.length == 0) {
                return null;
            }
            ListNode next = null;
            for (int i = arr.length - 1; i >= 0; i--) {
                ListNode node = new ListNode(arr[i]);
                node.next = next;
                next = node;
            }
            return next;
        }

        public static ArrayDeque<Integer> getList(ListNode node) {
            ArrayDeque<Integer> integers = new ArrayDeque<>();
            while (node != null) {
                integers.addLast(node.val);
                node = node.next;
            }
            return integers;
        }


    }
}
