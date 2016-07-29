package com.joe007.practice;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4, return
 * 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/11/04 : 11:05 
 * End Time   : 2013/11/04 : 13:46
 * 
 */
public class ReverseLinkedListII {

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
				sb.append("-->" + next);
			}
			return sb.toString();
		}
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m == n || m <= 0 || n <= 0) {
			return head;
		}
		
		if(m > n){
			int temp = m;
			m = n;
			n = temp;
		}
//		if(n == m + 1){
//			
//			return head;
//		}
		ListNode headParent = new ListNode(0);
		headParent.next = head;
		
		// find startNode parent
		ListNode startNodeParent = new ListNode(0);
		startNodeParent.next = head;
		ListNode currentNode = head;
		int index = 1;
		while(currentNode != null && index < m-1){
			currentNode = currentNode.next;
			index++;
		}
		
		if(m != 1){
			startNodeParent = currentNode;
		}
		
		// iterate
		ListNode previousNode = startNodeParent.next;
		currentNode = startNodeParent.next.next;
		System.out.println("startNodeParent:" + startNodeParent.val);
		
		index = m + 1;
		while(currentNode != null && index <= n){
			// XXX
			System.out.println("index:" + index);
			previousNode.next = currentNode.next;
			currentNode.next = startNodeParent.next;
			startNodeParent.next = currentNode;
			
			System.out.println("---startNodeParent:" + startNodeParent);
			// previous node ,currentNode
			currentNode = previousNode.next;
			index++;
		}
		if(m == 1){
			headParent = startNodeParent;
		}
		return headParent.next;
	}

	public static void main(String[] args) {
		ReverseLinkedListII instance = new  ReverseLinkedListII();

		ListNode head = instance.new ListNode(1);
		ListNode head2 = instance.new ListNode(2);
		ListNode head3 = instance.new ListNode(3);
		ListNode head4 = instance.new ListNode(4);
		ListNode head5 = instance.new ListNode(5);
		head.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		System.out.println("original List: " + head);
		int m = 1;
		int n = 2;
		System.out.println(instance.reverseBetween(head, m, n));
	}

}
