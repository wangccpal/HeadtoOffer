package Head67;

public class SerializeTree {
	   static int index = -1;
	   static String[] strArray;
	    static String Serialize(TreeNode root) {
	        StringBuilder sb = new StringBuilder();
	        if(root == null) sb.append("#,");
	        else{
	        sb.append(root.val+",");
	        sb.append(Serialize(root.left));
	        sb.append(Serialize(root.right));
	        }
	        return sb.toString();
	        
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
	  }
	    static TreeNode Deserialize(String str) {
	        index++;
	        strArray= str.split(",");

	        if(index >= strArray.length || strArray[index].equals("#")  ) return null;
	        TreeNode node = new TreeNode(Integer.parseInt(strArray[index]));
	        node.left = Deserialize(str);
	        node.right = Deserialize(str);
	       return node;
	  }
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
		Deserialize(Serialize(n1));
	}

}
