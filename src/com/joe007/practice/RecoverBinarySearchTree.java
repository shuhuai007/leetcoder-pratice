package com.joe007.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * Note: A solution using O(n) space is pretty straight forward. Could you
 * devise a constant space solution? confused what "{1,#,2,3}" means? > read
 * more on how binary tree is serialized on OJ.
 * 
 * 
 * OJ's Binary Tree Serialization: The serialization of a binary tree follows a
 * level order traversal, where '#' signifies a path terminator where no node
 * exists below.
 * 
 * Here's an example: 1 / \ 2 3 / 4 \ 5 The above binary tree is serialized as
 * "{1,2,3,#,#,4,#,#,5}".
 * 
 * @author zhoujie Start Time : 2013/11/13 : 19:05 End Time : 2013/11/13 :
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
            TreeNode setinelNode = new TreeNode(Integer.MIN_VALUE);
            setinelNode.right = this;

            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(setinelNode);
            while (!stack.isEmpty()) {
                TreeNode currentNode = stack.pop();
                if (!setinelNode.equals(currentNode)) {
                    sb.append(currentNode.val);
                }
                if (currentNode.right != null) {
                    TreeNode temp = currentNode.right;
                    while (temp != null) {
                        stack.push(temp);
                        temp = temp.left;
                    }
                }

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

        List<TreeNode> wrongNodes = findWrongNode(root);
//        System.out.println("wrongNodes size:" + wrongNodes.size());
        TreeNode first = wrongNodes.get(0);
        TreeNode second = wrongNodes.get(1);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }


    private List<TreeNode> findWrongNode(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return null;
        }

        List<TreeNode> wrongNodeList = new ArrayList<TreeNode>();

        // inorder traversal
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode sentinelNode = new TreeNode(Integer.MIN_VALUE);
        sentinelNode.right = root;
        stack.push(sentinelNode);

        TreeNode previousNode = null;
        TreeNode currentNode = null;
        while (!stack.isEmpty()) {

            currentNode = stack.pop();
            if (currentNode.right != null) {
                TreeNode temp = currentNode.right;
                while (temp != null) {
                    stack.push(temp);
                    temp = temp.left;
                }
            }

            if (previousNode != null && currentNode.val < previousNode.val) {
                wrongNodeList.add(previousNode);
                wrongNodeList.add(currentNode);
            }
            previousNode = currentNode;
        }

        int wrongNodeSize = wrongNodeList.size();
        ArrayList<TreeNode> newList = new ArrayList<TreeNode>();
        if (wrongNodeSize >= 2 && wrongNodeSize <= 4) {
            newList.add(wrongNodeList.get(0));
            newList.add(wrongNodeList.get(wrongNodeList.size() - 1));
        }
        wrongNodeList.clear();
        wrongNodeList = newList;

        return wrongNodeList;
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
