package com.joe007.practice;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * @author zhoujie
 * 
 * Start Time : 2013/10/24 : 16:56
 * End   Time : 2013/10/25 : 10:08
 *
 */
public class Subsets {

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> resultIndexList = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.length == 0){
            return resultList;
        }

        resultIndexList.add(new ArrayList<Integer>());
        ArrayList<ArrayList<Integer>> lastResultList = new ArrayList<ArrayList<Integer>>(resultIndexList);
        for(int i = 1; i <= S.length ; i++){
            ArrayList<ArrayList<Integer>> lastResultListCopy = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> itemList : lastResultList){
                if(itemList.size() == 0){
                    for (int index = 0; index < S.length; index++) {
                        ArrayList<Integer> tempList = new ArrayList<Integer>(itemList);
                        tempList.add(index);
                        resultIndexList.add(tempList);
                        lastResultListCopy.add(tempList);
                    }
                } else {
                    int lastElement = itemList.get(itemList.size() - 1);
                    for (int index = lastElement + 1; index <= S.length - 1; index++){
                        ArrayList<Integer> tempList = new ArrayList<Integer>(itemList);
                        tempList.add(index);
                        resultIndexList.add(tempList);
                        lastResultListCopy.add(tempList);
                    }
                }
            }
            lastResultList = lastResultListCopy;
        }
        
        for(ArrayList<Integer> tempList : resultIndexList){
            ArrayList<Integer> valueList = new   ArrayList<Integer>();
            for(Integer index : tempList){
                valueList.add(S[index]);
            }
            Collections.sort(valueList);
            resultList.add(valueList);
        }

        return resultList;
    }
    
    public static void main(String[] args) {
        Subsets instance = new Subsets();
        int[] S = {1,2,2};
        System.out.println(instance.subsets(S));

    }

}
