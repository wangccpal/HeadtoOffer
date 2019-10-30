package leetcode;

import leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all full tree
 *
 * @author Wangchenge
 * @date 2018-10-18
 **/
public class LeetCode894 {
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<TreeNode>();
//        if(N / 2 == 0) return res;
        if(N == 1) res.add(new TreeNode(0));
        N = N - 1;
        for(int i = 1;i < N; i+=2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode894().allPossibleFBT(7));
    }
}


