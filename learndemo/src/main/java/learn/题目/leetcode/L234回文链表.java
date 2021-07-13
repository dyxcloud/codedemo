package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * @author DongYunxiang
 * @create 2021-04-19
 **/
public class L234回文链表 {

    public boolean isPalindrome0(ListNode head) {
        if (head == null || head.next == null) return true;
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        for (int l = 0, r = arr.length - 1; l <= r; l++, r--) {
            if (!arr[l].equals(arr[r])) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // System.out.println(slow);
        ListNode dummy = new ListNode(-1);
        while (slow != null) {
            ListNode newOne = slow;
            slow = slow.next;
            ListNode tmp = dummy.next;
            dummy.next = newOne;
            newOne.next = tmp;
        }
        slow = dummy.next;
        while (head != null && slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    //方式3: 遍历链表 生成2个数字 一个正序生成一个倒序生成 看是否相等

    @Test
    public void ttt() {
        Predicate<ListNode> f = this::isPalindrome;
        {
            ListNode root = ListNode.creatList(1, 2);
            TestCase.assertEquals(false, f.test(root));
        }
        {
            ListNode root = ListNode.creatList(1, 2, 2, 1);
            TestCase.assertEquals(true, f.test(root));
        }
        {
            ListNode root = ListNode.creatList(1, 2, 3, 2, 1);
            TestCase.assertEquals(true, f.test(root));
        }
        {
            TestCase.assertEquals(true, f.test(null));
        }
    }


}
