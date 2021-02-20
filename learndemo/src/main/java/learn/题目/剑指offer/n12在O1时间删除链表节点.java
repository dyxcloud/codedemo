package learn.题目.剑指offer;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static learn.题目.剑指offer.ListNode.getList;

/**
 * @author DongYunxiang
 * @create 2019-12-162222222222
 **/
@SuppressWarnings("NonAsciiCharacters")
public class n12在O1时间删除链表节点 {

    public ListNode deleteNode(ListNode head, ListNode tobeDelete) {
        ListNode next = tobeDelete.next;
        if (next != null) {
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        } else if (head == tobeDelete) {
            return null;
        } else {
            ListNode node = head;
            while (node.next != null) {
                if (node.next == tobeDelete) node.next = null;
                else node = node.next;
            }
        }
        return head;
    }
    @Test
    public void testdelete(){
        {
            ListNode n1 = new ListNode(1);
            ListNode n2 = new ListNode(2);
            ListNode n3 = new ListNode(3);
            ListNode n4 = new ListNode(4);
            n1.next=n2;
            n2.next=n3;
            n3.next=n4;
            n4.next=null;
            List<Integer> result = getList(deleteNode(n1,n2));
            List<Integer> integers = Arrays.asList(1,3,4);
            TestCase.assertTrue(Arrays.equals(result.toArray(),integers.toArray()));
        }
        {
            ListNode n1 = new ListNode(1);
            ListNode n2 = new ListNode(2);
            ListNode n3 = new ListNode(3);
            ListNode n4 = new ListNode(4);
            n1.next=n2;
            n2.next=n3;
            n3.next=n4;
            n4.next=null;
            List<Integer> result = getList(deleteNode(n1,n1));
            List<Integer> integers = Arrays.asList(2,3,4);
            TestCase.assertTrue(Arrays.equals(result.toArray(),integers.toArray()));
        }
        {
            ListNode n1 = new ListNode(1);
            ListNode n2 = new ListNode(2);
            ListNode n3 = new ListNode(3);
            ListNode n4 = new ListNode(4);
            n1.next=n2;
            n2.next=n3;
            n3.next=n4;
            n4.next=null;
            List<Integer> result = getList(deleteNode(n1,n4));
            List<Integer> integers = Arrays.asList(1,2,3);
            TestCase.assertTrue(Arrays.equals(result.toArray(),integers.toArray()));
        }
        {
            ListNode n1 = new ListNode(1);
            List<Integer> result = getList(deleteNode(n1,n1));
            TestCase.assertTrue(result.size()==0);
        }
    }
}
