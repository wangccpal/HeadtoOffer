package leetcode.tree;

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
	 * @param tree
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
	

	private static void postOrder(Node root) {
		if(root==null) return ;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");
	}

}
