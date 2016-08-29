package com.joe007.practice;

import org.junit.Test;

import static com.joe007.practice.DeleteNodeLinkedList.*;
import static org.junit.Assert.*;

/**
 * Created by jiezhou on 8/23/16.
 */
public class DeleteNodeLinkedListTest {
    private DeleteNodeLinkedList instance = new DeleteNodeLinkedList();

    @Test
    public void deleteNodeTest() {
        DeleteNodeLinkedList.ListNode head = new DeleteNodeLinkedList.ListNode(1);
        DeleteNodeLinkedList.ListNode second = new DeleteNodeLinkedList.ListNode(2);
        DeleteNodeLinkedList.ListNode third = new DeleteNodeLinkedList.ListNode(3);
        DeleteNodeLinkedList.ListNode four = new DeleteNodeLinkedList.ListNode(4);
        head.next = second;
        second.next = third;
        third.next = four;

        instance.deleteNode(third);
    }


}