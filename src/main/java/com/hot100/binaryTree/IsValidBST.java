package com.hot100.binaryTree;

/**
 * 2024.12.18 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked
 * dfs 只不过不是两边深度一起遍历，先左后右
 */
public class IsValidBST {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        boolean l = isValidBST(root.left);
        if (!l) return false;
        if (pre >= root.val) return false;
        pre = root.val;
        boolean r = isValidBST(root.right);
        if (!r) return false;
        return true;
    }
}
