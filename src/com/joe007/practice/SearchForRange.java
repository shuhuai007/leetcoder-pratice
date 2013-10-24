package com.joe007.practice;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 * @author zhoujie
 *
 * Start Time : 2013/10/24 : 11:08
 * End   Time : 2013/10/24 : 14:01
 */
public class SearchForRange {

    public int[] searchRange(int[] A, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(A == null || A.length == 0){
            return result;
        }
        if(A.length == 1){
            if(target == A[0]){
                result[0] = 0;
                result[1] = 0;
            }
            return result;
        }
        int beginIndex = 0;
        int endIndex = A.length - 1;

        int flagIndex = -1;
        while(beginIndex < endIndex){
            int middleIndex = (beginIndex + endIndex)/2;
            if(target == A[middleIndex]){
                flagIndex = middleIndex;
//                System.out.println("firstPos = middleIndex:" + firstPos);
                break;
            } else if( target > A[middleIndex]){
                beginIndex = middleIndex;
            } else{
                endIndex = middleIndex;
            }
            if(beginIndex == endIndex - 1){
                if(A[beginIndex] == target){
                    flagIndex = beginIndex;
                }
                if(A[endIndex] == target){
                    flagIndex = endIndex;
                }
                break;
            }
        }

        System.out.println("flagIndex: " + flagIndex);
        if(flagIndex == -1){
            return result;
        } else {
            // 
            if(flagIndex > 0 && A[flagIndex-1] == target){
                result[0] = findLeftIndex(A, 0, flagIndex-1, target);
            } else {
                result[0] = flagIndex;
            }
            if(flagIndex < A.length - 1 && A[flagIndex + 1] == target){
                result[1] = findRightIndex(A, flagIndex + 1, A.length - 1, target);
            } else {
                result[1] = flagIndex;
            }
            return result;
        }
    }

    private int findRightIndex(int[] a, int i, int j, int target) {
        System.out.println("findRightIndex---i:" + i + "; j:" + j);
        int firstNotEqualTargetIndex = a.length;
        while(i < j){
            int middleIndex = (i + j + 1)/2;
            System.out.println("middleIndex:" + middleIndex );
            if(a[middleIndex] == target){
                i = middleIndex;
            } else if(a[middleIndex] > target && a[middleIndex - 1] == target){
                firstNotEqualTargetIndex = middleIndex;
                break;
            } else {
                j = middleIndex;
            }
            if(i == j - 1){
                break;
            }
        }
        
        if(firstNotEqualTargetIndex == a.length && i == j-1){
            if(a[i] == target && a[j] > target){
                firstNotEqualTargetIndex = j;
            }
        }
        return firstNotEqualTargetIndex - 1;
    }

    private int findLeftIndex(int[] a, int i, int j, int target) {
        int lastNotEqualTargetIndex = -1;
        while(i < j){
            int middleIndex = (i + j)/2;
            if(a[middleIndex] == target){
                j = middleIndex;
            } else if(a[middleIndex] < target && a[middleIndex + 1] == target){
                lastNotEqualTargetIndex = middleIndex;
                break;
            } else {
                i = middleIndex;
            }
            if(i == j - 1){
                break;
            }
        }
        return lastNotEqualTargetIndex + 1;
    }

    public static void main(String[] args) {
        SearchForRange instance = new SearchForRange();
        int[] A = {1,2,2,2,2,4};
        int target = 2;
        int[] resultArr = instance.searchRange(A, target);
        if(resultArr != null){
            StringBuilder sb = new StringBuilder();
            for(int item : resultArr){
                sb.append(item).append(",");
            }
            System.out.println(sb.substring(0, sb.length()-1));
        }

    }

}
