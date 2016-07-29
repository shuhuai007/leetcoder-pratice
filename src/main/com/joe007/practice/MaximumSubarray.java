package com.joe007.practice;

import java.util.Arrays;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2, 1, -3, 4, -1, 2, 1, -5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * click to show more practice.
 * 
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/10 : 16:13
 * End   Time : 2013/10/10 : 19:06
 *
 */
public class MaximumSubarray {

    public int maxSubArray(int[] A) {
        if(null == A || A.length == 0){
            return 0;
        }
        if(A.length == 1){
            return A[0];
        }

        int currentSum = 0;
        int maxSum = 0;
        for (int i = 0; i < A.length; i++) {
            int currentVal = A[i];

            if(0 == i ){
                if(currentVal < 0){
                    currentSum = 0;
                    maxSum = 0;
                } else {
                    currentSum = currentVal;
                    maxSum = currentVal;
                }
            } else {
                // i > 0
                int previousVal = A[i-1];
                if(currentVal >= 0 && previousVal < 0 && currentSum < 0){
                    currentSum = 0;
                } else if(currentVal < 0 && previousVal >= 0 && currentSum > maxSum){
                    maxSum = currentSum;
                }
                currentSum += currentVal;
            }
            
        }

        int finalSum = Math.max(maxSum, currentSum);
        if(finalSum == 0){
            int maxValue = Integer.MIN_VALUE;
            for(int i : A){
                if(i >= maxValue){
                    maxValue = i;
                }
            }
            finalSum = maxValue;
        } 
    
        return finalSum;
    }

    public static void main(String[] args) {

        MaximumSubarray instance = new MaximumSubarray();
//        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5,4};
//        int[] A = {1,-2,3,-4};
//        int[] A = {2,2,0,-1};
//        int[] A = {3,2,-3,-1,1,-3,1,-1};
        int[] A= {-1,-2,-3};
        System.out.println(instance.maxSubArray(A));
        
    }

}
