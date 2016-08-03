package com.joe007.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * @author zhoujie
 * Start Time : 2013/11/08 : 10:03
 * End   Time : 2013/11/08 : 10:49
 *
 */
public class MergeKSortedLists {

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
			if (next != null) {
				sb.append("-->").append(next.toString());
			}
			return sb.toString();
		}
	}
	
	public ListNode mergeKLists(ArrayList<ListNode> lists) {

		if(lists == null || lists.size() == 0){
			return null;
		}
		
		ListNode rootNode = new ListNode(0);
		ListNode regularNode = rootNode;
		
		
		ListNode[] currentPos = new ListNode[lists.size()];
		for(int i = 0; i < lists.size(); i++){
			ListNode currentNode = lists.get(i);
			currentPos[i] = currentNode;
		}
		
		while(hasNodes(currentPos)){
			// find the min node
			Map<Integer, ListNode> minNodeMap = findMinNode(currentPos);
			int minNodeIndex = (Integer) minNodeMap.keySet().toArray()[0];
			ListNode minNode = minNodeMap.get(minNodeIndex);
			// link the min node to regularnode
			regularNode.next = minNode;
			regularNode = minNode;
			
			System.out.println("minNode:" + minNode + "; minNodeIndex:" + minNodeIndex); 
			currentPos[minNodeIndex] = minNode.next;
			minNode.next = null;
		}
		
		
		return rootNode.next;
	}

	private Map<Integer, ListNode> findMinNode(ListNode[] currentPos) {
		int minVal = Integer.MAX_VALUE;
		int minIndex = -1;
		ListNode minNode = null;
		for(int i = 0; i < currentPos.length; i++){
			if(currentPos[i] != null){
				int val = currentPos[i].val;
				if(val < minVal){
					minIndex = i;
					minVal = val;
					minNode = currentPos[i];
				}
			}
			
		}
		Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
		map.put(minIndex, minNode);
		return map;
	}

	private boolean hasNodes(ListNode[] currentPos) {
		for(ListNode node : currentPos){
			if(node != null){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		MergeKSortedLists instance = new MergeKSortedLists();
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		ListNode root1 = instance.new ListNode(1);
		lists.add(root1);
		System.out.println(instance.mergeKLists(lists));

	}

}
