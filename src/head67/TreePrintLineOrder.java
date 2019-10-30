package head67;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
//���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
//��ηֲ���һ�����⣬���ַ�ʽ��1����¼ÿ���size��ѭ�� 2���ݹ������Ӧ�Ľ����
public class TreePrintLineOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    	if(pRoot == null ) return rst;
    	ArrayList<Integer> temp = new ArrayList<>();
        Queue<TreeNode> q =  new ArrayDeque<TreeNode>(); 
        q.offer(pRoot);
        while(!q.isEmpty()) {
        	int size = q.size();
        	for (int i = 0; i < size;i++) {
	        	TreeNode node = q.poll();
	        	temp.add(node.val);
	        	if(node.left!=null) q.offer(node.left);
	        	if(node.right!=null)q.offer(node.right);
        	}
        	rst.add(temp);
        	temp = new ArrayList<>();
        }
        return rst;
    }
    
    ArrayList<ArrayList<Integer> > PrintBack(TreeNode pRoot) {
    	ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
    	coreBack(pRoot,1,rst);
    	return rst;
    }

	private void coreBack(TreeNode pRoot,int depth, ArrayList<ArrayList<Integer>> rst) {
		if(pRoot==null) return;
		if(depth>rst.size()) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			rst.add(temp);
		}
		rst.get(depth-1).add(pRoot.val);
		coreBack(pRoot.left,depth+1,rst);
		coreBack(pRoot.right,depth+1,rst);
	}
}
