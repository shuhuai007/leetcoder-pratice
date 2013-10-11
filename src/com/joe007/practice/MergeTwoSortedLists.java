package com.joe007.practice;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * @author zhoujie
 *
 * Start Time : 2013/10/11 : 10:10
 * End   Time : 2013/10/11 : 10:55
 */
public class MergeTwoSortedLists {

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
                sb.append("-->").append(next.toString());
            }
            return sb.toString();
        }

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        } else if(list1 != null && list2 == null) {
            return list1;
        } else if(list1 == null && list2 != null){
            return list2;
        }

        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode p3 = new ListNode(0);

        ListNode currentNode = p3;

        while(p1 != null && p2 != null){
            ListNode minValNode = null;
            if(p1.val <= p2.val){
                minValNode = p1;
                p1 = p1.next;
            } else {
                minValNode = p2;
                p2 = p2.next;
            }
            if(currentNode.next != minValNode){
                currentNode.next = minValNode;
            }
            currentNode = minValNode;
        }

        if(p1 == null){
            currentNode.next = p2;
        }
        if(p2 == null){
            currentNode.next = p1;
        }

        return p3.next;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists instance = new MergeTwoSortedLists();
        
        ListNode list1 = instance.new ListNode(10);
        ListNode list2 = instance.new ListNode(11);
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);
        System.out.println(instance.mergeTwoLists(list1, null));

    }

}
