package learn.题目.剑指offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author DongYunxiang
 * @create 2019-12-25
 **/
@SuppressWarnings("NonAsciiCharacters")
public class Of24反转链表 {

    /**
     * 从头到尾遍历链表, 修改节点指向
     */
    @Deprecated
    public ListNode ReverseList_(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode l=null,m = head,r;
        while(m!=null){
            r = m.next;
            m.next = l;
            l = m;
            m = r;
        }
        return l;
    }

    /**
     * 头插法
     */
    public ListNode ReverseList(ListNode head) {
        ListNode root = new ListNode(-1);
        while(head!=null){
            ListNode tmp = head.next;
            head.next = root.next;
            root.next = head;
            head = tmp;
        }
        return root.next;
    }

    /**
     * 递归实现
     */
    public ListNode reverseList(ListNode head){
        if(head==null||head.next==null) return head;
        ListNode next = head.next;
        head.next = null;
        ListNode result = reverseList(next);
        next.next = head;
        return result;
    }


    @Test
    public void testlist(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        {
            n1.next=n2;
            n2.next=n3;
            n3.next=null;
            ListNode result = reverseList(n1);
            Assertions.assertArrayEquals(new Integer[]{3, 2, 1}, ListNode.getList(result).toArray());
        }
        {
            n1.next=n2;
            n2.next=n3;
            n3.next=n4;
            n4.next=null;
            ListNode result = reverseList(n1);
            Assertions.assertArrayEquals(new Integer[]{4, 3, 2, 1}, ListNode.getList(result).toArray());
        }
    }
}
