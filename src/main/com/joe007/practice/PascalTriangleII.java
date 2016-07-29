package com.joe007.practice;

import java.util.ArrayList;


/**
 * Given an index k, return the kth row of the Pascal's triangle. 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note: Could you optimize your algorithm to use only O(k) extra space?
   [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
   ]
 * 
 * Start Time : 2013/10/15 : 13:38
 * End   Time : 2013/10/15 : 14:37
 * 
 */
public class PascalTriangleII {

    public ArrayList<Integer> getRow(int rowIndex) {
        rowIndex++;
        if(rowIndex <= 0){
            return new ArrayList<Integer>();
        }

        ArrayList<ArrayList<Integer>> resultList =  new  ArrayList<ArrayList<Integer>>();
        for(int i = 1; i <= rowIndex; i++){
            ArrayList<Integer> rowList = new ArrayList<Integer>();
            int rowSize = i;
            for(int j = 0; j < rowSize; j++){
                if(j == 0 || j == (rowSize - 1)){
                    rowList.add(1);
                } else {
                    ArrayList<Integer> previousRowList = resultList.get(i - 2);
                    int elemVal = previousRowList.get(j - 1) + previousRowList.get(j);
                    rowList.add(elemVal);
                }
            }
            resultList.add(rowList);
        }
       

        return resultList.get(resultList.size() - 1);
    }

    public static void main(String[] args) {
        PascalTriangleII instance = new PascalTriangleII();
        System.out.println(instance.getRow(5));
    }

}
