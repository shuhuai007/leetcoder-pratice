package com.joe007.practice;

import com.joe007.practice.utils.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link ReverseLinkedList}.
 */
public class ReversLinkedListTest {
    private ReverseLinkedList instance = new ReverseLinkedList();

    @Test
    public void reverseListWithNullListTest() {
        ListNode reversedList = instance.reverseList(null);
        Assert.assertNull(reversedList);
    }
    @Test
    public void reverseListTest() {
        ListNode head = new ListNode(1);
        ListNode reversedList = instance.reverseList(head);
        Assert.assertEquals(reversedList.val, head.val);

        ListNode sec = new ListNode(2);
        head.next = sec;
        reversedList = instance.reverseList(head);

        Assert.assertEquals(reversedList.val, sec.val);

    }
}
