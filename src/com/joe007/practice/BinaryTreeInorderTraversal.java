package com.joe007.practice;

import java.util.ArrayList;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

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
 * @author zhoujie
 * 
 * Start Time : 2013/10/11 : 19:44
 * End   Time : 2013/10/11 : 19:54
 *
 */
public class BinaryTreeInorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        recursiveTraversal(root, resultList);
        return resultList;
    }

    private void recursiveTraversal(TreeNode root, ArrayList<Integer> resultList) {
        if(null == root){
            return;
        }
        recursiveTraversal(root.left, resultList);
        resultList.add(root.val);
        recursiveTraversal(root.right, resultList);
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal instance = new BinaryTreeInorderTraversal();
        TreeNode root = instance.new TreeNode(1);
        TreeNode rootRight = instance.new TreeNode(2);
        TreeNode rootRightLeft = instance.new TreeNode(3);

        root.right = rootRight;
        rootRight.left = rootRightLeft;

        ArrayList<Integer> valueList = instance.inorderTraversal(root);
        for(int item : valueList){
            System.out.print(item + " ");
        }

    }

}
