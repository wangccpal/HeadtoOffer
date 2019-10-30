package leetcode;

import leetcode.data.TreeNode;

/**
 * @author Wangchenge
 * @date 2019-07-29
 *
 * Morris traversal
 * 1. 当前节点的左子树为null，输出当前节点，当前节点=右孩子
 * 2. 当前节点的左子树不为null，找到其前驱节点（中序遍历，为左子树的最右叶子）
 * 2.1 前驱节点右孩子为null，前驱节点的右孩子=当前节点, 更新当前节点为当前节点的左孩子
 * 2.2 前驱节点的右孩子不为null，输出当前节点，当前节点=右孩子，前驱节点右孩子=null（说明左子树遍历完毕，回到根节点，恢复树的结构）
 *
 * **/
public class LT99 {
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode first = null, second = null, preNew = null;
        while(cur != null) {
            if (cur.left == null) {
                if (preNew != null && preNew.val > cur.val) {
                    if (first == null) {
                        first = preNew;
                        second = cur;
                    } else {
                        second = cur;
                    }
                }
                preNew = cur;
                cur = cur.right;
            }
            else {
                TreeNode pre = cur.left;
                while(pre.right != null && pre.right.val != cur.val) pre = pre.right;
                if (pre.right == null) {
                    pre.right = cur;
                    cur = cur.left;
                } else {
                    pre.right = null;
                    if (preNew != null && preNew.val > cur.val) {
                        if (first == null) {
                            first = preNew;
                            second = cur;
                        } else {
                            second = cur;
                        }
                    }
                    preNew = cur;
                    cur = cur.right;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public static void main(String[] args) {
        final TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        new LT99().recoverTree(node);
    }
}
