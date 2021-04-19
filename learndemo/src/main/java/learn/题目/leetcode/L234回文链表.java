package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

        return true;
    }

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
            TestCase.assertEquals(true, f.test(null));
        }
    }


}
