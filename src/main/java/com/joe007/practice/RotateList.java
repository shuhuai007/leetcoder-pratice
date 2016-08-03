package com.joe007.practice;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
 * @author zhoujie
 * Start Time : 2013/11/12 : 13:26
 * End   Time : 2013/11/12 : 14:00
 *
 */
public class RotateList {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
		@Override
		public String toString(){
			StringBuilder sb = new StringBuilder(String.valueOf(val));
			if(next != null){
				sb.append("-->");
				sb.append(next);
			}
			return sb.toString();
		}
	}
	
	public ListNode rotateRight(ListNode head, int n) {
		if (n <= 0 || head == null || head.next == null) {
			return head;
		}
		
		int count = 1;
		ListNode currentNode = head;
		while(currentNode.next != null){
			count++;
			currentNode = currentNode.next;
		}
		if(n >= count){
			n = n%count;
		}
		
		ListNode rootNode = new ListNode(0);
		rootNode.next = head;
		ListNode previousNode = rootNode;
		int leftCount = 0;
		while(previousNode.next != null){
			previousNode = previousNode.next;
			leftCount++;
			if(leftCount == count - n){
				break;
			}
		}
		
		currentNode.next = rootNode.next;
		rootNode.next = previousNode.next;
		previousNode.next = null;
		return rootNode.next;
	}

	public static void main(String[] args) {
		RotateList instance = new RotateList();
		ListNode head = instance.new ListNode(1);
		ListNode head2 = instance.new ListNode(2);
		ListNode head3 = instance.new ListNode(3);
		ListNode head4 = instance.new ListNode(4);
		ListNode head5 = instance.new ListNode(5);
		head.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		int n = 2;
		System.out.println("before rotate:" + head);
		System.out.println(instance.rotateRight(head, n));
	}

}
