package Head67;
/**
 * public class TreeNode { int val = 0; TreeNode left = null; TreeNode right =
 * null;
 * 
 * public TreeNode(int val) { this.val = val;
 * 
 * }
 * 
 * }
 */
public class HasSubtree {
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if (root1 == null || root2 == null)
			return false;
		if (root1.val == root2.val) {
			if (isEqual(root1, root2))
				return true;
		}
		return (HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2));

	}

	public boolean isEqual(TreeNode root1, TreeNode root2) {
		if (root2 == null)
			return true;
		else if (root1 == null)
			return false;
		// if(root1==null && root2!=null ) return false;//Ê÷1±È2¶Ì
		// else if(root2 == null) return true;
		if (root1.val != root2.val)
			return false;
		else
			return isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
	}
    public static void Mirror(TreeNode root) {
        if(root!=null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        Mirror(root.left);
        Mirror(root.right);
        
    }
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(8);
		Mirror(n1);

	}
}