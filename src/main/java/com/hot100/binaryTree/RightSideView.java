package com.hot100.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2024.12.19 二叉树的右视图
 * https://leetcode.cn/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-100-liked
 * 层序遍历
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            int n = stack.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = stack.poll();
                if (node.left != null) stack.offer(node.left);
                if (node.right != null) stack.offer(node.right);
                if (i == (n-1)) res.add(node.val);
            }
        }
        return res;
    }
}
