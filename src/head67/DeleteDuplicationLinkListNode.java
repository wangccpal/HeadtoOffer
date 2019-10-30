package head67;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class DeleteDuplicationLinkListNode {
//{1,1,2,3,3,4,5,5}
	public static void main(String[] args) {
		deleteDuplication( setupList());
	}
public static ListNode setupList() {
	Scanner sc = new Scanner(System.in);
	ListNode head = null;
	ListNode cur = null;
	while(sc.hasNext()) {
		if(head == null) {
			head = new ListNode(sc.nextInt());
			cur = head;
		}
		cur.next = new ListNode(sc.nextInt());
		cur = cur.next;
	}
	return head;
}
    public static ListNode deleteDuplication(ListNode pHead)
    {
    	HashMap<Integer,ListNode> map = new HashMap<>();
    	while(pHead!=null) {
    		ListNode node = map.get(pHead.val);
    		if(node == null) {
	    		map.put(pHead.val, pHead);
    		}else {
    			node.val = -1;
    		}
    		pHead = pHead.next;
    	}
    	pHead=null;
    	ListNode head = pHead;
    	for(Entry<Integer, ListNode> e : map.entrySet()) {
    		if(e.getValue().val==-1) continue;
    		if(pHead==null) {
    			pHead = e.getValue();
    			head = pHead;
    		}
    		else {
    			pHead.next = e.getValue();
    			pHead = pHead.next;
    			pHead.next=null;//�����������һ��������next�ģ�Ҫ��ֵnull
    		}
    	}
    	return head;
    }
}
