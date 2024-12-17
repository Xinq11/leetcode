package com.hot100.binaryTree;

/**
 * 2024.12.15 将有序数组转为二叉搜索树
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/?envType=study-plan-v2&envId=top-100-liked
 */
public class ToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);

    }
    // 把 nums[left] 到 nums[right-1] 转成平衡二叉搜索树
    private TreeNode dfs(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int m = (left + right) >>> 1;
        return new TreeNode(nums[m], dfs(nums, left, m), dfs(nums, m + 1, right));
    }
}
