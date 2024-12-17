package com.hot100.binaryTree;

/**
 * 2024.12.15 最大深度
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/?envType=study-plan-v2&envId=top-100-liked
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int leftMax = 1 + maxDepth(root.left);
        int rightMax = 1 + maxDepth(root.right);
        return Math.max(leftMax, rightMax);
    }
}
