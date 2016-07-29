package com.joe007.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
]
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
 * 
 * Start Time : 2013/10/12 : 15:13
 * End   Time : 2013/10/12 : 15:58
 *
 */
public class BinaryTreeLevelOrderTraversalII {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> inversedResultList = new ArrayList<ArrayList<Integer>>();
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
            inversedResultList.add(rowNodeValList);

            for (TreeNode node : rowNodelList) {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        
        for(int i = inversedResultList.size() - 1; i >= 0; i--){
            resultList.add(inversedResultList.get(i));
        }

        return resultList;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII instance = new BinaryTreeLevelOrderTraversalII();
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
        
        ArrayList<ArrayList<Integer>> resultList = instance.levelOrderBottom(root);
        
        if(null == resultList){
            return;
        }
        for(ArrayList<Integer> rowList : resultList){
            System.out.println(rowList);
        }

    }

}
