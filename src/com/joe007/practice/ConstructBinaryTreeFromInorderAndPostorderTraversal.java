package com.joe007.practice;

import java.util.Arrays;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @author zhoujie
 * Start Time : 2013/11/05 : 13:20
 * End   Time : 2013/11/05 : 14:26
 * 
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			StringBuilder sb =new StringBuilder(String.valueOf(val));
			if(left != null){
				sb.append(left);
			}
			if(right != null){
				sb.append(right);
			}
			
			return sb.toString();
		}
		
		
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0){
			return null;
		}
		
		if(inorder.length == 1){
			return new TreeNode(inorder[0]);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("inorder:");
		for(int inorderelement : inorder){
			sb.append(inorderelement);
		}
		sb.append(";postorder:");
		for(int postorderelement : postorder){
			sb.append(postorderelement);
		}
		System.out.println(sb);
		// find the root node in postorder and the rootnode index in inorder
		int rootVal = postorder[postorder.length - 1];
		TreeNode root = new TreeNode(rootVal);
		int inorderIndex = findIndexInArr(inorder, rootVal);
		System.out.println("inorderIndex:" + inorderIndex);
		int leftChildIndex = -1;
		int rightChildIndex = -1;
		TreeNode leftChild = null;
		TreeNode rightChild = null;
		if(inorderIndex < inorder.length - 1){
			// right child
			int index = 0;
			for(index = postorder.length - 2; index >= 0; index--){
				if(findIndexInArr(inorder, postorder[index]) < inorderIndex){
					break;
				}
			}
			if(index != -1){
//				System.out.println("index:" + index);
				leftChildIndex = index;
				rightChildIndex = index + 1;
				int [] rightChildInorder = Arrays.copyOfRange(inorder, inorderIndex + 1, inorder.length);
				int [] rightChildPostorder = Arrays.copyOfRange(postorder, rightChildIndex, postorder.length - 1);
				rightChild = buildTree(rightChildInorder, rightChildPostorder);
				System.out.println("rightChild:" + rightChild);

			}
			
		}
		if(inorderIndex > 0){
			// left child
			int [] lefttChildInorder = Arrays.copyOfRange(inorder, 0, inorderIndex);
			if(leftChildIndex == -1){
				leftChildIndex = inorderIndex - 1;
			}
			int [] leftChildPostorder = Arrays.copyOfRange(postorder, 0, leftChildIndex + 1);
			leftChild = buildTree(lefttChildInorder, leftChildPostorder);
			System.out.println("leftChild:" + leftChild);
		}
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}

	private int findIndexInArr(int[] inorder, int rootVal) {
		for(int index = 0; index < inorder.length; index++){
			if(rootVal == inorder[index]){
				return index;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		ConstructBinaryTreeFromInorderAndPostorderTraversal instance = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
//		int[] inorder = {3,2,4, 1, 6,5,7};
//		int[] postorder = {3,4,2,6,7,5,1};
		
		int[] inorder = {3,2,1};
		int[] postorder = {3,2,1};
		System.out.println(instance.buildTree(inorder, postorder));
		
	}

}
