package Head67;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * ��������������͹������ȣ������û���������ڵ㵽�ڵ��·����Ȼ���ͷ�Ƚ�����·�������һ����ȵĽڵ㼴Ϊ����
 * @author CC
 *
 */
public class TreeLowestComonNode {
	
	public static TreeNode getCommonNode(TreeNode head,TreeNode n1,TreeNode n2){
		TreeNode res = null;
		List<TreeNode> l1 = getPath( head,n1);
		List<TreeNode> l2 = getPath( head,n2);
		Iterator<TreeNode> it1 = l1.iterator();
		Iterator<TreeNode> it2 = l2.iterator();
		while(it1.hasNext()&&it2.hasNext()){
			TreeNode node1 =it1.next() ;
			TreeNode node2 = it2.next();
			if(node1.val==node2.val)   res = node1;
			else break;//���������ֱ��break�õ����
		}
		return res;
	}
	
	public static List<TreeNode> getPath(TreeNode head, TreeNode node){//���root������ڵ��·��
		List<TreeNode> list = new LinkedList<TreeNode>();
		List<TreeNode> res = new LinkedList<TreeNode>();
		back(head,node,list,res);
		return  res;

	}
	public static void back(TreeNode head,TreeNode target,List<TreeNode> list, List<TreeNode> res){
		if(head==null || !res.isEmpty()) return ;
		list.add(head);
		back(head.left,target, list, res);
		back(head.right,target, list, res);
		if( head.val== target.val)  res.addAll(list);
		else list.remove(head);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		n4.right = n9;
		n5.left = n10;
		System.out.println(getPath(n1,n10));
		System.out.println(getPath(n1,n9));
		System.out.println(getCommonNode(n1,n9,n10));
	}

}
