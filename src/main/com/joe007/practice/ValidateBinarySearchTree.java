package com.joe007.practice;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's
 * key. The right subtree of a node contains only nodes with keys greater than
 * the node's key. Both the left and right subtrees must also be binary search
 * trees. confused what "{1,#,2,3}" means? > read more on how binary tree is
 * serialized on OJ.
 * 
 * 
 * OJ's Binary Tree Serialization: The serialization of a binary tree follows a
 * level order traversal, where '#' signifies a path terminator where no node
 * exists below.
 * 
 * Here's an example: 1 / \ 2 3 / 4 \ 5 The above binary tree is serialized as
 * "{1,2,3,#,#,4,#,#,5}".
 * 
 * @author zhoujie
 * Start Time : 2013/11/01 : 16:10
 * End   Time : 2013/11/01 : 16:45
 * 
 */
public class ValidateBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	
    public boolean isValidBST(TreeNode root) {
    	if(root == null || isLeaf(root)){
    		return true;
    	}
        
    	TreeNode leftChild = root.left;
    	if(leftChild != null){
    		boolean leftChildFlag = isValidBST(leftChild);
    		if(!leftChildFlag){
    			return false;
    		} else {
    			// left child is valid, check the max value of left child 
    			int maxValue = getMaxValue(leftChild);
    			if(root.val <= maxValue){
    				return false;
    			}
    			
    		}
    	}
    	
    	TreeNode rightChild = root.right;
    	if(rightChild != null){
    		boolean rightChildFlag = isValidBST(rightChild);
    		if(!rightChildFlag){
    			return false;
    		} else {
    			int minValue = getMinValue(rightChild);
    			if(root.val >= minValue){
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }

	private int getMinValue(TreeNode rightChild) {
		TreeNode currentNode = rightChild;
		while(currentNode.left != null){
			currentNode = currentNode.left;
		}
		
		return currentNode.val;
	}

	private int getMaxValue(TreeNode leftChild) {
		TreeNode currentNode = leftChild;
		while(currentNode.right != null){
			currentNode = currentNode.right;
		}
		return currentNode.val;
	}

	private boolean isLeaf(TreeNode root) {
		return root.left == null && root.right == null;
	}

	public static void main(String[] args) {
		ValidateBinarySearchTree instance = new ValidateBinarySearchTree();
		TreeNode root = instance.new TreeNode(3);
		TreeNode rootLeft = instance.new TreeNode(3);
//		TreeNode rootRight = instance.new TreeNode(2);
		root.left = rootLeft;
//		root.right = rootRight;
		
		System.out.println(instance.isValidBST(root));
	}

}
