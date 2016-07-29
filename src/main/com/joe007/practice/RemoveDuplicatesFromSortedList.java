package com.joe007.practice;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * @author zhoujie
 * 
 * Start Time : 2013/10/09 17:03
 * End   Time : 2013/10/09 17:30
 *
 */
public class RemoveDuplicatesFromSortedList {

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
        ListNode currentNode = head;
        ListNode grandpaNode = head;
        while(currentNode != null){
            if(currentNode.val != grandpaNode.val){
                grandpaNode.next = currentNode;
                grandpaNode = currentNode;
            }
            currentNode = currentNode.next;
        }

//        System.out.println("grandpaNode.next== null: " + (grandpaNode.next== null));
        if(grandpaNode.next != null){
            grandpaNode.next = null;
        }
        return head;
    }

    
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList instance = new RemoveDuplicatesFromSortedList();
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
