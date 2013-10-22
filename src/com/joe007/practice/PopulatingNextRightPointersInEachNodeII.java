package com.joe007.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/22 : 13:28
 * End   Time : 2013/10/22 : 14:00
 *
 */
public class PopulatingNextRightPointersInEachNodeII {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        
        if(null == root){
            return;
        }

//        if (root.left != null) {
//            root.left.next = root.right;
//        }
//        if (root.next != null && root.right != null) {
//            root.right.next = root.next.left;
//        }
//        connect(root.left);
//        connect(root.right);
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            ArrayList<TreeLinkNode> tempList = getAllElement(queue);
            for(int i = 0; i < tempList.size(); i++){
                TreeLinkNode ithNode = tempList.get(i);
                if(i < tempList.size() - 1){
                    ithNode.next = tempList.get(i+1);
                }
                if(ithNode.left != null){
                    queue.add(ithNode.left);
                }
                if(ithNode.right != null){
                    queue.add(ithNode.right);
                }
            }
        }
    }

    private ArrayList<TreeLinkNode> getAllElement(Queue<TreeLinkNode> queue) {
        ArrayList<TreeLinkNode>  resultList = new ArrayList<TreeLinkNode>();
        while(!queue.isEmpty()){
            TreeLinkNode element = queue.poll();
            resultList.add(element);
        }
        return resultList;
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNodeII instance = new PopulatingNextRightPointersInEachNodeII();
        TreeLinkNode root = instance.new TreeLinkNode(1);
        TreeLinkNode twoNode = instance.new TreeLinkNode(2);
        TreeLinkNode threeNode = instance.new TreeLinkNode(3);
        root.left = twoNode;
        root.right = threeNode;

        instance.connect(root);

    }

}
