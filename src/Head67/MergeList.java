package Head67;

public class MergeList {
	public static ListNode Merge(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		else if (list2 == null)
			return list1;
		ListNode head;
		if (list1.val < list2.val) {
			head = list1;
			list1 = list1.next;
		} else {
			head = list2;
			list2 = list2.next;
		}
		ListNode cur = head;
		//也可把head放在循环内赋值，如果head==null 就把当前赋值
		while (list1 != null && list2 != null) {
				if (list1.val < list2.val) {
					cur.next = list1;
					list1 = list1.next;
					cur=cur.next;

				} else {
					cur.next = list2;
					list2 = list2.next;
					cur=cur.next;

				}
		}
		if (list1 == null) {
			cur.next = list2;
//			list2 = list2.next;
//			cur=cur.next;
			//直接全部挂上去，不需要一个个挂
		} else if (list2 == null) {
			cur.next = list1;
//			list1 = list1.next;
//			cur=cur.next;
		}
		return head;
	}
	public static ListNode MergeReturn(ListNode list1, ListNode list2) {//递归版本
		if(list1==null) return list2;
		else if(list2==null) return list1;
//		return list1.val<list2.val?MergeReturn(list1.next,list2):MergeReturn(list1,list2.next);
		if(list1.val<list2.val){
			list1.next = MergeReturn(list1.next,list2);
			return list1;
		}
		else {
			list2.next = MergeReturn(list1,list2.next);

			return list2;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(2);		
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(6);
		n1.next=n2;
		n2.next=n3;
		n4.next=n5;
		n5.next=n6;
		ListNode n = MergeReturn(n1, n4);
		while(n!=null){
			System.out.println(n.val);
			n=n.next;
		}
	}

}
