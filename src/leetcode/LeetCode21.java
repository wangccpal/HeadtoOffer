package leetcode;

/**
 * Merge Two Sorted Lists
 *
 * @author Wangchenge
 * @date 2018-10-17
 **/
public class LeetCode21 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        ListNode l2_1 = new ListNode(1);
        ListNode l2_2 = new ListNode(2);
        l2_1.next = l2_2;
        ListNode listNode = new LeetCode21().mergeTwoLists(l1, l2_1);
        System.out.println(listNode);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        else if (null == l2) return l1;
        ListNode dummy = new ListNode(0);
        ListNode rst = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                rst.next = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val){
                rst.next = l2;
                l2 = l2.next;
            } else {
                rst.next = l1;
                l1 = l1.next;//必须把l1先后移，否则rest.next=l2会影响到l1
                rst = rst.next;
                rst.next = l2;
                l2 = l2.next;
            }
            rst = rst.next;
        }
        if (null == l1) rst.next = l2;
        else if (null == l2) rst.next = l1;
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}