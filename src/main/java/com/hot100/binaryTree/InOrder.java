package com.hot100.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2024.12.15 二叉树中序遍历
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/?envType=study-plan-v2&envId=top-100-liked
 */
public class InOrder {

    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                res.add(p.val);
                p = p.right;
            }
        }
        return res;
    }
}
