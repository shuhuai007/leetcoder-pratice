package com.joe007.practice;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 * @author zhoujie
 * 
 * Start Time : 2013/10/11 : 17:01
 * End   Time : 2013/10/11 : 17:19
 */
public class PascalTriangle {

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        if(numRows <= 0){
            return new ArrayList<ArrayList<Integer>>();
        }

        ArrayList<ArrayList<Integer>> resultList =  new  ArrayList<ArrayList<Integer>>();
        for(int i = 1; i <= numRows; i++){
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
        return resultList;
    }

    public static void main(String[] args) {
        PascalTriangle instance = new PascalTriangle();
        ArrayList<ArrayList<Integer>>  resultList = instance.generate(5);
        System.out.println("total row: " + resultList.size());
        for(ArrayList<Integer> rowList : resultList){
            System.out.println(rowList);
        }
        
    }

}
