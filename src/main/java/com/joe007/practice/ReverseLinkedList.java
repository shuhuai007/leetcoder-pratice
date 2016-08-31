package com.joe007.practice;

import com.joe007.practice.utils.ListNode;

import java.util.List;

/**
 * Created by jiezhou on 8/30/16.
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode parentNode = null;
        ListNode currentNode = head;

        while (currentNode != null) {
            ListNode next = currentNode.next;
            currentNode.next = parentNode;
            parentNode = currentNode;
            currentNode = next;
        }

        return parentNode;
    }
}
