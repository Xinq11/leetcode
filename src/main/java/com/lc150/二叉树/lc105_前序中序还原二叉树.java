package com.lc150.二叉树;

import java.util.HashMap;

public class lc105_前序中序还原二叉树 {
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

    /**
     * 前序：中左右
     * 中序：左中右
     * 后序：左右中
     */
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode dfs(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr)
            return null;
        int rootIndex = map.get(preorder[pl]);
        // 拆分左右子树，要用中序遍历来截断前序遍历的左右子树范围
        TreeNode rootNode = new TreeNode(preorder[pl]);
        rootNode.left = dfs(preorder, inorder, pl + 1, rootIndex - il + pl, il, rootIndex - 1);
        rootNode.right = dfs(preorder, inorder, rootIndex - il + pl + 1, pr, rootIndex + 1, ir);
        return rootNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

    }
}
