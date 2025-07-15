package com.lc150.二叉树;

public class lc236_最近公共祖先 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;
        // 左边
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        // 右边
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if (leftNode != null && rightNode != null) {
            return root;
        } else if (leftNode != null) {
            return leftNode;
        } else {
            return rightNode;
        }
    }
}
