package head67;
/**输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
则重建二叉树并返回。
*/
public class ReConstructBinaryTree {

	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		int lenp = pre.length;
		int leni = in.length;
		TreeNode root = reConstructBinaryTree(pre,0,lenp-1 , in, 0,leni-1);
		return root;
	}

	public static TreeNode reConstructBinaryTree(int[] pre, int startPre,int endPre, int[] in, int startIn,int endIn) {
		// 找到在pre中第n个位置在in中的下标，设置为根节点，再找到左孩子和又孩子
		if(startPre>endPre || startIn>endIn) return null;
		TreeNode root = new TreeNode(pre[startPre]);
		int i = startIn;
		while(i<=endIn){
			if(in[i]==pre[startPre]) break;
			i++;
		}
		root.left = reConstructBinaryTree(pre,startPre+1 ,startPre+i-startIn ,in,startIn,i-1);
		root.right = reConstructBinaryTree(pre, startPre+i-startIn+1,endPre,in,i+1,endIn);
		return root;

	}

	public static void preOrder(TreeNode root){
		if(root==null) return;
		System.out.println(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void main(String[] args) {
//		int [] pre = {1,2,4,7,3,5,6,8};
//		int [] in = {4,7,2,1,5,3,8,6};
//		TreeNode root = reConstructBinaryTree(pre,in);

		int [] pre = {3,9,20,15,17};
		int [] in = {9,3,15,20,17};
		TreeNode root = buildTree(in,pre);
		preOrder(root);
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return bt(preorder, 0, preorder.length, inorder, 0, inorder.length);
	}

	/**
	 * 这里写反了。。所以调用的时候反过来；有坑的地方是pos是数组重的位置还是相对起点的偏移量。
	 * @param pre
	 * @param pl
	 * @param pr
	 * @param in
	 * @param il
	 * @param ir
	 * @return
	 */
	static TreeNode bt(int[] pre, int pl, int pr, int[] in, int il, int ir) {
		if(pr <= pl) return null;
		int mid = in[il];
		int pos = 0;
		for(int i = pl; i < pr; i++) {
			if(pre[i] == mid) pos = i;
		}
		TreeNode root = new TreeNode(mid);
		root.left = bt(pre, pl, pos, in , il + 1, il + 1 + pos - pl);
		root.right = bt(pre, pos + 1, pr, in , pos + 1 + il - pl, ir);
		return root;
	}

}
