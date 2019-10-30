package head67;
/*
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
import java.util.ArrayList;

public class FindPayh {

	    public  ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
//	        int sum=0;
	    	 ArrayList<ArrayList<Integer>> res = new ArrayList();
	    	 ArrayList<Integer> single = new ArrayList();
	    	 find(root, target, res, single);
	        return res;
	    }
		public void find(TreeNode root, int target, ArrayList<ArrayList<Integer>> res,
				ArrayList<Integer> single) {
			if(root==null) {
	        	if(target==0&&!res.contains(single))res.add((ArrayList<Integer>) single.clone());
	        	return ;
	        }
	        
//	        sum=sum+root.val;
	        single.add(root.val);
	        find(root.left,target-root.val, res, single);
//	        single.remove(Integer.valueOf(root.val));
	        find(root.right,target-root.val, res, single);
	        single.remove(Integer.valueOf(root.val));
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(5);		
		TreeNode n3 = new TreeNode(12);	
		TreeNode n4 = new TreeNode(4);	
		TreeNode n5 = new TreeNode(7);	
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		n2.right=n5;
		System.out.println(new FindPayh().FindPath(n1,22));
	}

}
