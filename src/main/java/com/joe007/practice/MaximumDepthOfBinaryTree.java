package com.joe007.practice;

/**
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Start Time : 2013/10/08 19:11
 * End   Time : 2013/10/08 19:18
 */
public class MaximumDepthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if(null == root){
            return 0;
        }

        return (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree instance = new MaximumDepthOfBinaryTree();
        TreeNode root = instance.new TreeNode(10);
        TreeNode left = instance.new TreeNode(1);
        TreeNode right = instance.new TreeNode(2);
        root.left = left;
        root.right = right;

        System.out.println(instance.maxDepth(root));
    }

}
