package com.joe007.practice;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * Start Time : 2013/10/08 18:53
 * End   Time : 2013/10/08 19:06
 */
public class SameTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        } else if(p != null && q != null){
            if(p.val != q.val){
                // p.val != q.val
                return false;
            } else {
                // p.val == q.val
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        } else{
            return false;
        }
    }

    public static void main(String[] args) {
        SameTree instance = new SameTree();
        TreeNode p = instance.new TreeNode(10);
        TreeNode pleft = instance.new TreeNode(5);
        TreeNode pright = instance.new TreeNode(6);
        p.left = pleft;
        p.right = pright;
        
        TreeNode q = instance.new TreeNode(10);
        TreeNode qleft = instance.new TreeNode(5);
        TreeNode qright = instance.new TreeNode(6);
        q.left = qleft;
        q.right = qright;
        System.out.println(instance.isSameTree(p, q));

    }

}
