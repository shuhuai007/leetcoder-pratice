package com.joe007.practice;

import java.util.HashMap;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @author zhoujie
 * Start Time : 2013/10/31 : 09:56
 * End   Time : 2013/10/31 : 10:30
 * 
 */
public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }

        HashMap<ListNode, Integer> parentCountMap = new HashMap<ListNode, Integer>();
        ListNode currentNode = new ListNode(0);
        currentNode.next = head;

        
        while(currentNode != null){
            if(currentNode.next == null){
                return false;
            } else {
                // currentNode.next != null
                ListNode nextNode = currentNode.next;
                if(parentCountMap.containsKey(nextNode)){
                    return true;
                } else {
                    parentCountMap.put(nextNode, 1);
                }
            }
            currentNode = currentNode.next;
        }

        return false;
    }
    
//    public boolean hasCycle(ListNode head) {
//        if(head == null){
//            return false;
//        }
//
//        if(head == head.next){
//            return true;
//        }
//
//        ListNode currentNode = head;
//        while(currentNode != null){
//            ListNode nextNode = currentNode.next;
//
//            if(nextNode == currentNode){
//                return true;
//            }
//            // checkNode is between head and currentNode, head is inclusive, currentNode is exclusive.
//            ListNode checkNode = head;
//            while(checkNode != currentNode){
//                if(nextNode == checkNode){
//                    return true;
//                }
//                checkNode = checkNode.next;
//            }
////            System.out.println("------");
//            currentNode = currentNode.next;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        LinkedListCycle instance = new LinkedListCycle();
        ListNode head = instance.new ListNode(1);
        ListNode head2 = instance.new ListNode(2);
        ListNode head3 = instance.new ListNode(3);
        head.next = head2;
        head2.next = head3;
        head3.next = head3;
        System.out.println(instance.hasCycle(head));
        
        
    }

}
