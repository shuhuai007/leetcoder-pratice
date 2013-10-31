package com.joe007.practice;

import java.util.ArrayList;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 * @author zhoujie
 * Start Time : 2013/10/31 : 15:21
 * End   Time : 2013/10/31 : 15:16
 */
public class UniqueBinarySearchTreesII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(String.valueOf(val));
            if(left != null){
                sb.append(",").append(left);
            }
            if(right != null){
                sb.append(",").append(right);
            }
            
            return sb.toString();
        }
    }

    public ArrayList<TreeNode> generateTrees(int n, int minValue, int maxValue) {
        ArrayList<TreeNode>  resultList = new ArrayList<TreeNode>();
        if(n == 0){
            resultList.add(null);
            return resultList;
        }
        if(n == 1){
            resultList.add(new TreeNode(minValue));
            return resultList;
        }
        
        for(int leftCount = 0; leftCount <= n - 1; leftCount++){
            int leftMinValue = minValue;
            int leftMaxValue = minValue + leftCount - 1;
            ArrayList<TreeNode> leftChildList = generateTrees(leftCount, leftMinValue, leftMaxValue);
            
            int rightMinValue = leftMaxValue + 2;
            int rightMaxValue = maxValue;
            ArrayList<TreeNode> rightChildList = generateTrees(n - 1 - leftCount, rightMinValue, rightMaxValue);
            for(TreeNode leftRoot : leftChildList){
                for(TreeNode rightRoot : rightChildList){
                    TreeNode currentNode = new TreeNode(leftMaxValue + 1);
                    if(leftRoot != null){
                        currentNode.left = leftRoot;
                    }
                    if(rightRoot != null){
                        currentNode.right = rightRoot;
                    }
                    resultList.add(currentNode);
                }
            }
        }
        
        return resultList;
    }
    
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(n, 1, n);
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII instance = new UniqueBinarySearchTreesII();

        ArrayList<TreeNode> resultList = instance.generateTrees(3);
        for(TreeNode root : resultList){
            System.out.println(root);
            
        }

    }

}
