package com.joe007.practice;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/12 : 13:46
 * End   Time : 2013/10/12 : 14:33
 *
 */
public class SwapNodesInPairs {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            StringBuilder sb =new StringBuilder(String.valueOf(val));
            if(next != null){
                sb.append("-->").append(next);
            }

            return sb.toString();
        }
    }

    
    public ListNode swapPairs(ListNode head) {
        if(null == head || head.next == null){
            return head;
        }
        ListNode flagNode = new ListNode(0);
        flagNode.next = head;

        ListNode grandpaNode = flagNode;
        int count = 2;
        ListNode currentNode = head.next;
        while(currentNode != null){
//            System.out.println("current node :" + currentNode.val);
            if(count % 2 == 0){
                grandpaNode.next.next = currentNode.next;
                currentNode.next =  grandpaNode.next;
                grandpaNode.next = currentNode;
                currentNode = currentNode.next;
            }
//            System.out.println("--count:" + count + "   ;"+ flagNode);
            count++;
            grandpaNode = grandpaNode.next;
            currentNode = currentNode.next;
        }

        return flagNode.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs instance = new SwapNodesInPairs();
        
        ListNode head = instance.new ListNode(1);
        ListNode secondeNode = instance.new ListNode(2);
        ListNode thirdNode = instance.new ListNode(3);
        ListNode fourthNode = instance.new ListNode(4);

        head.next = secondeNode;
        secondeNode.next = thirdNode;
        thirdNode.next = fourthNode;

//        System.out.println(head);
        System.out.println(instance.swapPairs(head));

    }

}
