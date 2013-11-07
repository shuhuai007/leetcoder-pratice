package com.joe007.practice;

import java.util.ArrayList;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
 * @author zhoujie
 * Start Time : 2013/11/07 : 10:27
 * End   Time : 2013/11/07 : 10:34
 *
 */
public class BinaryTreePreorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> resultList = new ArrayList<Integer>();
		if(root == null){
			return resultList;
		}
		
		resultList.add(root.val);
		if(root.left != null){
			ArrayList<Integer> leftChild = preorderTraversal(root.left);
			resultList.addAll(leftChild);
		}
		if(root.right != null){
			ArrayList<Integer> rightChild = preorderTraversal(root.right);
			resultList.addAll(rightChild);
		}
		return resultList;
	}

	public static void main(String[] args) {
		BinaryTreePreorderTraversal instance = new BinaryTreePreorderTraversal();
		TreeNode root = instance.new TreeNode(1);
		TreeNode rootRight = instance.new TreeNode(2);
		TreeNode rootRightLeft = instance.new TreeNode(3);
		root.right = rootRight;
		root.right.left = rootRightLeft;
		System.out.println(instance.preorderTraversal(root));
	}

}
