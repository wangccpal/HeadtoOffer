package leetcode;

/**
 * 反转链表2
 *
 * @author Wangchenge
 * @date 2019-08-01
 **/
public class LT92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null, cur = head, next = null;
        int i = 1;
        while(i++ < m) {
            pre = cur;
            cur = cur.next;
        }
        ListNode h1 = pre;
        ListNode h2 = cur;
        next = cur.next;

        while(i++ <= n) {
            pre = cur;
            cur = next;
            next = cur.next;

            cur.next = pre;
        }
        if(h1 != null) h1.next = cur;
        h2.next = next;
        return h1 != null?head:cur;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        new LT92().reverseBetween(head, 2, 4);

    }
}
