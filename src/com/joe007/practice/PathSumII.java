package com.joe007.practice;

import com.joe007.practice.utils.BinaryTree;
import com.joe007.practice.utils.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Question describe:
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
   For example:
   Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 * @ time spent:
 *        start: 2013/09/27 14:31
 *          end: 2013/09/27 15:24
 *        
 */
public class PathSumII {

    public static final int THRESHOLD_SUM = 22;
    public static void main(String[] args) {
        int sum =  0;
        // construct the binary tree
        BinaryTree<Integer> intTree = constructTree();

        // traverse the tree
        List<TreeNode> leafNodeList = new ArrayList<TreeNode>();
        traverseTree(intTree.root(), sum, leafNodeList);

        // print results
        printAnswerArrays(intTree, leafNodeList);
    }

    private static void printAnswerArrays(BinaryTree<Integer> intTree, List<TreeNode> leafNodeList) {
        for(TreeNode leaf : leafNodeList){
            TreeNode currentNode = leaf;
            List<Integer> inverseList = new ArrayList<Integer>();
            while(currentNode.hasParent()){
                inverseList.add((Integer)currentNode.getValue());
                currentNode = currentNode.getParent();
            }

            System.out.print("[" + intTree.root() + ",");
            for(int index = inverseList.size() - 1; index >= 0; index--  ){
                System.out.print(inverseList.get(index));
                if(index != 0){
                    System.out.print(",");
                } else {
                    System.out.print("]");
                }
            }
            System.out.println("");
        }
    }

    private static void traverseTree(TreeNode currentNode, int sum, List<TreeNode> leafNodeList) {
        if(null == currentNode){
            return;
        }
        if(sum > THRESHOLD_SUM || sum < 0){
            return;
        }

        int currentValue = (Integer)currentNode.getValue();
        sum += currentValue;
        if(THRESHOLD_SUM == sum && currentNode.isLeaf()){
            leafNodeList.add(currentNode);
        }
        if(currentNode.hasLeaf()){
            traverseTree(currentNode.getLeafChild(), sum, leafNodeList);
        }
        if(currentNode.hasRight()){
            traverseTree(currentNode.getRightChild(), sum, leafNodeList);
        }
    }

    private static BinaryTree<Integer> constructTree() {
        BinaryTree<Integer> intTree = new BinaryTree(5);
        BinaryTree.TreeNode rootNode = intTree.root();
        // 2nd floor
        BinaryTree.TreeNode node4 = intTree.addNode(intTree.root(), 4, true);
        BinaryTree.TreeNode node8 = intTree.addNode(intTree.root(), 8, false);
        // 3ird floor
        BinaryTree.TreeNode node11 = intTree.addNode(node4, 11, true);
        BinaryTree.TreeNode node13 = intTree.addNode(node8, 13, true);
        BinaryTree.TreeNode node3_4 = intTree.addNode(node8, 4, false);
        // 4th floor
        BinaryTree.TreeNode node7 = intTree.addNode(node11, 7, true);
        BinaryTree.TreeNode node2 = intTree.addNode(node11, 2, false);
        BinaryTree.TreeNode node4_5 = intTree.addNode(node3_4, 5, true);
        BinaryTree.TreeNode node1 = intTree.addNode(node3_4, 1, false);
        return intTree;
    }

}
