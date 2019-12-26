package learn.题目.剑指offer;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.*;

/**
 * @author DongYunxiang
 * @create 2019-12-09
 **/
@SuppressWarnings("NonAsciiCharacters")
public class n05从尾到头打印链表 {

    public ArrayList<Integer> printListFromTailToHead0(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead0(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    //会修改原链表
    public ArrayList<Integer> printListFromTailToHead1(ListNode head) {
        // 头插法构建逆序链表
        ListNode root = new ListNode(-1);
        while (head != null) {
            ListNode tmp = head.next;
            head.next = root.next;
            root.next = head;
            head = tmp;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        root = root.next;
        while (root != null) {
            ret.add(root.val);
            root = root.next;
        }
        return ret;
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if(listNode!=null){
            while(listNode!=null){
                stack.push(listNode.val);
                listNode = listNode.next;
            }
        }
        return new ArrayList<>(stack);
    }


    @Test
    public void test(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        {
            ArrayList<Integer> result = printListFromTailToHead(n1);
            List<Integer> integers = Arrays.asList(4, 3, 2, 1);
            TestCase.assertTrue(Arrays.equals(result.toArray(),integers.toArray()));
        }
        {
            ArrayList<Integer> result = printListFromTailToHead(n4);
            List<Integer> integers = Collections.singletonList(4);
            TestCase.assertTrue(Arrays.equals(result.toArray(),integers.toArray()));
        }
        {
            ArrayList<Integer> result = printListFromTailToHead(null);
            TestCase.assertTrue(result.isEmpty());
        }
    }

}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next.val +
                '}';
    }
}
