package algorithm.sort;

import head67.ListNode;

public class QuickSortListNodeImpl implements SortListNode{
    @Override
    public ListNode sort(ListNode node) {
        return sort(node, null);
    }

    private ListNode sort(ListNode l, ListNode r) {
        if (l == r || l.next == null || l.next == r) return l;
        ListNode less = new ListNode(-1), lHead = less;
        ListNode i = l.next, large = l;
        // 这里不能使用partition函数，因为会丢失头结点
        while(i != null) {
            if (i.val < l.val) {
                less.next = i;
                less = less.next;
            } else {
                large.next = i;
                large = large.next;
            }
            i = i.next;
        }
        //这里注意要把右边断链，否则会死循环，把l变为中点
        large.next = null;
        less.next = l;

        lHead = sort(lHead.next, l);
        l.next = sort(l.next, r);
        return lHead;
    }

    private ListNode partition(ListNode l, ListNode r) {
        if (l.next == null || l.next == r) return l;
        ListNode less = new ListNode(-1);
        ListNode i = l.next, head = l;
        while(i != null) {
            if (i.val < head.val) {
                less.next = i;
                less = less.next;
            } else {
                head.next = i;
                head = head.next;
            }
            i = i.next;
        }
        less.next = l;
        return l;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(19);
        ListNode n3 = new ListNode(14);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(-3);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(8);
        ListNode n8 = new ListNode(5);
        ListNode n9 = new ListNode(11);
        ListNode n10 = new ListNode(15);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;

        ListNode sort = new QuickSortListNodeImpl().sort(n1);
        System.out.println(sort);
    }
}
