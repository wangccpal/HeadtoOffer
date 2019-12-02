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
    List<Integer> nodes = new LinkedList<>();
    public int maxPathSum(TreeNode root) {
        midRetrieve(root);
        int max = Integer.MIN_VALUE;
        boolean cons = false;
        for (int i : nodes) {
            if (cons) {
                if (i > 0 && max > 0) {
                    max += i;
                } else if (i > 0 && max <= 0){
                    max = i;
                } else {
                    cons = false;
                }
            } else {
                if (i > max) max = i;
                cons = true;
            }
        }
        return max;
    }

    private void midRetrieve(TreeNode root) {
        if (root != null) {
            midRetrieve(root.left);
            nodes.add(root.val);
            midRetrieve(root.right);
        }
    }
}
