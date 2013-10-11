package com.joe007.practice;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/11 : 13:46
 * End   Time : 2013/10/11 : 14:01
 *
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] A) {
        if(null == A || 0 == A.length){
            return 0;
        }
        
        int newArrIndex = 0;
        int firstValIndex = 0;

        for (int i = 1; i < A.length; i++){
            if(A[i] != A[firstValIndex]){
                A[++newArrIndex] = A[i];
                firstValIndex = i;
            }
        }

        return newArrIndex + 1;
    }
    
    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray instance = new RemoveDuplicatesFromSortedArray();
        int[] A = {1,2,3,3,4,4,4,4};
        System.out.println(instance.removeDuplicates(A));
    }

}
