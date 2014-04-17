package com.joe007.practice;

public class InsertionSortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val);

            if (next != null) {
                sb.append("=>");
                sb.append(next);
            }

            return sb.toString();
        }
    }

//    public ListNode insertionSortList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        ListNode flagNode = new ListNode(0);
//        flagNode.next = head;
//
//        ListNode currentNode = head;
//        ListNode parentNode = flagNode;
//        while (currentNode != null) {
//            ListNode checkNode = flagNode;
//            while (checkNode.next != currentNode) {
//                int val = checkNode.next.val;
//                if (currentNode.val >= val) {
//                    checkNode = checkNode.next;
//                } else {
//                    parentNode.next = currentNode.next;
//                    currentNode.next = checkNode.next;
//                    checkNode.next = currentNode;
//                    break;
//                }
//            }
//
//            parentNode = currentNode;
//            currentNode = currentNode.next;
//        }
//        return flagNode.next;
//    }
    
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode resHead = null;
        ListNode resTail = null;
        while( head != null){
            ListNode curr = head;
            head = head.next;
            //if it's the first node, we can set resHead and resTail
            if( resHead == null){
                resHead = curr;
                resTail = curr;
                resTail.next = null;
            // if the current node is smaller than head, we insert before the resHead
            } else if(curr.val <= resHead.val){
                curr.next = resHead;
                resHead = curr;
            // if the current node is larger than tail, we insert after the resTail
            } else if(curr.val >= resTail.val){
                resTail.next = curr;
                resTail = curr;
                resTail.next = null;
            // otherwise, when the current node's value is in the middle, 
            // we should go through the result list to find the right insertion position
            } else {
                ListNode findPos = resHead;
                while(curr.val > findPos.next.val){
                    findPos = findPos.next;
                }
                curr.next = findPos.next;
                findPos.next = curr;  
            }
        }
        return resHead;
    }

    public static void main(String[] args) {
        InsertionSortList instance = new InsertionSortList();
        int[] a = {3, 5, 4, 5};
        ListNode head = instance.new ListNode(0);
        ListNode parentNode = head;

        for (int i : a) {
            ListNode iNode = instance.new ListNode(i);
            parentNode.next = iNode;
            parentNode = parentNode.next;
        }

        System.out.println("before sorted:" + head.next);
        head = instance.insertionSortList(head);
        System.out.println("after sorted:" + head.next);

    }

}
