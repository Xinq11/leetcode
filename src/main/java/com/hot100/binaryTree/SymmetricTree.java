package com.hot100.binaryTree;

/**
 * 2024.12.15 对称二叉树
 * https://leetcode.cn/problems/symmetric-tree/?envType=study-plan-v2&envId=top-100-liked
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false ;
        return judge(root.left,root.right);
    }
    public boolean judge(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if ((a != null && b == null) || (a == null && b != null)){
            return false;
        }
        boolean l = false, r = false;
        l = judge(a.left, b.right);
        r = judge(a.right, b.left);
        return l && r && (a.val == b.val);
    }
}
