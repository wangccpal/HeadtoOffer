package leetcode;

import head67.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LT236 {
    List<TreeNode> l1 = new ArrayList();
    List<TreeNode> l2 = new ArrayList();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> tmp = new ArrayList();
        bp(root, p, q, tmp);
        int i = 0;
        TreeNode res = null;
        while(i < l1.size() && i < l2.size()) {
            if(l1.get(i).val == l2.get(i).val) res = l1.get(i);
            else break;
            i++;
        }
        return res;
    }

    void bp(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> tmp) {
        if(root == null) return;
        tmp.add(root);
        if(root.val == p.val) l1.addAll(tmp);
        if(root.val == q.val) l2.addAll(tmp);
        if(!l1.isEmpty() && !l2.isEmpty()) return;
        if(root.left != null) {
            bp(root.left, p, q, tmp);
            tmp.remove(root.left);
        }
        if(root.right != null) {
            bp(root.right, p, q, tmp);
            tmp.remove(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        t1.right = t2;
        TreeNode treeNode = new LT236().lowestCommonAncestor(t1, t2, t1);
        System.out.println(treeNode);
    }
}
