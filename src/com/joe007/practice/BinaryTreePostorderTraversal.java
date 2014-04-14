package com.joe007.practice;

import java.util.ArrayList;

public class BinaryTreePostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        if(root == null){
            return resultList;
        }

        if (root.left != null) {
            resultList.addAll(postorderTraversal(root.left));
        }

        if (root.right != null) {
            resultList.addAll(postorderTraversal(root.right));
        }

        resultList.add(root.val);
        return resultList;
    }

    public static void main(String[] args) {

        BinaryTreePostorderTraversal instance = new BinaryTreePostorderTraversal();
        TreeNode root = instance.new TreeNode(1);
        TreeNode rootRight = instance.new TreeNode(2);
        TreeNode rootRightLeft = instance.new TreeNode(3);

        root.right = rootRight;
        rootRight.left = rootRightLeft;

        System.out.println(instance.postorderTraversal(root));

    }

}
