package com.joe007.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/15 : 16:12
 * End   Time : 2013/10/15 : 16:37
 *
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if(grid == null){
            return 0;
        }
        int rowNum = grid.length;
        int columnNum =grid[0].length; 
        Map<String, Integer> minSumMap = new HashMap<String, Integer>();
        int minSum = minPathSum(grid, rowNum - 1, columnNum - 1, minSumMap);
        return minSum;
    }

    private int minPathSum(int[][] grid, int m, int n, Map<String, Integer> minSumMap) {
        String key = m + "_" + n;
        if(minSumMap.containsKey(key)){
            return minSumMap.get(key);
            
        }

        if(m == 0){
            int sum = 0;
            for(int i = 0; i <= n; i++){
                sum += grid[0][i];
            }
            minSumMap.put(key, sum);
            return sum;
        }
        if(n == 0){
            int sum = 0;
            for(int i = 0; i <= m; i++){
                sum += grid[i][0];
            }
            minSumMap.put(key, sum);
            return sum;
        }

        int minSum = Math.min(minPathSum(grid, m - 1, n, minSumMap), minPathSum(grid, m, n-1, minSumMap)) + grid[m][n];
        minSumMap.put(key, minSum);
        return minSum;
    }

    public static void main(String[] args) {
        MinimumPathSum instance = new MinimumPathSum();
        int [][] grid = {{1,2,3},{4,5,6}};
        System.out.println(instance.minPathSum(grid));

    }

}
