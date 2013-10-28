package com.joe007.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
 [1,2,3,4,5]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * @author zhoujie
 * Start Time : 2013/10/28 : 16:14
 * End   Time : 2013/10/28 :
 *
 */
public class Triangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0){
            return 0;
        }

        List<Integer> minimumSumList = new ArrayList<Integer>();
        
        minimumTotal(minimumSumList, triangle, triangle.size() - 1);
        
        int minSum = Integer.MAX_VALUE;
        for(int sum : minimumSumList){
            if(sum < minSum){
                minSum = sum;
            }
            
        }

        return minSum;
    }

    private void minimumTotal(List<Integer> minimumSumList, ArrayList<ArrayList<Integer>> triangle, int i) {
        ArrayList<Integer> currentList = triangle.get(i);
//        System.out.println("----i:" + i);
        if(i == 0){
            minimumSumList.add(currentList.get(0));
            return;
        }
        
        minimumTotal(minimumSumList, triangle, i - 1);
        
        List<Integer> minimumSumListCopy = new ArrayList<Integer>(minimumSumList);
        minimumSumList.clear();
        
        for(int index = 0; index < currentList.size(); index++){
            int currentVal  = currentList.get(index);
            if(index == 0){
                // index of previous row
                minimumSumList.add(minimumSumListCopy.get(0) + currentVal);
                
            } else if(index == currentList.size() - 1){
                // index-1 of previous row
                minimumSumList.add(minimumSumListCopy.get(index-1) + currentVal);
                
            } else {
                // index-1, index of previous row
                int minimumVal = currentVal + Math.min(minimumSumListCopy.get(index-1), minimumSumListCopy.get(index));
                minimumSumList.add(minimumVal);
            }
        }
    }

    public static void main(String[] args) {
        Triangle instance = new Triangle();
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        // 1st row
        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(2);
        triangle.add(row);
        // 2nd row
        ArrayList<Integer> row2 = new ArrayList<Integer>();
        row2.clear();
        row2.add(3);
        row2.add(4);
        triangle.add(row2);
        // 3ird row
        ArrayList<Integer> row3 = new ArrayList<Integer>();
        row3.clear();
        row3.add(6);
        row3.add(5);
        row3.add(7);
        triangle.add(row3);
        // 4th row
        ArrayList<Integer> row4 = new ArrayList<Integer>();
        row4.clear();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);
        triangle.add(row4);

        System.out.println(instance.minimumTotal(triangle));;
    }

}
