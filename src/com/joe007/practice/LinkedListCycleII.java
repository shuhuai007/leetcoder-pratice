package com.joe007.practice;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null. Follow up: Can you solve it without using extra space?
 * 
 * @author zhoujie Start Time : 2013/11/01 : 18:48 End Time : 2013/11/01 :
 * 
 */
public class LinkedListCycleII {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode detectCycle(ListNode head) {
		if(head == null){
			return null;
		}
		if(head.next == null){
			return null;
		}

		ListNode currentNode = head;
		while(currentNode.next != null){
			if(currentNode.next == currentNode){
				return currentNode;
			}
			
			ListNode checkNode = head;
			while(checkNode != currentNode){
				if(checkNode == currentNode.next){
					return checkNode;
				}
				checkNode = checkNode.next;
			}
			currentNode = currentNode.next;

		}
		return null;
	}

	public static void main(String[] args) {

	}

}
