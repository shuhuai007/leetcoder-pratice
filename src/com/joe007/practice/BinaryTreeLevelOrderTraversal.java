package com.joe007.practice;

import com.joe007.practice.BinaryTreeLevelOrderTraversalII.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 *
 * @author zhoujie
 * 
 * Start Time : 2013/10/14 : 18:50
 * End   Time : 2013/10/14 :
 *
 */
public class BinaryTreeLevelOrderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if(null == root){
            return resultList;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> rowNodeValList = new ArrayList<Integer>();
            ArrayList<TreeNode> rowNodelList = new ArrayList<TreeNode>();
            while(!queue.isEmpty()){
                TreeNode currentNode = queue.poll();
                rowNodelList.add(currentNode);
                rowNodeValList.add(currentNode.val);
            }
            resultList.add(rowNodeValList);

            for (TreeNode node : rowNodelList) {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal instance = new BinaryTreeLevelOrderTraversal();
        TreeNode root = instance.new TreeNode(3);
        TreeNode rootLeft = instance.new TreeNode(9);
        TreeNode rootRight = instance.new TreeNode(20);
        TreeNode rootRightLeft = instance.new TreeNode(15);
        TreeNode rootRightRight = instance.new TreeNode(7);
        
        root.left = rootLeft;
        root.right = rootRight;
        rootRight.left = rootRightLeft;
        rootRight.right = rootRightRight;
        
        System.out.println("root: " + root);
        
        ArrayList<ArrayList<Integer>> resultList = instance.levelOrder(root);
        
        if(null == resultList){
            return;
        }
        for(ArrayList<Integer> rowList : resultList){
            System.out.println(rowList);
        }
    }

}
