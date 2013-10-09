package com.joe007.practice;

/**
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * @author zhoujie
 * 
 * Start Time : 2013/10/09 19:15
 * End   Time : 2013/10/09 20:17
 */
public class SearchInsertPosition {

    public int searchInsert(int[] A, int target) {
        if(null == A || 0 == A.length){
            return 0;
        }

        int targetIndex = 0;
        int beginIndex = 0;
        int endIndex = A.length - 1;
        int middleIndex = (beginIndex + endIndex)/2;
        while(beginIndex <= endIndex){
            middleIndex = (beginIndex + endIndex)/2;
            System.out.println("beginIndex: " + beginIndex + "; endIndex: " + endIndex );
            if(beginIndex == middleIndex || endIndex == middleIndex){
                break;
            }
            int middleValue = A[middleIndex];
            System.out.println("middleValue:" + middleValue + "; target: " + target);
            if(middleValue == target){
                return middleIndex;
            } else if(target > middleValue){
                beginIndex = middleIndex;
            } else {
                endIndex = middleIndex;
            }

        }
        if(target > A[middleIndex]){
            if(target < A[endIndex]){
                targetIndex = middleIndex + 1;
            } else if(target > A[endIndex]){
                targetIndex = endIndex + 1;
            } else if(target == A[endIndex]){
                targetIndex = endIndex;
            }
        } else if(target < A[middleIndex]){
            targetIndex = middleIndex - 1;
        }
        if(targetIndex < 0){
            targetIndex = 0;
        }
        return targetIndex;
    }

    public static void main(String[] args) {
        SearchInsertPosition instance = new SearchInsertPosition();
        int[] A = {1,2,3};
        System.out.println(instance.searchInsert(A, 3));
//        System.out.println(instance.searchInsert(A, 2));
//        System.out.println(instance.searchInsert(A, 4));
//        System.out.println(instance.searchInsert(A, 6));
//        System.out.println(instance.searchInsert(A, 8));
    }

}
