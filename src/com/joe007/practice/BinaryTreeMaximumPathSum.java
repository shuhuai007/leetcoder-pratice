package com.joe007.practice;

import java.util.ArrayList;

public class BinaryTreeMaximumPathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // public int maxPathSum(TreeNode root) {
    // if(root == null){
    // return Integer.MIN_VALUE;
    // }
    //
    // if(root.left == null && root.right == null){
    // return root.val;
    // }
    //
    // int rootVal = root.val;
    // int leftMaxSum = maxPathSum(root.left);
    // int rightMaxSum = maxPathSum(root.right);
    //
    // if(rootVal >= 0){
    // if(leftMaxSum >= 0 && rightMaxSum >= 0){
    // return leftMaxSum + rootVal + rightMaxSum;
    // } else if(leftMaxSum < 0 && rightMaxSum < 0){
    // return rootVal;
    // } else {
    // int biggerMaxSum = (leftMaxSum > rightMaxSum) ? leftMaxSum : rightMaxSum;
    // return biggerMaxSum + rootVal;
    // }
    // } else {
    // // root is negative
    // int biggerMaxSum = (leftMaxSum > rightMaxSum) ? leftMaxSum : rightMaxSum;
    //
    // if(leftMaxSum >= 0 && rightMaxSum >= 0){
    // return Math.max(biggerMaxSum, leftMaxSum + rightMaxSum + rootVal);
    // } else if(leftMaxSum < 0 && rightMaxSum < 0){
    // return Math.max(biggerMaxSum, rootVal);
    // } else {
    // return biggerMaxSum;
    // }
    //
    // }
    //
    // }

    public int maxPathSum(TreeNode root) {
        ArrayList<TreeNode> maxPath = maxPath(root);
        int sum = 0;
        for (TreeNode node : maxPath) {
            sum += node.val;
        }
        return sum;
    }

    private ArrayList<TreeNode> maxPath(TreeNode root) {
        ArrayList<TreeNode> path = new ArrayList<TreeNode>();
        if (root == null) {
            return path;
        }

        if (root.left == null && root.right == null) {
            path.add(root);
            return path;
        }

        ArrayList<TreeNode> leftChildTreePath = maxPath(root.left);
        ArrayList<TreeNode> rightChildTreePath = maxPath(root.right);
        
        int rootVal = root.val;
        if(rootVal >= 0){
            
            
            
            
        } else {
            
        }

        return path;
    }

    public static void main(String[] args) {

        BinaryTreeMaximumPathSum instance = new BinaryTreeMaximumPathSum();
        TreeNode root = instance.new TreeNode(-1);
        TreeNode rootLeft = instance.new TreeNode(-2);
        TreeNode rootRight = instance.new TreeNode(-3);

        TreeNode rootLeftLeft = instance.new TreeNode(1);
        TreeNode rootLeftRight = instance.new TreeNode(3);
        TreeNode rootRightLeft = instance.new TreeNode(-2);
        TreeNode rootLeftLeftLeft = instance.new TreeNode(-1);
        root.left = rootLeft;
        root.right = rootRight;
        root.left.left = rootLeftLeft;
        root.left.right = rootLeftRight;
        root.right.left = rootRightLeft;
        root.left.left.left = rootLeftLeftLeft;

        System.out.println(instance.maxPathSum(root));

    }

}
