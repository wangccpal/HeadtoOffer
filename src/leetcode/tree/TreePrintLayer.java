package leetcode.tree;

import leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by CC on 2017/3/24.
 */
public class TreePrintLayer {
    public ArrayList<Integer>  PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode currNode= q.poll();

            if(currNode.left!=null) q.offer(currNode.left);
            if(currNode.right!=null) q.offer(currNode.right);
            list.add(currNode.val);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        n1.left=n2;
        n1.right=n3;
        System.out.println(new TreePrintLayer().PrintFromTopToBottom(n1));

    }

}