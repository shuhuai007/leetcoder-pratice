package com.joe007.practice;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in place.
 * 
 * click to show follow up.
 * 
 * Follow up: Did you use extra space? A straight forward solution using O(mn)
 * space is probably a bad idea. A simple improvement uses O(m + n) space, but
 * still not the best solution. Could you devise a constant space solution?
 * 
 * @author zhoujie
 * 
 * 
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int rowNum = matrix.length;
        int columnNum = matrix[0].length;
        boolean[] rowZero = new boolean[rowNum];
        boolean[] columnZero = new boolean[columnNum];

        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                int elem = matrix[i][j];
                if (elem == 0) {
                    rowZero[i] = true;
                    columnZero[j] = true;
                }
            }
        }

        for(int i = 0; i < rowNum; i++){
            if(rowZero[i]){
                for(int j = 0; j < columnNum; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 0; j < columnNum; j++){
            if(columnZero[j]){
                for(int i = 0; i < rowNum; i++){
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public static void main(String[] args) {
        SetMatrixZeroes instance = new SetMatrixZeroes();
        int[] a = { 1, 2, 3 };
        int[] b = { 4, 0, 5 };
        int[] c = { 5, 7, 8 };
        int[][] matrix = new int[3][3];
        matrix[0] = a;
        matrix[1] = b;
        matrix[2] = c;

        instance.setZeroes(matrix);
        
        for(int i = 0; i < matrix.length; i++){
            StringBuilder row = new StringBuilder();
            for(int j = 0; j < matrix[0].length; j++){
                row.append(matrix[i][j]).append(",");
            }
            row.append(";");
            System.out.println(row);
        }
    }

}
