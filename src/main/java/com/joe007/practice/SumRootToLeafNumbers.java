package com.joe007.practice;

import java.util.ArrayList;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
An example is the root-to-leaf path 1->2->3 which represents the number 123.
Find the total sum of all root-to-leaf numbers.
For example,
    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Return the sum = 12 + 13 = 25.
 * @author zhoujie
 * 
 * Start Time : 2013/10/24 : 09:45
 * End   Time : 2013/10/24 : 10:34
 *
 */
public class SumRootToLeafNumbers {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        ArrayList<String> resultList = new ArrayList<String>();
        traverseTree(root, "", resultList);

        int sum = 0;
        for(String sb : resultList){
            int num = Integer.valueOf(sb);
            sum += num;
        }
        return sum;
    }

    private void traverseTree(TreeNode root, String sb, ArrayList<String> resultList) {
        if(root == null){
            return;
        }

        sb += root.val;
        if(root.left == null && root.right == null){
            resultList.add(sb);
        }
        if(root.left != null){
            traverseTree(root.left, sb, resultList);
        }
        if(root.right != null){
            traverseTree(root.right, sb, resultList);
        }
    }


    public static void main(String[] args) {
        SumRootToLeafNumbers instance = new SumRootToLeafNumbers();
        
        TreeNode root = instance.new TreeNode(10);
        TreeNode rootLeft = instance.new TreeNode(11);
        TreeNode rootRight = instance.new TreeNode(12);
        root.left = rootLeft;
        root.right = rootRight;

        System.out.println(instance.sumNumbers(root));

    }

}
