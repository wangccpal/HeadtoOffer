package Head67;

public class TreeTobiList {
	TreeNode last = null;//注意不可用参数传last
	
	TreeNode leftHead = null;
	TreeNode rightHead = null;
	public  TreeNode Convert(TreeNode pRootOfTree) {
		if (pRootOfTree == null)
			return null;
		convert(pRootOfTree);
		// pRootOfTree.left = convert(pRootOfTree.left);
		// pRootOfTree.right = convert(pRootOfTree.right);
		while (pRootOfTree.left != null)
			pRootOfTree = pRootOfTree.left;
		return pRootOfTree;
	}

	private  void convert(TreeNode node) {
		if (node == null)
			return;
		if (node.left != null)
			convert(node.left);//左子树
		node.left = last;//双向链表赋值
		if (last != null) {
			last.right = node;
		}
		last = node;//关键点，没遍历下一个就把last指向下一个
		if (node.right != null)
			convert(node.right);
	}
	
	public  TreeNode Convert1(TreeNode pRootOfTree) {//递归版本2
		if (pRootOfTree == null)
			return null;
		Convert1(pRootOfTree.left);
		if(rightHead==null) leftHead=rightHead=pRootOfTree;//只执行一次
		else {
			//把根节点插入到双向链表右边，rightHead向后移动
			rightHead.right=pRootOfTree;
			pRootOfTree.left=rightHead;
			rightHead=pRootOfTree;
		}
		Convert1(pRootOfTree.right);
		return leftHead;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(6);
		TreeNode n3 = new TreeNode(14);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(8);
		TreeNode n6 = new TreeNode(12);
		TreeNode n7 = new TreeNode(16);
//		TreeNode n8 = new TreeNode(8);
//		TreeNode n9 = new TreeNode(9);
//		TreeNode n10 = new TreeNode(10);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
//		n4.left = n8;
//		n4.right = n9;
//		n5.left = n10;
		n1 =new TreeTobiList().Convert1(n1);
		while(n1!=null){
		System.out.println(n1.val);
		n1=n1.right;
		}
	}

}
