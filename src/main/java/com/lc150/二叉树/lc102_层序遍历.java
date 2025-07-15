package com.lc150.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc102_层序遍历 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        queue.offer(root);
        int num = 1;
        while (!queue.isEmpty()) {
            int loopNum = 0;
            List<Integer> array = new ArrayList<Integer>();
            for (int i = 0; i < num; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    loopNum++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    loopNum++;
                }
                array.add(node.val);
            }
            num = loopNum;
            res.add(array);
        }
        return res;
    }
}
