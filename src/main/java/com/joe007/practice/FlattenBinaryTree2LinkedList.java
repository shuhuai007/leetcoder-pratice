package com.joe007.practice;

/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 * @author zhoujie
 * 
 * Start Time : 2013/11/05 : 21:02
 * End   Time : 2013/11/05 : 21:15
 *
 */
public class FlattenBinaryTree2LinkedList {
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
			if(right != null){
				sb.append(right);
			}
			return sb.toString();
		}
		
		
	}
	
	public void flatten(TreeNode root) {
		if(root == null || (root.left == null && root.right == null)){
			return;
		}
		
		TreeNode rootLeftChild = root.left;
		TreeNode rootRightChild = root.right;
		flatten(rootLeftChild);
		flatten(rootRightChild);

		if(rootLeftChild != null){
			TreeNode bottomChild = rootLeftChild;
			while(bottomChild.right != null){
				bottomChild = bottomChild.right;
			}
			bottomChild.right = root.right;
			root.right = root.left;
		}
		root.left = null;
	}

	public static void main(String[] args) {
		FlattenBinaryTree2LinkedList instance = new FlattenBinaryTree2LinkedList();
		TreeNode root = instance.new TreeNode(1);
		TreeNode rootLeft = instance.new TreeNode(2);
		TreeNode rootLeftLeft = instance.new TreeNode(3);
		TreeNode rootLeftRight = instance.new TreeNode(4);
		TreeNode rootRight = instance.new TreeNode(5);
		TreeNode rootRightRight = instance.new TreeNode(6);
		root.left = rootLeft;
		root.right = rootRight;
		root.left.left = rootLeftLeft;
		root.left.right = rootLeftRight;
		root.right.right = rootRightRight;
		instance.flatten(root);
		
		System.out.println(root);
	}

}
