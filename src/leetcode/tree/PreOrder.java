package leetcode.tree;

import java.util.Stack;

/**
 * 二叉树的前序遍历
 * @author CC
 *
 *      1
 *     2  3
 *   4  5 6 7
 *    前序遍历是1 2 4 5 3 6 7  
 */
public class PreOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node tree = Node.test1();
		preOrder(tree);
		System.out.println();
		preOrderLoop(tree);
		System.out.println();
		preOrderLoopg(tree);
	}
	
	public static void preOrder(Node root) {
		if(root==null) return ;
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	
	/**
	 * 非递归方式，但是和中序不通用
	 * @param root
	 */
	public static void preOrderLoop(Node root) {
		if(root == null) return;
		Stack<Node> s = new Stack<>();
		s.push(root);
		while(!s.isEmpty()) {
			Node node = s.pop();
			System.out.print(node.val + " ");
			if(node.right != null) s.push(node.right);
			if(node.left != null) s.push(node.left);
		}
	}
	
	/**
	 * 与中序通用的非递归遍历
	 * @param root
	 */
	public static void preOrderLoopg(Node root) {
		if(root == null) return;
		Stack<Node> s = new Stack<>();
		while(!s.isEmpty() || root != null) {
			while(root != null) {
				System.out.print(root.val + " ");
				s.push(root);
				root = root.left;
			}
			root = s.pop().right; //这里跳过了根节点所以不会二次遍历
		}
	}
}
