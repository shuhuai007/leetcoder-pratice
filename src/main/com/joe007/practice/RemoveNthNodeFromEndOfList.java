package com.joe007.practice;

import java.util.ArrayList;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/21 : 14:07
 * End   Time : 2013/10/21
 *
 */
public class RemoveNthNodeFromEndOfList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder(String.valueOf(val));
            if(next != null){
                sb.append("-->").append(next);
            }
            return sb.toString();
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n <= 0){
            return head;
        }
        ArrayList<ListNode> tempList = new ArrayList<ListNode>();
        ListNode flagNode = new ListNode(0);
        flagNode.next = head;
        ListNode previousNode = flagNode;
        tempList.add(previousNode);
        while(flagNode.next != null){
            tempList.add(flagNode.next);
            flagNode = flagNode.next;
        }
        tempList.add(flagNode.next);
        int size = tempList.size();
//        System.out.println("size: " + size);
        int removePos = size - n - 1;
//        System.out.println("removePos: " + removePos);
//        System.out.println("removePosNode-1: " + tempList.get(removePos - 1));
//        System.out.println("removePosNode+1: " + tempList.get(removePos + 1));
        tempList.get(removePos - 1).next = tempList.get(removePos + 1);
//        System.out.println("removePosNode-1: " + tempList.get(removePos - 1));
//        System.out.println("head: " + head);
        return previousNode.next;
    }

    public static void main(String[] args) {

        RemoveNthNodeFromEndOfList instance = new RemoveNthNodeFromEndOfList();
        ListNode head = instance.new ListNode(1);
//        ListNode secondNode = instance.new ListNode(2);
//        ListNode thirdNode = instance.new ListNode(3);
//        head.next = secondNode;
//        secondNode.next = thirdNode;
        System.out.println(instance.removeNthFromEnd(head, 1));

    }

}
