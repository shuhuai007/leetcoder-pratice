package com.joe007.practice;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/23 : 19:40
 * End   Time : 2013/10/23 : 19:54
 *
 */
public class MinimumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        
        public String toString() {
            return super.toString();
        }
    }
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        } else if(root.left != null && root.right != null){
            return (1 + Math.min(minDepth(root.left), minDepth(root.right)));
        } else if (root.left != null && root.right == null){
            return (1 + minDepth(root.left));
        } else {
            return (1 + minDepth(root.right));
        }
    }
    
    public static void main(String[] args) {
        MinimumDepthOfBinaryTree instance = new MinimumDepthOfBinaryTree();
        System.out.println();

    }

}
