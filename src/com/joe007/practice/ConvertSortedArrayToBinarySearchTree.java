package com.joe007.practice;

import java.util.Arrays;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/10 : 15:44
 * End   Time : 2013/10/10 : 16:10
 *
 */
public class ConvertSortedArrayToBinarySearchTree {

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
            if(left != null){
                sb.append(left.toString());
            }
            sb.append(val);
            if(right != null){
                sb.append(right.toString());
            }
            return sb.toString();
        }
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if( null == num || num.length == 0){
            return null;
        }

        if(num.length == 1){
            return new TreeNode(num[0]);
        }

        int beginIndex = 0;
        int endIndex = num.length - 1;
        int middleIndex = (beginIndex + endIndex)/2;
        TreeNode leftChild = null;
        TreeNode rightChild = null;
        TreeNode currentNode = new TreeNode(num[middleIndex]);
        if(middleIndex > beginIndex){
            // copy num[0...middleIndex-1]
            int[] leftNum = Arrays.copyOf(num, middleIndex);
            leftChild = sortedArrayToBST(leftNum);
        }
        if(middleIndex < endIndex){
            // copy num[middleIndex+1...len-1]
            int[] rightNum = Arrays.copyOfRange(num, middleIndex+1, endIndex+1);
            rightChild = sortedArrayToBST(rightNum);
        }
        currentNode.left = leftChild;
        currentNode.right = rightChild;
        return currentNode;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree instance = new ConvertSortedArrayToBinarySearchTree();

        int[] testArr = {3,5,8};
        System.out.println(instance.sortedArrayToBST(testArr));
    }

}
