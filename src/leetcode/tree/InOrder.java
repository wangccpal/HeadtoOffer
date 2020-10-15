package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
	 * @param root
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

	/**
	 * morris， 时间换空间 O(2n)
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(Node root) {
		List<Integer> res = new ArrayList<>();
		while(root != null) {
			if(root.left == null) {
				res.add(root.val);
				root = root.right;
			} else {
				Node left = root.left;
				while(left.right != null && left.right != root) left = left.right;
				if(left.right == null) {
					left.right = root;
					root = root.left;
				} else {
					left.right = null;
					res.add(root.val);
					root = root.right;
				}
			}
		}
		return res;
	}

	/**
	 * 模版方法，缺点是每个节点入两次栈
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal1(Node root) {
		List<Integer> res = new ArrayList<>();
		LinkedList<Node> stack = new LinkedList<>();
		while(root != null || !stack.isEmpty()) {
			if(!stack.isEmpty()) root = stack.removeLast();
			if(root == null) {
				res.add(stack.removeLast().val);
			} else {
				if(root.right != null) stack.addLast(root.right);
				stack.addLast(root);
				stack.addLast(null);
				if(root.left != null) stack.addLast(root.left);
			}
		}
		return res;
	}

	public static void midOrder(Node root) {
		if(root==null) return ;
		midOrder(root.left);
		System.out.print(root.val + " ");
		midOrder(root.right);
	}
}
