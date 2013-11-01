package com.joe007.practice;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 * @author zhoujie
 * 
 * Start Time : 2013/11/01 : 16:58
 * End   Time : 2013/11/01 :
 *
 */
public class PartitionList {
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

	public ListNode partition(ListNode head, int x) {
		if(head == null || head.next == null){
			return head;
		}
		
		ListNode previousNode = partition(head.next, x);
		head.next = previousNode;
		int val = head.val;

		if(val < x){
			// do nothing
			return head;
		} else {
			ListNode resultNode = head.next;
			// val >= x
			ListNode currentNode = head;
			while(currentNode.next != null){
				int currentVal = currentNode.next.val;
				if(currentVal >= x){
					break;
				}
				currentNode = currentNode.next;
			}
			if(currentNode != head){
				if(currentNode.next == null){
					currentNode.next = head;
					head.next = null;
				} else {
					head.next = currentNode.next;
					currentNode.next = head;
				}
				return resultNode;
			} else {
				return head;
			}
		}
	}

	public static void main(String[] args) {
		PartitionList instance = new PartitionList();
		ListNode head = instance.new ListNode(1);
		ListNode head1 = instance.new ListNode(3);
		ListNode head2 = instance.new ListNode(2);
		head.next = head1;
		head1.next = head2;

		int x = 3;
		System.out.println(instance.partition(head, x));
	}

}
