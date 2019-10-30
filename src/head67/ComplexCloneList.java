package head67;

class RandomListNode {
	int label;
	RandomListNode next = null;
	RandomListNode random = null;

	RandomListNode(int label) {
		this.label = label;
	}
}

public class ComplexCloneList {

	public RandomListNode Clone(RandomListNode pHead) {
		RandomListNode chead = new RandomListNode(pHead.label);
		RandomListNode pre = chead;
		RandomListNode res = chead;
		RandomListNode pHead2 = pHead;
		while (pHead.next != null) {//�ȸ���next
			pHead = pHead.next;
			RandomListNode clone = new RandomListNode(pHead.label);
			pre.next = clone;
			pre = pre.next;
		}
		pHead = pHead2;
		while (pHead != null) {//�ٸ���random
			pHead2 = pHead.random;
			pre = res;//��ͷ��ʼ��
			if (pHead2 != null) {//�����ǰ�ڵ�������ڵ�
				while (pre != null) {// ��clone�������ҵ���һ������Ľڵ�
					if (pre.label == pHead2.label)
						break;
					pre = pre.next;
				}
				chead.random = pre;
			}
			pHead = pHead.next;
			chead = chead.next;
		}
		return res;
	}

	public static void main(String[] args) {
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode pHead = n1;
		n1.next = n2;
		n2.next = n3;
		n1.random = n3;
		while (n1 != null) {
			System.out.println(n1.label);
			n1 = n1.next;
		}
		RandomListNode clone = new ComplexCloneList().Clone(pHead);
		while (clone != null) {
			System.out.println(clone.label);
			clone = clone.random;
		}
	}

}
