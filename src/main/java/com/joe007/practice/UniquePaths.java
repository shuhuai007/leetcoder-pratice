package com.joe007.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * Note: m and n will be at most 100.
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/15 : 10:44
 * End   Time : 2013/10/15 : 13:33
 *
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        Map<String, Integer> memo = new HashMap<String, Integer>();
        return uniquePaths(memo, m, n);
    }

    private int uniquePaths(Map<String, Integer> memo, int m, int n) {
        if(m <= 0 || n <=0){
            return 0;
        }
        if(m == 1 || n == 1){
            memo.put(m + "_" + n, 1);
            return 1;
        }

        String key = m + "_" + n;
        if(memo.containsKey((key))){
            int value = memo.get(key);
            return value;
        }

        int totalPaths = uniquePaths(memo, m, n-1) + uniquePaths(memo, m-1, n);
        memo.put(key, totalPaths);

        return totalPaths;
    }

    public static void main(String[] args) {
        UniquePaths instance = new UniquePaths();
        System.out.println(instance.uniquePaths(23, 12));
    }

}
