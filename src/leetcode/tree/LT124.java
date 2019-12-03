package leetcode.tree;

import leetcode.data.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 寻找二叉树中的最长路径和
 * @author Wangchenge
 * @date 2019-12-02
 **/
public class LT124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return max;
    }

    private int maxPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //如果是负的可以让left直接为0
        int left = maxPath(root.left);
        int right = maxPath(root.right);
        if (left > max) max = left;
        if (right > max) max = right;
        int sum = left + root.val + right;
        if (sum > max) max = sum;
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(new LT124().maxPathSum(root));
    }
}
