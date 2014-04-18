package com.joe007.practice;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. For example,
 * 
 * Consider the following matrix:
 * 
 * [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] Given target = 3, return
 * true.
 * 
 * @author zhoujie
 * 
 *         Start Time : 2013/10/14 : 19:13 End Time : 2013/10/14 :
 * 
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) {
            return false;
        }

        int rowCount = matrix.length;
        int columnCount = matrix[0].length;

        int totalCount = rowCount * columnCount;

        // binary search [0...totalCount-1]
        int beginIndex = 0;
        int endIndex = totalCount - 1;
        while (beginIndex < endIndex - 1) {
            int middleIndex = (beginIndex + endIndex) / 2;
            int middleVal = getVal(matrix, columnCount, middleIndex);
            if (target == middleVal) {
                return true;
            } else if (target < middleVal) {
                endIndex = middleIndex - 1;
            } else {
                beginIndex = middleIndex + 1;
            }
        }

        int lastBeginVal = getVal(matrix, columnCount, beginIndex);
        int lastEndVal = getVal(matrix, columnCount, endIndex);

        return (lastBeginVal == target || lastEndVal == target);
    }

    private int getVal(int[][] matrix, int columnCount, int index) {
        int rowIndex = index / columnCount;
        int columnIndex = index % columnCount;
        return matrix[rowIndex][columnIndex];
    }

    public static void main(String[] args) {
        Search2DMatrix instance = new Search2DMatrix();

        // int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int[][] matrix = { { 1 }, { 3 } };
        System.out.println(instance.searchMatrix(matrix, 1));
    }

}
