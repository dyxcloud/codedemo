package learn.题目.leetcode;

import junit.framework.TestCase;
import learn.题目.剑指offer.ListNode;
import learn.题目.剑指offer.Of24反转链表;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;

/**
 * @author DongYunxiang
 * @create 2021-04-19
 **/
public class L206反转链表 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    @Test
    public void ttt() {
        Of24反转链表 o = new Of24反转链表();
        Function<ListNode, ListNode> f = o::reverseList;
        Function<ListNode, ListNode> f1 = o::ReverseList_;
        Function<ListNode, ListNode> f2 = o::ReverseList;
        {
            ListNode root = ListNode.creatList(1, 2, 3, 4, 5);
            TestCase.assertEquals(Arrays.asList(5, 4, 3, 2, 1), ListNode.getList(f.apply(root)));
        }
        {
            ListNode root = ListNode.creatList(1);
            TestCase.assertEquals(Arrays.asList(1), ListNode.getList(f.apply(root)));
        }
        {
            TestCase.assertEquals(null, f.apply(null));
        }
    }
}
