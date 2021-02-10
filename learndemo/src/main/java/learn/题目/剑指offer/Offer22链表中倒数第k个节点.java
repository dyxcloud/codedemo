package learn.题目.剑指offer;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author DongYunxiang
 * @create 2019-12-17
 **/
@SuppressWarnings("NonAsciiCharacters")
public class Offer22链表中倒数第k个节点 {

    /**
     * 使用循环数组
     */
    @Deprecated
    public ListNode getKthFromEnd_(ListNode head, int k) {
        if(k<=0) return null;
        ListNode[] tmp = new ListNode[k];
        int index = 0;
        while(head!=null){
            tmp[index] = head;
            if(index+1>=k){
                index = 0;
            }else{
                index++;
            }
            head = head.next;
        }
        //因为上一步最后一次赋值之后指针又向后移动了一位,所以需要向前移动(k-1)+1位
        for(int i=0;i<k;i++){
            if(index-1<0){
                index = k-1;
            }else{
                index--;
            }
        }
        return tmp[index];
    }

    /**
     * 使用双指针
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(k<=0) return null;
        ListNode i=head,j=null;
        while(i!=null){
            i=i.next;
            if(k>=0) k--;
            if(k==0) j=head;
            else if(k==-1) j=j.next;
        }
        return j;
    }
    @Test
    public void testFind(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=null;
        {
            ListNode listNode = getKthFromEnd(n1, 2);
            TestCase.assertEquals(n3,listNode);
        }
        {
            ListNode listNode = getKthFromEnd(n1, 1);
            TestCase.assertEquals(n4,listNode);
        }
        {
            ListNode listNode = getKthFromEnd(n1, 4);
            TestCase.assertEquals(n1,listNode);
        }
        {
            ListNode listNode = getKthFromEnd(n1, 3);
            TestCase.assertEquals(n2,listNode);
        }
        {
            ListNode listNode = getKthFromEnd(n1, 5);
            TestCase.assertNull(listNode);
        }
        {
            ListNode listNode = getKthFromEnd(n1, 0);
            TestCase.assertNull(listNode);
        }
        {
            ListNode listNode = getKthFromEnd(null, 1);
            TestCase.assertNull(listNode);
        }
    }

    /**
     * 判断链表是否形成环状结构
     */
    public boolean isLoop(ListNode head){
        ListNode slow = head,fast = head;
        while(fast!=null){
            slow = slow.next;
            if(fast.next==null){
                fast = null;
            }else{
                fast = fast.next.next;
            }
            if(fast==slow) return true;
        }
        return false;
    }
    @Test
    public void testIsLoop(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        {
            n1.next=n2;
            n2.next=n3;
            n3.next=n4;
            n4.next=n5;
            n5.next=n6;
            n6.next=n7;
            n7.next=n3;
            TestCase.assertTrue(isLoop(n1));
        }
        {
            n1.next=n2;
            n2.next=n3;
            n3.next=n4;
            n4.next=n5;
            n5.next=n6;
            n6.next=n7;
            n7.next=n1;
            TestCase.assertTrue(isLoop(n1));
        }
        {
            n1.next=n2;
            n2.next=n3;
            n3.next=n4;
            n4.next=n5;
            n5.next=n6;
            n6.next=n7;
            n7.next=null;
            TestCase.assertFalse(isLoop(n1));
        }
    }
}
