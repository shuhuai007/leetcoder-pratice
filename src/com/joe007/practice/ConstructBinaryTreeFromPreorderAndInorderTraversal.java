package com.joe007.practice;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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
            if (left != null) {
                sb.append(left);
            }
            if (right != null) {
                sb.append(right);
            }
            sb.append(val);

            return sb.toString();
        }
    }

    private boolean isEmpty(int[] arr) {
        if (arr == null || arr.length == 0) {
            return true;
        }
        return false;
    }

    private int search(int[] a, int element) {
        if (a == null || a.length == 0) {
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (isEmpty(preorder) || isEmpty(inorder)
                || preorder.length != inorder.length) {
            return null;
        }

        int rootVal = preorder[0];

        int rootIndex = search(inorder, rootVal);
   
        TreeNode rootNode = new TreeNode(rootVal);

        TreeNode leftNode = null;
        TreeNode rightNode = null;

        if (rootIndex > 0) {
            // left child exists
            int[] leftPreorder = Arrays.copyOfRange(preorder, 1, 1 + rootIndex);
            int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
            leftNode = buildTree(leftPreorder, leftInorder);
        }

        if (rootIndex < inorder.length - 1) {
            // right child exists
            int[] rightPreorder = Arrays.copyOfRange(preorder, 1 + rootIndex,
                    preorder.length);
            int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1,
                    inorder.length);
            rightNode = buildTree(rightPreorder, rightInorder);
        }

        rootNode.left = leftNode;
        rootNode.right = rightNode;
        return rootNode;
    }
  
    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal instance = new ConstructBinaryTreeFromPreorderAndInorderTraversal();

        int[] preorder = { 2, 1, 4, 3, 5 };
        int[] inorder = { 1, 2, 3, 4, 5 };

        // int[] preorder = {1, 2};
        // int[] inorder = {2, 1};
        TreeNode root = instance.buildTree(preorder, inorder);
        System.out.println(root);

    }

}
