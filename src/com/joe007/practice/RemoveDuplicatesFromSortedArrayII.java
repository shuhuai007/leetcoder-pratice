package com.joe007.practice;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/21 : 16:10
 * End   Time : 2013/10/21 : 16:41
 *
 */
public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        if(A.length == 1 || A.length == 2){
            return A.length;
        }

        int newPos = 0;
        int duplicateCount = 0;
        for(int i = 1; i < A.length; i++){
            if(A[i-1] == A[i]){
                duplicateCount++;
                if(duplicateCount <= 1){
                    // need to insert
                    A[++newPos] = A[i];
                } else {
                    // do nothing
                }
            } else {
                // not equal, need to insert
                A[++newPos] = A[i];
                duplicateCount = 0;
            }
        }
        return newPos+1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII instance = new RemoveDuplicatesFromSortedArrayII();
        int[] A = {1,1,1,1,2,2,3};
        System.out.println(instance.removeDuplicates(A));
        for(int item : A){
            System.out.print(item + ",");
        }
    }
}
