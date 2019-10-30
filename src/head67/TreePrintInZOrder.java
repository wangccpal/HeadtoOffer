package head67;

import java.util.ArrayList;
import java.util.Stack;

public class TreePrintInZOrder {

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		Print(treeNode);
	}
    public static ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer> > rst = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> list  = new ArrayList<>();
    	Stack<TreeNode> stack1 = new Stack<>();
    	Stack<TreeNode> stack2 = new Stack<>();
    	stack1.push(pRoot);
    	while(!stack1.isEmpty() && stack2.isEmpty()) {
    		while(!stack1.isEmpty()) {
    			TreeNode pop = stack1.pop();
    			if(pop == null) continue;
    			list.add(pop.val);
    			System.out.println(pop.val);
    			stack2.push(pop.left);
    			stack2.push(pop.right);
    		}
    		if(!rst.isEmpty()) rst.add((ArrayList<Integer>) list.clone());
    		list.clear();
    		while(!stack2.isEmpty()) {
    			TreeNode pop = stack2.pop();
    			if(pop == null) continue;

    			list.add(pop.val);
    			System.out.println(pop.val);
    			stack1.push(pop.right);
    			stack1.push(pop.left);
    		}
    		if(!rst.isEmpty()) rst.add((ArrayList<Integer>) list.clone());
    		list.clear();
    	}
		return rst;
    	
    }

}
