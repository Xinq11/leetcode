package com.hot100.binaryTree;

/**
 * 2024.12.15 翻转二叉树
 * https://leetcode.cn/problems/invert-binary-tree/?envType=study-plan-v2&envId=top-100-liked
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = null, right = null;
        if (root.left != null) {
            left = invertTree(root.left);
        }
        if (root.right != null) {
            right = invertTree(root.right);
        }
        root.left = right;
        root.right = left;
        return root;
    }
}
