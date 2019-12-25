package learn.题目.剑指offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author DongYunxiang
 * @create 2019-12-25
 **/
@SuppressWarnings("NonAsciiCharacters")
public class n16反转链表 {

    public ListNode ReverseList(ListNode head) {
        ListNode l,m,r;
        l = head;
        m = l.next;
        r = m.next;

        r.next = m;
        m.next = l;
        l.next = null;
        return r;
    }

    public List<Integer> toArray(ListNode head){
        List<Integer> list= new LinkedList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        return list;
    }

    @Test
    public void testlist(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next=n2;
        n2.next=n3;
        n3.next=null;
        ListNode result = ReverseList(n1);
        Assert.assertArrayEquals(new Integer[]{3, 2, 1}, toArray(result).toArray());
    }
}
