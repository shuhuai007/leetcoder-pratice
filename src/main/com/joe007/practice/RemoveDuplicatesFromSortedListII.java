package com.joe007.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 * 
 * Start Time : 2013/11/07 09:26
 * End   Time : 2013/11/07 10:10
 *
 */
public class RemoveDuplicatesFromSortedListII {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            if(next == null){
                return String.valueOf(val);
            } else {
                return String.valueOf(val) + "-->" + next.toString();
            }
        
        }

    }

    public ListNode deleteDuplicates(ListNode head) {
        if(null == head){
            return null;
        }
        Set<Integer> set = new HashSet<Integer>();
        
        ListNode currentNode = head;
        ListNode grandpaNode = head;
        while(currentNode != null){
            if(currentNode.val != grandpaNode.val){
                grandpaNode.next = currentNode;
                grandpaNode = currentNode;
            } else {
            	if(currentNode != head){
            		set.add(currentNode.val);
            	}
            }
            currentNode = currentNode.next;
        }
   
//        System.out.println("grandpaNode.next== null: " + (grandpaNode.next== null));
        if(grandpaNode.next != null){
            grandpaNode.next = null;
        }
        System.out.println(set);
        System.out.println(head);
        ListNode flagNode = new ListNode(0);
        flagNode.next = head;
        currentNode = head;
        ListNode parentNode = flagNode;
        while(currentNode != null){
        	if(set.contains(currentNode.val)){
        		parentNode.next = null;
        	} else {
        		parentNode.next = currentNode;
        		parentNode = currentNode;
        	}
        	currentNode = currentNode.next;
        }
        
        return flagNode.next;
    }

    
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII instance = new RemoveDuplicatesFromSortedListII();
        ListNode head = instance.new ListNode(1);
        ListNode node1 = instance.new ListNode(1);
        ListNode node2 = instance.new ListNode(2);
        ListNode node3 = instance.new ListNode(3);
        ListNode node33 = instance.new ListNode(3);
        
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node33;

        System.out.println(head);
        System.out.println("deleted: " + instance.deleteDuplicates(head));

    }

}
