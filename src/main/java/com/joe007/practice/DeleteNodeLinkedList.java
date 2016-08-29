package com.joe007.practice;

/**
 * Created by jiezhou on 8/23/16.
 */
public class DeleteNodeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
