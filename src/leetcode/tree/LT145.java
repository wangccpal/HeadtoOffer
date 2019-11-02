package leetcode.tree;

import leetcode.data.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * postorderTraversal
 * 后序遍历
 *
 * @author Wangchenge
 * @date 2019-10-25
 **/
public class LT145 {
    final LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        final TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode((5));
        root.right.left.left = new TreeNode(6);

//        final List<Integer> exp = Lists.newArrayList(4, 2, 6, 5, 3, 1);
        final List<Integer> res = new LT145().postorderTraversalNoRe(root);
        System.out.println(res);
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return null;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        list.add(root.val);
        return list;
    }

    public List<Integer> postorderTraversalNoRe(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        if (root == null) return res;
        stack.add(root);
        while (!stack.isEmpty()) {
            final TreeNode peek = stack.removeLast();
            res.addFirst(peek.val);
            if (peek.left != null) stack.addLast(peek.left);
            if (peek.right != null) stack.addLast(peek.right);
        }
        return res;
    }
}
