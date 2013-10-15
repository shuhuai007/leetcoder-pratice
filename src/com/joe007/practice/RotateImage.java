package com.joe007.practice;


/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up:
 * Could you do this in-place?
 * 
 * 1,2,3
 * 4,5,6
 * 7,8,9
 * 
 * 7,4,1
 * 8,5,2
 * 9,6,3
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/15 : 16:40
 * End   Time : 2013/10/15 : 18:28
 *
 */
public class RotateImage {

    public void rotate(int[][] matrix) {
        if(matrix == null){
            return;
        }
        int n = matrix.length;
        
        int [][] resultMatrix = new int[n][n];
        for(int i = 0; i < n; i++){
            int newMatrixColumnIndex = n - 1 - i;
            
            for(int j = 0; j < n; j++){
                resultMatrix[j][newMatrixColumnIndex] = matrix[i][j];
            }
        }
        
        for(int i = 0; i < resultMatrix.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < resultMatrix[0].length; j++){
                matrix[i][j] = resultMatrix[i][j];
            }
        }
//        for(int i = 0; i < matrix.length; i++){
//            StringBuilder sb = new StringBuilder();
//            for(int j = 0; j < matrix[0].length; j++){
//                sb.append(matrix[i][j]).append(" ");
//            }
//            System.out.println(sb.toString());
//        }
    }

    public static void main(String[] args) {
        RotateImage instance = new RotateImage();
         
        int[][] matrix = {{1,2}, {3,4}};
        instance.rotate(matrix);
        for(int i = 0; i < matrix.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < matrix[0].length; j++){
                sb.append(matrix[i][j]).append(" ");
            }
            System.out.println(sb.toString());
        }

    }

}
