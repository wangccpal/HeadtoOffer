package Head67;

import java.util.List;

/**
 * ������������ľ��� ��������������͹�������lcn��dist(n1,n2) = dist(root,n1) + dist(root,n2) -
 * 2*(root,lcn); ����=·���ĳ���=·���Ͻڵ����-1
 * 
 * @author CC
 *
 */
public class DistanceBetween2TreeNode {
	public static int dist(TreeNode head, TreeNode n1, TreeNode n2) {
		TreeNode lcn = TreeLowestComonNode.getCommonNode(head, n1, n2);
		return dist(head,n1) + dist(head,n2) - 2*dist(head,lcn);
	}

	public static int dist(TreeNode head, TreeNode n1) {// ���ڵ㵽����ڵ��·������
		return TreeLowestComonNode.getPath(head, n1) == null ? 0 : TreeLowestComonNode.getPath(head, n1).size() - 1;
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
		System.out.println(dist(n1,n9,n10));
	}

}
