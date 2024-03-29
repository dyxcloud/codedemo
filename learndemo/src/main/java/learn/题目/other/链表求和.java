package learn.题目.other;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    public void testfuncReverse() {
        {
            ListNode l1 = ListNode.create(3, 4, 2);
            ListNode l2 = ListNode.create(4, 6, 5);
            Integer[] r = {8, 0, 7};
            Assertions.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbersReverse(l1, l2)).toArray()));
        }
        {
            ListNode l1 = ListNode.create(8, 7, 9);
            ListNode l2 = ListNode.create(5, 8, 6);
            Integer[] r = {1, 4, 6, 5};
            Assertions.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbersReverse(l1, l2)).toArray()));
        }
        {
            ListNode l1 = ListNode.create(5, 4, 3, 2, 1);
            ListNode l2 = ListNode.create(5, 4, 3, 2, 1);
            Integer[] r = {1, 0, 8, 6, 4, 2};
            Assertions.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbersReverse(l1, l2)).toArray()));
        }
        {
            ListNode l1 = ListNode.create(3, 2, 1);
            ListNode l2 = ListNode.create(5, 4, 3, 2, 1);
            Integer[] r = {5, 4, 6, 4, 2};
            Assertions.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbersReverse(l1, l2)).toArray()));
        }
        {
            ListNode l1 = null;
            ListNode l2 = ListNode.create(5, 4, 3, 2, 1);
            Integer[] r = {5, 4, 3, 2, 1};
            Assertions.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbersReverse(l1, l2)).toArray()));
        }
        {
            ListNode l1 = null;
            ListNode l2 = null;
            Integer[] r = {};
            Assertions.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbersReverse(l1, l2)).toArray()));
        }
        {
            ListNode l1 = ListNode.create(0);
            ListNode l2 = ListNode.create(0);
            Integer[] r = {0};
            Assertions.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbersReverse(l1, l2)).toArray()));
        }
    }

    public ListNode addTwoNumbersReverse(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();
        while(l1!=null){
            stack1.offerFirst(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            stack2.offerFirst(l2.val);
            l2=l2.next;
        }
        ListNode preNode = null;
        int incr = 0;
        while(stack1.peekFirst()!=null||stack2.peekFirst()!=null||incr!=0){
            int v1 = stack1.peekFirst() == null ? 0 : stack1.pollFirst();
            int v2 = stack2.peekFirst() == null ? 0 : stack2.pollFirst();
            int r = v1 + v2;
            if (incr != 0) {
                r += incr;
                incr = 0;
            }
            ListNode listNode;
            if (r > 9) {
                listNode = new ListNode(r - 10);
                incr = 1;
            } else {
                listNode = new ListNode(r);
            }
            listNode.next=preNode;
            preNode = listNode;
        }
        return preNode;
    }

    @Test
    public void testfunc() {
        {
            ListNode l1 = ListNode.create(2, 4, 3);
            ListNode l2 = ListNode.create(5, 6, 4);
            Integer[] r = {7, 0, 8};
            Assertions.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbersLoop(l1, l2)).toArray()));
        }
        {
            ListNode l1 = ListNode.create(9, 7, 8);
            ListNode l2 = ListNode.create(6, 8, 5);
            Integer[] r = {5, 6, 4, 1};
            Assertions.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbersLoop(l1, l2)).toArray()));
        }
        {
            ListNode l1 = ListNode.create(1, 2, 3, 4, 5);
            ListNode l2 = ListNode.create(1, 2, 3, 4, 5);
            Integer[] r = {2, 4, 6, 8, 0, 1};
            Assertions.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbersLoop(l1, l2)).toArray()));
        }
        {
            ListNode l1 = ListNode.create(1, 2, 3);
            ListNode l2 = ListNode.create(1, 2, 3, 4, 5);
            Integer[] r = {2, 4, 6, 4, 5};
            Assertions.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbersLoop(l1, l2)).toArray()));
        }
        {
            ListNode l1 = null;
            ListNode l2 = ListNode.create(1, 2, 3, 4, 5);
            Integer[] r = {1, 2, 3, 4, 5};
            Assertions.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbersLoop(l1, l2)).toArray()));
        }
        {
            ListNode l1 = null;
            ListNode l2 = null;
            Integer[] r = {};
            Assertions.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbersLoop(l1, l2)).toArray()));
        }
        {
            ListNode l1 = ListNode.create(0);
            ListNode l2 = ListNode.create(0);
            Integer[] r = {0};
            Assertions.assertEquals(Arrays.toString(r), Arrays.toString(ListNode.getList(addTwoNumbersLoop(l1, l2)).toArray()));
        }
    }

    public ListNode addTwoNumbersLoop(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode result = null;
        ListNode preNode = null;
        int incr = 0;
        while (l1 != null || l2 != null || incr != 0) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int r = v1 + v2;
            if (incr != 0) {
                r += incr;
                incr = 0;
            }
            ListNode listNode;
            if (r > 9) {
                listNode = new ListNode(r - 10);
                incr = 1;
            } else {
                listNode = new ListNode(r);
            }
            if (result == null) {
                result = listNode;
            }
            if(preNode!=null){
                preNode.next = listNode;
            }
            preNode = listNode;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return result;
    }

    @SuppressWarnings("unused")
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
