package com.joe007.practice;


/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 * @author zhoujie
 * 
 * Start Time : 2013/10/16 : 19:12
 * End   Time : 2013/10/16
 *
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        if(n < 0){
            return null;
        }
        if(n == 0){
            return new int[0][0];
        }

        int maxValue = n*n;
        int rowCount = n;
        int columnCount = n;
        int[][] matrix = new int[rowCount][columnCount];
        System.out.println("rowCount:" + rowCount);
        
        int currentValue = 1;
        int direction = 1;
        int rowIndex = 0;
        int columnIndex = 0;
        while(currentValue <= maxValue){
            matrix[rowIndex][columnIndex] = currentValue;
            if(++currentValue > maxValue){
                break;
            }
            
            // allow the previous direction
            if(columnIndex < columnCount - 1 && matrix[rowIndex][columnIndex + 1] == 0 && direction == 1){
                columnIndex++;
                continue;
            }
            
            if(rowIndex < rowCount - 1 && matrix[rowIndex + 1][columnIndex] == 0 && direction == 2){
                rowIndex++;
                continue;
            }
            
            if(columnIndex > 0 && matrix[rowIndex][columnIndex - 1] == 0 && direction == 3){
                columnIndex--;
                continue;
            }
            
            if(rowIndex > 0 && matrix[rowIndex - 1][columnIndex] == 0 && direction == 4 ){
                rowIndex--;
                continue;
            }
            
            // 
            
            if(columnIndex < columnCount - 1 && matrix[rowIndex][columnIndex + 1] == 0){
                columnIndex++;
                direction = 1;
                continue;
            }
            if(rowIndex < rowCount - 1 && matrix[rowIndex + 1][columnIndex] == 0){
                rowIndex++;
                direction = 2;
                continue;
            }
            if(columnIndex > 0 && matrix[rowIndex][columnIndex - 1] == 0){
                columnIndex--;
                direction = 3;
                continue;
            }
            if(rowIndex > 0 && matrix[rowIndex - 1][columnIndex] == 0){
                rowIndex--;
                direction = 4;
                continue;
            }
        }
        
        
        return matrix;
    }

    public static void main(String[] args) {
//        int[] a = new int[3];
//        for(int item : a){
//            System.out.println(item);
//            
//        }
        
        
        SpiralMatrixII instance = new SpiralMatrixII();
        
        int[][] matrix = instance.generateMatrix(9);
//        int[][] matrix = {{1,2,3},{2,3,5}};
        if(null != matrix){
            for(int i = 0; i < matrix.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < matrix[0].length; j++){
                    if(j == 0){
                        sb.append("[");
                    }
                    sb.append(matrix[i][j]);
                    if(j != matrix[0].length - 1){
                        sb.append(",");
                    } else {
                        sb.append("]");
                    }
                }
                System.out.println(sb);
            }
        }

    }

}
