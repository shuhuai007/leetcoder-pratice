package com.joe007.practice;


/**
 * 
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/12 : 16:01
 * End   Time : 2013/10/12 : 16:46
 *
 */
public class BalancedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(String.valueOf(val));
            if(left != null){
                sb.append(",").append(left);
            }
            if(right != null){
                sb.append(",").append(right);
            }
            return sb.toString();
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (null == root || (null == root.left && null == root.right)) {
            return true;
        }

        int leftChildDepth = depth(root.left);
        int rightChildDepth = depth(root.right);

        if(Math.abs(leftChildDepth - rightChildDepth) > 1) {
            return false;
        } else {
            if(isBalanced(root.left) && isBalanced(root.right)){
                return true;
            }
            return false;
        }
    }

    private int depth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return (Math.max(depth(root.left), depth(root.right)) + 1);
    }

    public static void main(String[] args) {
        BalancedBinaryTree instance = new BalancedBinaryTree();
        TreeNode root = instance.new TreeNode(3);
        TreeNode rootLeft = instance.new TreeNode(9);
        TreeNode rootLeftLeft = instance.new TreeNode(10);
//        TreeNode rootRight = instance.new TreeNode(20);
//        TreeNode rootRightLeft = instance.new TreeNode(15);
//        TreeNode rootRightRight = instance.new TreeNode(7);
        
        root.left = rootLeft;
        rootLeft.left = rootLeftLeft;
//        root.right = rootRight;
//        rootRight.left = rootRightLeft;
//        rootRight.right = rootRightRight;
        
        System.out.println("root: " + root);
        
        System.out.println(instance.isBalanced(root));

    }

}
