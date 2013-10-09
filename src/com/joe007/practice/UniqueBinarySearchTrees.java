package com.joe007.practice;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * Start Time : 2013/10/09 : 14:40
 * End   Time : 2013/10/09 
 *
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if(0 == n){
            return 0;
        }
        if(1 == n){
            return 1;
        }
        int totalNum = 0;

        for(int i = 0; i <= n-1; i++ ){
            int leftChildNumTrees = numTrees(i);
            int rightChildNumTrees = numTrees(n-1-i);

            int temp = 0;
            if(leftChildNumTrees == 0 || rightChildNumTrees == 0){
                temp = leftChildNumTrees + rightChildNumTrees;
            } else {
                temp = leftChildNumTrees * rightChildNumTrees;
            }
            totalNum += temp;
        }

        return totalNum;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees instance = new UniqueBinarySearchTrees();
        System.out.println(instance.numTrees(4));
    }

}
