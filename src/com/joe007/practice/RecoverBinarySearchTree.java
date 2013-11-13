package com.joe007.practice;

import java.util.ArrayList;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
 * Start Time : 2013/11/13 : 19:05
 * End   Time : 2013/11/13 :
 *
 */
public class RecoverBinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(String.valueOf(val));
			if(left != null){
				sb.append(left);
			}
			if(right != null){
				sb.append(right);
			}
			
			return sb.toString();
		}
	}
	
	public void recoverTree(TreeNode root) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			return;
		}
		
		ArrayList<TreeNode> wrongNodes = new ArrayList<TreeNode>();
		findWrongNode(root, wrongNodes);
		
		TreeNode first = wrongNodes.get(0);
		TreeNode second = wrongNodes.get(1);
		
		int temp = first.left.val;
		first.left.val = second.left.val;
		second.left.val = temp;
	}

	private void findWrongNode(TreeNode root, ArrayList<TreeNode> wrongNodeList) {
		if(wrongNodeList.size() == 2){
			return;
		}
		
		if(root == null || (root.left == null && root.right == null)){
			return;
		}
		
		// check root
		if(root.left != null){
			TreeNode currentNode = root.left;
			while(currentNode.right != null){
				currentNode = currentNode.right;
			}
			if(root.val < currentNode.val){
				TreeNode tempNode = new TreeNode(0);
				tempNode.left = root;
				wrongNodeList.add(tempNode);
				findWrongNode(root.left, wrongNodeList);
				return ;
			}
		}
		if(root.right != null){
			TreeNode currentNode = root.right;
			while(currentNode.left != null){
				currentNode = currentNode.left;
			}
			if(root.val > currentNode.val){
				TreeNode tempNode = new TreeNode(0);
				tempNode.left = root;
				wrongNodeList.add(tempNode);
				findWrongNode(root.right, wrongNodeList);
				return ;
			}
		}
		
		// left child
		findWrongNode(root.left, wrongNodeList);
		
		// right child
		findWrongNode(root.right, wrongNodeList);
	}

	public static void main(String[] args) {
		RecoverBinarySearchTree instance = new RecoverBinarySearchTree();
		TreeNode root = instance.new TreeNode(2);
		TreeNode rootLeft = instance.new TreeNode(1);
		TreeNode rootRight = instance.new TreeNode(4);
		TreeNode rootRightLeft = instance.new TreeNode(5);
		TreeNode rootRightRight = instance.new TreeNode(3);
		root.left = rootLeft;
		root.right = rootRight;
		rootRight.left = rootRightLeft;
		rootRight.right = rootRightRight;
		
		System.out.println("Before recover:" + root);
		instance.recoverTree(root);
		System.out.println("After recover:" + root);
	}

}
