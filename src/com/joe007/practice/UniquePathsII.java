package com.joe007.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
 * @author zhoujie
 * 
 * Start Time : 2013/10/25 : 10:23
 * End   Time : 2013/10/25 :
 *
 */
public class UniquePathsII {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int rowNum = obstacleGrid.length;
        int columnNum = obstacleGrid[0].length;
        
        Map<String, Integer> memo = new HashMap<String, Integer>();
        return uniquePaths(memo, obstacleGrid, rowNum, columnNum);
        
    }
    
    private int uniquePaths(Map<String, Integer> memo, int[][] obstacleGrid, int m, int n) {
        if(m <= 0 || n <=0){
            return 0;
        }
        
        int currentVal = obstacleGrid[m - 1][n - 1];
        if(currentVal == 1){
           return 0; 
        }

        if(m == 1 && n == 1){
            if(currentVal == 0){
                memo.put(m + "_" + n, 1);
                return 1;
            }
        }

        String key = m + "_" + n;
        if(currentVal == 0 && memo.containsKey((key))){
            int value = memo.get(key);
            return value;
        }

        int totalPaths = uniquePaths(memo, obstacleGrid, m, n-1) + uniquePaths(memo, obstacleGrid, m-1, n);
        memo.put(key, totalPaths);

        return totalPaths;
    }

    public static void main(String[] args) {
        UniquePathsII instance = new UniquePathsII();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(instance.uniquePathsWithObstacles(obstacleGrid));

    }

}
