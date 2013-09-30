package com.joe007.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Median of Two Sorted Arrays There are two sorted arrays A and B of size m and
 * n respectively. Find the median of the two sorted arrays. The overall run
 * time complexity should be O(log (m+n)). Start Time : 2013/09/29 16:33 End
 * Time :
 * 
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int A[], int B[]) {
        int finalMedianLeft = 0;
        int finalMedianRight = 0;
        double finalMedian = 0;
        int m = A.length;
        int n = B.length;
        if (m == 0 && n == 0) {
            return 0;
        } else if (m == 0 && n != 0) {
            return getMedian(B);
        } else if (m != 0 && n == 0) {
            return getMedian(A);
        }

        int totalCount = m + n;
        int totalLeftMargin = 0;
        totalLeftMargin = getLeftMedianMargin(totalCount);
        // System.out.println("totalLeftMargin:" + totalLeftMargin);
        int medianIndexA = getLeftMedianMargin(m);
        int valueA = 0;
        int medianIndexB = 0;
        int valueB = 0;
        int beforeValueA = Integer.MIN_VALUE;
        int beforeValueB = Integer.MIN_VALUE;
        while (true) {
            
            valueA = A[medianIndexA];
            medianIndexB = totalLeftMargin - medianIndexA;
            System.out.println("medianIndexA:" + medianIndexA);
            System.out.println("medianIndexB:" + medianIndexB);
            if(medianIndexB > n - 1){
                valueB = Integer.MAX_VALUE;
            } else if (medianIndexB < 0) {
//                valueB = Integer.MAX_VALUE;
            } else {
                valueB = B[medianIndexB];
            }
            if (medianIndexA > 0) {
                beforeValueA = A[medianIndexA - 1];
            }
            if (medianIndexB > 0) {
                beforeValueB = B[medianIndexB - 1];
            }

//             System.out.println("valueA:" + valueA);
//             System.out.println("valueB:" + valueB);

            if(valueA == valueB){
                break;
            }
            if (valueA < beforeValueB || valueB < beforeValueA) {
                if ((m - medianIndexA - 1) == 0) {
                    break;
                }
                // System.out.println("befor medianIndexA:" + medianIndexA);
                // System.out.println("..." + Math.ceil((m - medianIndexA -1)/2.0d));
                if(valueA > valueB){
                    // go left
                    medianIndexA = (medianIndexA - 1)/2;
                    if(medianIndexA < 0){
                        medianIndexA = 0;
                    }
                } else if(valueA < valueB){
                    // go right
//                     System.out.println("befor medianIndexA:" + medianIndexA);
                    medianIndexA = (medianIndexA + 1 + m - 1)/2;
//                  System.out.println("after medianIndexA:" + medianIndexA);
                } else {
//                    break;
                }
//                medianIndexA = (int) (medianIndexA + Math.ceil((m - medianIndexA - 1) / 2.0d));
                // System.out.println("after medianIndexA:" + medianIndexA);
            } else {
                break;
            }

        }

//        System.out.println("m - medianIndexA + 1:" + (m - medianIndexA + 1));
//        System.out.println("valueA: " + valueA + "; beforeValueB:" + beforeValueB);
        if (((m - medianIndexA - 1) == 0) && (valueA < beforeValueB)) {
            if(totalLeftMargin - m < 0){
                finalMedianLeft = A[totalLeftMargin];
                if(totalLeftMargin + 1 > m - 1){
                    finalMedianRight = B[0];
                } else {
                    finalMedianRight = A[totalLeftMargin];
                }
            } else {
                finalMedianLeft = B[totalLeftMargin - m];
                finalMedianRight = B[totalLeftMargin - m + 1];
            }
        } else {
            // System.out.println("valueA:" + valueA);
            // System.out.println("valueB:" + valueB);
            finalMedianLeft = Math.min(valueA, valueB);
            if (valueA != valueB) {
                if(valueA > valueB){
                    int nextValueB = Integer.MAX_VALUE;
                    if(medianIndexB + 1 < n){
                        nextValueB = B[medianIndexB + 1];
                    }
                    finalMedianRight = getMedianRight(finalMedianLeft, valueA, beforeValueA, nextValueB);
                } else {
                    int nextValueA = Integer.MAX_VALUE;
                    if(medianIndexA + 1 < m){
                        nextValueA = A[medianIndexA + 1];
                    }
                    finalMedianRight = getMedianRight(finalMedianLeft, valueB, beforeValueB, nextValueA);
                }
//                finalMedianRight = Math.max(beforeValueA, beforeValueB);
            } else {
                finalMedianRight = finalMedianLeft;
            }
        }
        if (totalCount % 2 == 0) {
            // even
            finalMedian = (finalMedianLeft + finalMedianRight) / 2.00d;
        } else {
            // odd
            finalMedian = finalMedianLeft;
        }

        return finalMedian;
    }

    private int getMedianRight(int finalMedianLeft, int a, int b, int c) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(a);
        list.add(b);
        list.add(c);
        int min = Integer.MAX_VALUE;
        for(int item : list){
            if(item < finalMedianLeft){
                continue;
            } else {
                if(item < min){
                    min = item;
                }
            }
        }

        return min;
    }

    private int getLeftMedianMargin(int totalCount) {
        int totalLeftMargin;
        if (totalCount % 2 == 0) {
            // even num
            totalLeftMargin = totalCount / 2 - 1;
            if (totalLeftMargin < 0) {
                totalLeftMargin = 0;
            }
        } else {
            // odd num
            totalLeftMargin = (totalCount - 1) / 2;
        }
        return totalLeftMargin;
    }

    private double getMedian(int[] b) {
        int len = b.length;
        if (len % 2 == 0) {
            return (b[len / 2 - 1] + b[len / 2]) / 2.0d;
        } else {
            return b[(len - 1) / 2];
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays instance = new MedianOfTwoSortedArrays();
//         int[] testArr1 = {1,3,4,10,11};
//         int[] testArr2 = {5,7,8,9};
//         int[] testArr1 = {1};
//         int[] testArr2 = {0};
//        int[] testArr1 = { 2, 3, 4 };
//        int[] testArr2 = { 1 };
//      int[] testArr1 = { 1, 2};
//      int[] testArr2 = { 1, 2, 3 };
//         int[]  testArr1 = {1,2};
//         int[] testArr2 = {3,4,5};
//        int[] testArr1 = {2,3,4,5,6};
//        int[] testArr2 = {1,7};
//        int[] testArr1 = {1,2};
//        int[] testArr2 = {3};
        int[] testArr1 = {1,2,3,5};
        int[] testArr2 = {4};
        System.out.println(instance.findMedianSortedArrays(testArr1, testArr2));

        // System.out.println(Math.ceil(0.5));
    }

}
