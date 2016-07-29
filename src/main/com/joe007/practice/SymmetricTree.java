package com.joe007.practice;

/**
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 * 
    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

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
 * The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
 * 
 * Start Time : 2013/10/09 : 16:25
 * Endt  Time : 2013/10/09 : 16:51
 *
 */
public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if((root == null) || isLeaf(root)){
            return true;
        }

        if(root.left != null && root.right != null){
            return isSymmetric(root.left, root.right);
        }
        return false;
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        } else if(left != null && right != null){
            return (left.val == right.val) && isSymmetric(left.left, right.right) &&  isSymmetric(left.right, right.left);
        } else {
            return false;
        }
    }
    
    private boolean isLeaf(TreeNode node){
        return (node.left == null && node.right == null);
    }

    public static void main(String[] args) {
        SymmetricTree instance = new SymmetricTree();

        TreeNode root = instance.new TreeNode(10);
        System.out.println(instance.isSymmetric(root));

    }

}
