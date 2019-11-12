package leetcode.tree;

import leetcode.data.TreeNode;

/**
 * 根据后序遍历和中序遍历重构二叉树
 *  [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * @author Wangchenge
 * @date 2019-11-12
 **/
public class LT106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length , 0, postorder.length);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int inorderL, int inorderR, int postorderL, int postorderR) {
        if (inorderR == inorderL) {
            return null;
        }
        final int x = postorder[postorderR - 1];
        TreeNode root = new TreeNode(x);
        if (inorderR - inorderL == 1){
            return root;
        }
        final int mid = find(inorder, x, inorderL, inorderR);
        int leftLen = mid - inorderL;
        root.left = helper(inorder, postorder, inorderL, mid, postorderL, leftLen + postorderL);
        root.right = helper(inorder, postorder, mid + 1, inorderR, leftLen + postorderL, postorderR - 1);
        return root;
    }

    private int find(int[] inorder, int x, int inorderL, int inorderR) {
        for (int i = inorderL; i < inorderR; i++) {
            if (inorder[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] in = {9, 3, 15, 20, 7};
        int[] post = {9, 15, 7, 20, 3};
        final TreeNode node = new LT106().buildTree(in, post);
        System.out.println(node);
    }
}
