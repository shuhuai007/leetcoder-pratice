package com.joe007.practice;

import java.util.Arrays;

/**
 * Median of Two Sorted Arrays
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Start Time : 2013/09/29 16:33
 * End   Time : 
 *
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int A[], int B[]) {
        int finalMedianLeft = 0;
//        int finalMedianRight = 0;
//        double finalMedian = 0;
        int m = A.length;
        int n = B.length;
        int totalCount = m + n;
        int totalLeftMargin = 0;
        if(totalCount%2 == 0){
            // even num
            totalLeftMargin = totalCount/2;
        } else {
            // odd num
            totalLeftMargin = (totalCount - 1)/2;
        }
        System.out.println("totalLeftMargin:" + totalLeftMargin);
        int medianIndexA = m / 2;
        int valueA = 0;
        int medianIndexB = 0;
        int valueB = 0;
        int beforeValueA = Integer.MIN_VALUE;
        int beforeValueB = Integer.MIN_VALUE; 
        while(true){
//            System.out.println("medianIndexA:" + medianIndexA);
            valueA = A[medianIndexA];
            medianIndexB = totalLeftMargin - medianIndexA;
            valueB = B[medianIndexB];
            if(medianIndexA > 0){
                beforeValueA = A[medianIndexA - 1];
            }
            if(medianIndexB > 0){
                beforeValueB = B[medianIndexB - 1];
            }
            
//            System.out.println("valueA:" + valueA);
//            System.out.println("valueB:" + valueB);

            if(valueA < beforeValueB || valueB < beforeValueA){
                if((m - medianIndexA - 1) == 0){
                    break;
                }
//                System.out.println("befor medianIndexA:" + medianIndexA);
//                System.out.println("..." + Math.ceil((m - medianIndexA - 1)/2.0d));
                medianIndexA = (int) (medianIndexA + Math.ceil((m - medianIndexA - 1)/2.0d));
//                System.out.println("after medianIndexA:" + medianIndexA);
            } else {
                break;
            }
        }

        if(((m - medianIndexA + 1) == 0) && (valueA < beforeValueB)){
            finalMedianLeft = B[totalLeftMargin - m];
        } else {
//            System.out.println("valueA:" + valueA);
//            System.out.println("valueB:" + valueB);
            finalMedianLeft = Math.min(valueA, valueB);
//            finalMedianRight = Math.max(valueA, valueB);
        }
        
        
        
        
        return finalMedianLeft;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays instance = new MedianOfTwoSortedArrays();
        int[] testArr1 = {1,3,4,10,11};
        int[] testArr2 = {5,7,8,9};
        System.out.println(instance.findMedianSortedArrays(testArr1, testArr2));

//        System.out.println(Math.ceil(0.5));
    }

}
