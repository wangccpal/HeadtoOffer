package leetcode.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 对应LT145
 */
public class PostOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node tree = Node.test1();
		postOrder(tree);
		System.out.println();
		postOrderLoop(tree);
		System.out.println();
		postOrderLoopDoubleStack(tree);
	}

	/**
	 * 双栈法后序遍历一个二叉树
	 */
	private static void postOrderLoopDoubleStack(Node root) {
		if(root == null) return;
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		s1.push(root);
		while(!s1.isEmpty()) {
			Node n = s1.pop();
			if(n.left != null) s1.push(n.left);
			if(n.right!= null) s1.push(n.right);
			s2.push(n);
		}
		
		while(!s2.isEmpty()) {
			System.out.print(s2.pop().val + " ");
		}
	}

	/**
	 * 单栈法
	 * @param root
	 */
	private static void postOrderLoop(Node root) {
		// TODO 需要研究一下
        Stack<Node> stack = new Stack<Node>();    
        Node node = root, prev = root;    
        while (node != null || !stack.isEmpty()) {    
            while (node != null) {    
                stack.push(node);    
                node = node.left;    
            }    
            if (!stack.isEmpty()) {    
                Node temp = stack.peek().right;    
                if (temp == null || temp == prev) {    
                    node = stack.pop();    
                    System.out.print(node.val + " ");    
                    prev = node;    
                    node = null;    
                } else {    
                    node = temp;    
                }    
            }    
    
        }
	}

	/**
	 * 模版方法， 特化一下，前序换个输出顺序
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(Node root) {
		LinkedList<Integer> res = new LinkedList<>();
		LinkedList<Node> list = new LinkedList<>();
		if(root != null) list.add(root);
		while(!list.isEmpty()) {
			root = list.removeLast();
			res.addFirst(root.val);
			if(root.left != null) list.add(root.left);
			if(root.right != null) list.add(root.right);
		}
		return res;
	}
	

	private static void postOrder(Node root) {
		if(root==null) return ;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");
	}

}
