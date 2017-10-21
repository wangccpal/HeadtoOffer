package com.company.Tree;

public class Node {
	int val;
	Node left;
	Node right;
	
	/**
     *      1
	 *     2  3
	 *   4  5 6 7
	 *    前序遍历是1 2 4 5 3 6 7  
	 *    中序遍历是4 2 5 1 6 3 7
	 *    后序遍历是4 5 2 6 7 3 1
	 * @return
	 */
	public static Node test1() {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		
		return head;
	}
	
	public Node(int val) {
		super();
		this.val = val;
	}
}
