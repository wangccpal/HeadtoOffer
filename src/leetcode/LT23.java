package leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LT23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1), res = head;
        PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node :
                lists) {
            if(node!=null){
                q.add(node);
            }
        }
        while (!q.isEmpty()) {
            ListNode cur = q.poll();
            if (cur.next != null) {
                q.add(cur.next);
            }
            head.next = cur;
            head = head.next;
        }
        return res.next;
    }
}
