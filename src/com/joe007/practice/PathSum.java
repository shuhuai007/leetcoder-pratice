package com.joe007.practice;

import com.joe007.practice.utils.BinaryTree;
import com.joe007.practice.utils.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * @author zhoujie
 * 
 * Start Time : 2013/10/22 : 10:41
 * End   Time : 2013/10/22 : 11:15
 *
 */
public class PathSum {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        boolean flag = traverseTree(root, sum, 0);
        return flag;
    }

    private boolean traverseTree(TreeNode root, int sum, int currentSum) {
        if(root == null){
            return currentSum == sum;
        }
        currentSum += root.val;
        if(root.left == null && root.right == null){
            return  currentSum == sum;
        }
        if(root.left != null){
            if(traverseTree(root.left, sum, currentSum)){
                return true;
            }
        }
        
        if(root.right != null){
            if(traverseTree(root.right, sum, currentSum)){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        

    }

}
