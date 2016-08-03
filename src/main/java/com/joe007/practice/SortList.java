package com.joe007.practice;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * @author Joe
 * 
 */
public class SortList {
    
    static int callTime = 0;

    class ListNode {
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

    public ListNode sortList(ListNode head) {
        // sort(head, null);
        // System.out.println("final head:" + head);

        ListNode tempNode = head;
        int count = 0;
        while (tempNode != null) {
            count++;
            tempNode = tempNode.next;
        }
        head = mergeSort(head, count);
        return head;
    }

    private ListNode mergeSort(ListNode head, int count) {
//        callTime++;
        if (head == null || head.next == null || count == 1) {
            return head;
        }

        int leftCount = count / 2;
        int rightCount = count - count / 2;
        int i = 1;
        ListNode leftTail = head;
        while (i++ < leftCount) {
            leftTail = leftTail.next;
        }
        ListNode originalRightHead = leftTail.next;
        leftTail.next = null;

        ListNode leftHead = mergeSort(head, leftCount);
        ListNode rightHead = mergeSort(originalRightHead, rightCount);

        // merge left and right
        ListNode lp = leftHead;
        ListNode rp = rightHead;
        
        ListNode sortedNode = null;
        if(lp.val < rp.val){
            sortedNode = lp;
            lp = lp.next;
        } else {
            sortedNode = rp;
            rp = rp.next;
        }

//        ListNode sortedNode = new ListNode(0);

        ListNode h = sortedNode;

        while (lp != null && rp != null) {
            if (lp.val < rp.val) {
                sortedNode.next = lp;
                lp = lp.next;
            } else {
                sortedNode.next = rp;
                rp = rp.next;
            }
            sortedNode = sortedNode.next;
        }
        if (lp == null) {
            sortedNode.next = rp;
        } else {
            sortedNode.next = lp;
        }
        return h;
    }

    private void sort(ListNode head, ListNode tailNode) {
        if (head == null || head.next == null) {
            return;
        }

        if (head == tailNode) {
            return;
        }

        int value = head.val;
        ListNode k = head;

        ListNode currentNode = head.next;

        while (currentNode != tailNode) {
            if (currentNode.val < value) {
                k = k.next;
                if (k != currentNode) {
                    int temp = k.val;
                    k.val = currentNode.val;
                    currentNode.val = temp;
                }
            }
            currentNode = currentNode.next;
        }

        head.val = k.val;
        k.val = value;

        sort(head, k);
        sort(k.next, null);

    }

    public static void main(String[] args) {
        SortList instance = new SortList();
        int[] a = {3, 5, 4, 5, 6, 8,9,8};
//        int[] a = {1, 2, 3,4, 9,3};
        ListNode head = instance.new ListNode(0);
        ListNode parentNode = head;
        
        for(int i : a){
            ListNode iNode = instance.new ListNode(i);
            parentNode.next = iNode;
            parentNode = parentNode.next;
        }
        System.out.println("before sorted:" + head.next);

        ListNode newHead = instance.sortList(head.next);
        System.out.println("after sorted:" + newHead);
        System.out.println("callTime:" + callTime);

    }

}
