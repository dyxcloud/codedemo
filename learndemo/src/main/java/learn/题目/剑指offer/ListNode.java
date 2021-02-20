package learn.题目.剑指offer;

import java.util.LinkedList;
import java.util.List;

public class ListNode {

    public int val;
    public ListNode next = null;
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next.val +
                '}';
    }

    public static List<Integer> getList(ListNode head){
        LinkedList<Integer> list = new LinkedList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        return list;
    }
}
