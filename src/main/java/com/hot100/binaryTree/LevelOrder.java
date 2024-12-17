package com.hot100.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2024.12.15 二叉树的层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/?envType=study-plan-v2&envId=top-100-liked
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root != null) {
            stack.offer(root);
        }
        while(!stack.isEmpty()) {
            int n  = stack.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                TreeNode node = stack.poll();
                if (node.left != null) {
                    stack.offer(node.left);
                }
                if (node.right != null) {
                    stack.offer(node.right);
                }
                list.add(node.val);
            }
            res.add(list);
        }
        return res;
    }
}
