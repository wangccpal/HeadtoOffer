package leetcode.tree;

import java.util.Stack;

public class InOrder {

	public static void main(String[] args) {
		Node tree = Node.test1();
		midOrder(tree);
		System.out.println();
		inOrderLoop(tree);
		System.out.println();
	}

	/**
	 * 非递归中序遍历
	 * @param tree
	 */
	private static void inOrderLoop(Node root) {
		if(root == null) return;
		Stack<Node> s= new Stack<>();
		while(!s.isEmpty() || root != null) {
			while(root != null) {
				s.push(root);
				root = root.left;
			}
			root = s.pop();
			System.out.print(root.val+" ");
			root = root.right;
		}
	}

	public static void midOrder(Node root) {
		if(root==null) return ;
		midOrder(root.left);
		System.out.print(root.val + " ");
		midOrder(root.right);
	}
}
