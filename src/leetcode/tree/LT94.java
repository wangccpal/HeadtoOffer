package leetcode.tree;

import leetcode.data.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 中序遍历
 *
 * @author Wangchenge
 * @date 2019-11-01
 **/
public class LT94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        while(root != null) {
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            } else {
                TreeNode cur = root;
                TreeNode pre = root.left;

                while(pre.right != null && pre.right != cur) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = cur;
                    root = root.left;
                } else {
                    res.add(cur.val);
                    root = root.right;
                    pre.right = null;
                }
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal1(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        while(root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            final TreeNode node = stack.removeLast();
            res.add(node.val);
            root = node.right;
        }
        return res;
    }

        public static void main(String[] args) {
        final leetcode.data.TreeNode root = new leetcode.data.TreeNode(1);
        root.left = new leetcode.data.TreeNode(2);
        root.right = new leetcode.data.TreeNode(3);
        root.left.right = new leetcode.data.TreeNode(4);
        root.right.left = new leetcode.data.TreeNode((5));
        root.right.left.left = new leetcode.data.TreeNode(6);

//        final List<Integer> exp = Lists.newArrayList(4, 2, 6, 5, 3, 1);
        final List<Integer> res = new LT94().inorderTraversal1(root);
        System.out.println(res);
    }
}
