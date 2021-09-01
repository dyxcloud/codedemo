package learn.题目.剑指offer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author DongYunxiang
 * @create 2019-12-09
 **/
@SuppressWarnings("NonAsciiCharacters")
public class Of6从尾到头打印链表 {

    public ArrayList<Integer> reversePrint0(ListNode listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (listNode != null) {
            ret.addAll(reversePrint0(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    //会修改原链表
    public ArrayList<Integer> reversePrint1(ListNode head) {
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

    public int[] reversePrint(ListNode head) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if(head!=null){
            while(head!=null){
                stack.push(head.val);
                head = head.next;
            }
        }
        int[] arr = new int[stack.size()];
        return stack.stream().mapToInt(Integer::intValue).toArray();
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
            int[] result = reversePrint(n1);
            Assertions.assertTrue(Arrays.equals(result,new int[]{4, 3, 2, 1}));
        }
        {
            int[] result = reversePrint(n4);
            Assertions.assertTrue(Arrays.equals(result,new int[]{4}));
        }
        {
            int[] result = reversePrint(null);
            Assertions.assertEquals(0, result.length);
        }
    }

}


