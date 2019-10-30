package head67;

public class TreeSearchKthNode {

	public static void main(String[] args) {
		
	}

	private int count;
	private TreeNode rst ;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
    	core(pRoot, k);
    	return rst;
    }

	public void core(TreeNode pRoot, int k) {
		if(pRoot==null) return;
    	KthNode(pRoot.left,k);
    	count++;
    	if(count==k) rst = pRoot;
    	KthNode(pRoot.right, k);
	}
}
