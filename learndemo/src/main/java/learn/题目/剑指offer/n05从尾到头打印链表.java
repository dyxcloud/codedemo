package learn.题目.剑指offer;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author DongYunxiang
 * @create 2019-12-09
 **/
@SuppressWarnings("NonAsciiCharacters")
public class n05从尾到头打印链表 {

    public ArrayList<Integer> printListFromTailToHead0(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(printListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    //会修改原链表
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        // 头插法构建逆序链表
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode memo = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        // 构建 ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while (head != null) {
            ret.add(head.val);
            head = head.next;
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
            Assert.assertTrue(IntStream.rangeClosed(0,result.size()-1).allMatch(i->integers.get(i).equals(result.get(i))));
        }
        {
            ArrayList<Integer> result = printListFromTailToHead(n4);
            List<Integer> integers = Collections.singletonList(4);
            Assert.assertTrue(IntStream.rangeClosed(0,result.size()-1).allMatch(i->integers.get(i).equals(result.get(i))));
        }
        {
            ArrayList<Integer> result = printListFromTailToHead(null);
            Assert.assertTrue(result.isEmpty());
        }
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
