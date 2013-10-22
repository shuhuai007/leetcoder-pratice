package com.joe007.practice;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 * @author zhoujie
 * 
 * Start Time : 2013/10/22 : 16:24
 * End   Time : 2013/10/22 : 
 *
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return ;
        }
        int rowNum = matrix.length;
        int columnNum = matrix[0].length;
        for(int i = 0; i < rowNum; i++){
            
        }
        
        
        
    }

    public static void main(String[] args) {
        SetMatrixZeroes instance = new SetMatrixZeroes();
        int[][] matrix = {};
        instance.setZeroes(matrix);
    }

}
