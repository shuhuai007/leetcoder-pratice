package com.joe007.practice;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
 * @author zhoujie
 * 
 * Start Time == End Time : 10:17
 *
 */
public class SubsetsII {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
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
            if(!resultList.contains(valueList)){
                resultList.add(valueList);
            }
        }
        
        return resultList;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SubsetsII instance = new SubsetsII();
        int[] S = {1,2,2};
        System.out.println(instance.subsetsWithDup(S));

    }

}
