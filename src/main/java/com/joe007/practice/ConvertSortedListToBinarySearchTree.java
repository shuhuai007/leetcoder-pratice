package com.joe007.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author zhoujie
 * Start Time : 2013/11/01 : 13:18
 * End   Time : 2013/11/01 : 13:59
 */
public class ConvertSortedListToBinarySearchTree {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

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

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }
        List<Integer> valueList = new ArrayList<Integer>();
        ListNode currentNode = head;
        while(currentNode != null){
            valueList.add(currentNode.val);
            currentNode = currentNode.next;
        }
//        System.out.println("valueList:" + valueList);
        int startIndex = 0;
        int endIndex = valueList.size() - 1;
        return sortedListToBST(valueList, startIndex, endIndex);
    }

    private TreeNode sortedListToBST(List<Integer> valueList, int startIndex, int endIndex) {
        if(startIndex == endIndex){
            return new TreeNode(valueList.get(startIndex));
        }
        
        int middleIndex = (startIndex + endIndex)/2;
//        System.out.println("middleIndex:" + middleIndex);
        TreeNode currentNode = new TreeNode(valueList.get(middleIndex));
        
        if(middleIndex > startIndex){
            // left child exists
            int leftChildStartIndex = startIndex;
            int leftChildEndIndex = middleIndex - 1;
            TreeNode leftChild = sortedListToBST(valueList, leftChildStartIndex, leftChildEndIndex);
            currentNode.left = leftChild;
        }
        // right child always exists
        int rightChildStartIndex = middleIndex + 1;
        int rightChildEndIndex = endIndex;
        TreeNode rightChild = sortedListToBST(valueList, rightChildStartIndex, rightChildEndIndex);
        currentNode.right = rightChild;
        
        return currentNode;
    }

    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree instance = new ConvertSortedListToBinarySearchTree();
        ListNode head = instance.new ListNode(1);
        ListNode head2 = instance.new ListNode(2);
        ListNode head3 = instance.new ListNode(3);
        ListNode head4 = instance.new ListNode(4);
        ListNode head5 = instance.new ListNode(5);
        head.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        System.out.println(instance.sortedListToBST(head));
        
    }

}
