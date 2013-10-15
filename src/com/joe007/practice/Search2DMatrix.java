package com.joe007.practice;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 *
 * @author zhoujie
 * 
 * Start Time : 2013/10/14 : 19:13
 * End   Time : 2013/10/14 : 
 *
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null){
            return false;
        }

        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
//        System.out.println("rowCount" + rowCount +"; columnCount:" + columnCount);
        
        int beginIndex = 0;
        int endIndex = rowCount - 1;
        if(beginIndex == endIndex){
            return findTargetInArr(matrix[0], target);
        }
        int middleIndex = -1;
        while(beginIndex < endIndex && beginIndex != middleIndex && middleIndex != endIndex){
            middleIndex = (endIndex - beginIndex + 1)/2;
            if (target <  matrix[middleIndex][0]){
                endIndex = middleIndex - 1;
            } else if(target > matrix[middleIndex][columnCount - 1]){
                beginIndex = middleIndex + 1;
            } else {
                break;
            }
        }
        
        if(beginIndex < 0 || beginIndex > rowCount -1 || endIndex < 0 || endIndex > rowCount - 1 ){
            return false;
        }
//        System.out.println("---beginIndex :" + beginIndex + "; middleIndex:" + middleIndex + "; endIndex :" + endIndex);
        if(findTargetInArr(matrix[middleIndex], target) || findTargetInArr(matrix[beginIndex], target) || findTargetInArr(matrix[endIndex], target)){
            return true;
        }
//        findTargetInArr(matrix[0], target);
        return false;
    }

    private boolean findTargetInArr(int[] arr, int target) {
//        for(int item : arr){
//            System.out.println("arr:" + item);
//        }
        
        int beginIndex = 0;
        int endIndex = arr.length -1;
        if(beginIndex == endIndex){
            return target == arr[0];
        }
        
        int middleIndex = -1;
        
        while(beginIndex < endIndex && beginIndex != middleIndex && middleIndex != endIndex){
            middleIndex = (endIndex - beginIndex + 1)/2;
//            System.out.println("beginIndex :" + beginIndex + "; middleIndex:" + middleIndex + "; endIndex :" + endIndex);
//            System.out.println("target:" + target + "; value:" + arr[middleIndex]);
            if (target < arr[middleIndex]){
                endIndex = middleIndex - 1;
            } else if(target > arr[middleIndex]){
                beginIndex = middleIndex + 1;
            } else {
                // 
//                System.out.println("====target==arr[middleIndex]:" + (target==arr[middleIndex]));
                break;
            }
        }
//        System.out.println(" small middleIndex:" + middleIndex);
//        System.out.println("beginIndex :" + beginIndex + "; middleIndex:" + middleIndex + "; endIndex :" + endIndex);
        if(beginIndex < 0 || beginIndex > arr.length -1 || endIndex < 0 || endIndex > arr.length - 1 ){
            return false;
        }
        return target == arr[endIndex] || target == arr[middleIndex] || target==arr[beginIndex];
    }

    public static void main(String[] args) {
        Search2DMatrix instance = new Search2DMatrix();
        
//        int[][] matrix = {{1, 3,  5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int[][] matrix = {{1},{3}};
        System.out.println(instance.searchMatrix(matrix, 4));
    }

}
