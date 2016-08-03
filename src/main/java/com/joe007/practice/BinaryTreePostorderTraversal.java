package com.joe007.practice;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class TreeNodeWrapper extends TreeNode {

        boolean rightChildVisited;

        TreeNodeWrapper(int x) {
            super(x);
            rightChildVisited = false;
        }

    }

    // public ArrayList<Integer> postorderTraversal(TreeNode root) {
    // ArrayList<Integer> resultList = new ArrayList<Integer>();
    // if(root == null){
    // return resultList;
    // }
    //
    // if (root.left != null) {
    // resultList.addAll(postorderTraversal(root.left));
    // }
    //
    // if (root.right != null) {
    // resultList.addAll(postorderTraversal(root.right));
    // }
    //
    // resultList.add(root.val);
    // return resultList;
    // }

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        if (root == null) {
            return resultList;
        }

        TreeNode sentinelNode = new TreeNode(0);
        sentinelNode.right = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(sentinelNode);

        TreeNode previousNode = null;
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.peek();

            if (currentNode.right != null && currentNode.right != previousNode) {
                TreeNode temp = currentNode.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            } else {
                stack.pop();
                if(currentNode != sentinelNode){
                    resultList.add(currentNode.val);
                }
                previousNode = currentNode;
            }

        }
        return resultList;
    }

//    private boolean isLeaf(TreeNode currentNode) {
//        return (currentNode.left == null && currentNode.right == null);
//    }

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
