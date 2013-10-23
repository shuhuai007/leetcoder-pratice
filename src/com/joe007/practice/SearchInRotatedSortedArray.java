package com.joe007.practice;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 * @author zhoujie
 * 
 * Start Time : 2013/10/22 : 20:13
 * End   Time : 2013/10/23 : 9:42
 *
 */
public class SearchInRotatedSortedArray {

    public int search(int[] A, int target) {
        if(A == null || A.length == 0){
            return -1;
        }
        if(A.length == 1){
            if(A[0] == target){
                return 0;
            } else {
                return -1;
            }
        }
        
        int pivotIndex = findPivot(A);
        System.out.println("pivotIndex:" + pivotIndex);
        
        int beginIndex = -1;
        int endIndex = -1;
        if(pivotIndex == -1){
            return search(A, 0, A.length - 1, target);
        }
        
        System.out.println("target:" + target + "; A[0]:" + A[0] +"; A[pivotIndex]:" + A[pivotIndex] + "; A[pivotIndex + 1]:" + A[pivotIndex + 1] + "; A[len-1]" + A[A.length - 1]);
        if(target == A[pivotIndex]){
            return pivotIndex;
        } else if(target <= A[pivotIndex] && target >= A[0]){
            beginIndex = 0;
            endIndex = pivotIndex;
        } else if(target >= A[pivotIndex + 1] && target <= A[A.length - 1]){
            beginIndex = pivotIndex + 1;
            endIndex = A.length - 1;
        } else {
            return -1;
        }
        int resultIndex = search(A, beginIndex, endIndex, target);
        return resultIndex;
    }

    private int search(int[] a, int beginIndex, int endIndex, int target) {
        System.out.println("---endIndex:" + endIndex);
        int resultIndex = -1;
        while(beginIndex < endIndex){
            int middleIndex = (beginIndex + endIndex)/2;
            if(a[middleIndex] == target){
                resultIndex = middleIndex; 
                break;
            }
            if(beginIndex == endIndex - 1){
                break;
            }
            
            if(a[middleIndex] > target){
                endIndex = middleIndex;
            }
            if(a[middleIndex] < target){
                beginIndex = middleIndex;
            }

        }
        if(target == a[beginIndex]){
            return beginIndex;
        }
        System.out.println("endIndex:" + endIndex);
        if(target == a[endIndex]){
            return endIndex;
        }
        
        return resultIndex;
    }

    private int findPivot(int[] a) {
        int beginIndex = 0;
        int endIndex = a.length - 1;
        int pivotIndex = -1;
        while(beginIndex < endIndex){
            int middleIndex = (beginIndex + endIndex)/2;
            if(a[middleIndex] > a[middleIndex + 1]){
                pivotIndex = middleIndex;
                break;
            }
            if(a[middleIndex] > a[beginIndex]){
                beginIndex = middleIndex;
            } else if(a[middleIndex] < a[endIndex]){
                endIndex = middleIndex;
            }
            
        }

        return pivotIndex;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray instance = new SearchInRotatedSortedArray();
        int[] A = {4, 5, 6, 7, 0, 1, 2};
//        int[] A = {5,3};
        int target = 5;
        System.out.println(instance.search(A, target));
    }

}
