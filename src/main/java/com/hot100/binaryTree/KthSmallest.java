package com.hot100.binaryTree;

import java.util.LinkedList;

/**
 * 2024.12.19 二叉搜索树中第k小元素
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-100-liked
 * 中序遍历
 */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        //List<Integer> list = new ArrayList<Integer>();
        while(root != null || !stack.isEmpty()){
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) break;
            //if (!stack.isEmpty()) {
            //    TreeNode node = stack.pop();
            //    list.add(node.val);
            //    root = node.right;
            //}
            root = root.right;
        }
        return root.val;
    }
}
