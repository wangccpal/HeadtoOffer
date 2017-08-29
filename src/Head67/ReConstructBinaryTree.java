package Head67;
/**����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
���������ǰ���������������Ľ���ж������ظ������֡�
��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}��
���ؽ������������ء�
*/
public class ReConstructBinaryTree {

	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		int lenp = pre.length;
		int leni = in.length;
		TreeNode root = reConstructBinaryTree(pre,0,lenp-1 , in, 0,leni-1);
		return root;
	}

	public static TreeNode reConstructBinaryTree(int[] pre, int startPre,int endPre, int[] in, int startIn,int endIn) {
		// �ҵ���pre�е�n��λ����in�е��±꣬����Ϊ���ڵ㣬���ҵ����Ӻ��ֺ���
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
		int [] pre = {1,2,4,7,3,5,6,8};
		int [] in = {4,7,2,1,5,3,8,6};
		TreeNode root = reConstructBinaryTree(pre,in);
		preOrder(root);
	}

}
