package com.joe007.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
 * @author zhoujie
 * Start Time : 2013/10/30 : 09:52
 * End   Time : 2013/10/30 : 10:32
 * 
 */
public class BinaryTreeZigzagLevelOrderTraversal {

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
            if(left!= null){
                sb.append(",");
                sb.append(left);
            }
            if(right != null){
                sb.append(",");
                sb.append(right);
            }
            return sb.toString();
        }
    }
    
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return resultList;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int direct = -1; // -1:right 1: left
        
        while(!queue.isEmpty()){
            ArrayList<TreeNode> tempList = new ArrayList<TreeNode>();
            while(!queue.isEmpty()){
                TreeNode tempNode = queue.poll();
                tempList.add(tempNode);
            }
            
            ArrayList<Integer> valueList = new ArrayList<Integer>(tempList.size());
            for(int index = 0; index < tempList.size(); index++){
                TreeNode currentNode = tempList.get(index);
                int currentVal = currentNode.val;
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
                if(direct > 0){
                    // left
                    valueList.add(0, currentVal);
                } else {
                    // right
                    valueList.add(currentVal);
                }
            }
            resultList.add(valueList);
            direct = -direct;
        }
        
        return resultList;
    }
    
    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal instance = new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode root = instance.new TreeNode(3);
        TreeNode rootLeft = instance.new TreeNode(9);
        TreeNode rootRight = instance.new TreeNode(20);
        TreeNode rootRightLeft = instance.new TreeNode(15);
        TreeNode rootRightRight = instance.new TreeNode(7);
        
        root.left = rootLeft;
        root.right = rootRight;
        root.right.left = rootRightLeft;
        root.right.right = rootRightRight;
        
//        System.out.println("root:" + root);
        
        System.out.println(instance.zigzagLevelOrder(root));
        

    }

}
