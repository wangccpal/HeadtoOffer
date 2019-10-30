package head67;
import java.util.Stack;

public class reverseTreeOrder {

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
		// reverse(n1);
		reverseWithoutNull(n1);
	}

	public static void reverse(TreeNode head) {
		Stack<TreeNode> stack1 = new Stack();
		Stack<TreeNode> stack2 = new Stack();
		System.out.println(head.val);
		stack1.push(head.left);
		stack1.push(head.right);
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			while (!stack1.empty()) {
				try {
					TreeNode n = stack1.pop();
					System.out.println(n.val);

					stack2.push(n.right);
					stack2.push(n.left);
				} catch (NullPointerException e) {
					System.out.println("null");
				}
			}
			while (!stack2.empty()) {
				try {
					TreeNode n = stack2.pop();
					System.out.println(n.val);

					stack1.push(n.left);
					stack1.push(n.right);
				} catch (NullPointerException e) {
					System.out.println("null");
				}
			}
		}
	}

	public static void reverseWithoutNull(TreeNode head) {
		Stack<TreeNode> stack1 = new Stack();
		Stack<TreeNode> stack2 = new Stack();
		System.out.println(head.val);
		stack1.push(head.left);
		stack1.push(head.right);
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			while (!stack1.empty()) {
				TreeNode n = stack1.pop();
				if (n == null)
					continue;
				else {
					System.out.println(n.val);
					stack2.push(n.right);
					stack2.push(n.left);
				}
			}

			while (!stack2.empty()) {
				TreeNode n = stack2.pop();
				if (n == null)
					continue;
				else {
					System.out.println(n.val);
					stack1.push(n.left);
					stack1.push(n.right);
				}
			}
		}
	}
}
