package algorithm.sort;

import head67.ListNode;

/**
 * 递归的归并排序会使用logn的额外空间，但是自底向上的归并可以避免;
 */
public class MergeSortListNodeImpl implements SortListNode {

    @Override
    /**
     * 自顶向下
     */
    public ListNode sort(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode head = new ListNode(-1);
        head.next = node;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        ListNode node1 = sort(node);
        ListNode node2 = sort(next);
        return merge(node1, node2);
    }

    /**
     * 自底向上
     *
     * @param head
     * @return
     */
    public ListNode sort1(ListNode head) {
        if (head == null || head.next == null) return head;
        int n = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            n++;
        }
        ListNode pre = new ListNode(-1), dummy = pre;
        pre.next = head;
        ListNode cur;

        for (int i = 1; i < n; i <<= 1) {
            cur = dummy.next;
            pre = dummy;
            while (cur != null) {
                ListNode left = cur;
                ListNode right = split(left, i);
                cur = split(right, i);
                pre.next = merge(left, right);

                while (pre.next != null) {
                    pre = pre.next;
                }
            }
        }

        return dummy.next;
    }

    private ListNode merge(ListNode node, ListNode node1) {
        ListNode head = new ListNode(-1), cur = head;
        while (node != null && node1 != null) {
            if (node.val > node1.val) {
                cur.next = node1;
                node1 = node1.next;
            } else {
                cur.next = node;
                node = node.next;
            }
            cur = cur.next;
        }
        cur.next = node != null ? node : node1;
        return head.next;
    }

    /**
     * 以itv为步长分割node， node剩余长度小于itv时， 返回node
     * @param node
     * @param itv
     * @return
     */
    private ListNode split(ListNode node, int itv) {
        if (node == null) return node;
        for (int i = 1; i < itv && node.next != null; i++) {
            node = node.next;
        }
        ListNode res = node.next;
        node.next = null;
        return res;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode sort = new MergeSortListNodeImpl().sort1(n1);
        System.out.println(sort);
    }

}
