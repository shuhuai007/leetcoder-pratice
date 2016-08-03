package com.joe007.practice;

/**
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 * @author zhoujie
 *
 * Start Time : 2013/10/10 : 13:49
 * End   Time : 2013/10/10 : 14:22
 */
public class PopulatingNextRightPointersInEachNode {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }

    }

    public void connect(TreeLinkNode root) {
        if(null == root){
            return;
        }

        if(root.left != null && root.right != null){
            root.left.next = root.right;
            if(root.next != null){
                root.right.next = root.next.left;
            }
            connect(root.left);
            connect(root.right);
        }
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode instance = new PopulatingNextRightPointersInEachNode();
        TreeLinkNode root = instance.new TreeLinkNode(1);
        TreeLinkNode twoNode = instance.new TreeLinkNode(2);
        TreeLinkNode threeNode = instance.new TreeLinkNode(3);
        root.left = twoNode;
        root.right = threeNode;

        instance.connect(root);

    }

}
