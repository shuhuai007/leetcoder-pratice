package com.joe007.practice;

/**
 * Invert a binary tree.

 4
 /   \
 2     7
 / \   / \
 1   3 6   9
 to
 4
 /   \
 7     2
 / \   / \
 9   6 3   1
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftSubTree = invertTree(root.left);
        TreeNode rightSubTree = invertTree(root.right);
        root.left = rightSubTree;
        root.right = leftSubTree;
        return root;
    }

}
