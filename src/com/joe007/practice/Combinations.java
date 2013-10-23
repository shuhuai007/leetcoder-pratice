package com.joe007.practice;

import java.util.ArrayList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 * @author zhoujie
 * 
 * Start Time : 2013/10/23 : 13:32
 * End   Time : 2013/10/23 : 14:02
 *
 */
public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if(n <= 0 || n < k || k <= 0){
            return resultList;
        }
        combine(n, k, resultList);
        return resultList;
    }

    private void combine(int n, int k, ArrayList<ArrayList<Integer>> resultList) {
        if(k == 0){
            return;
        }
        if(k == 1){
            for(int i = 1; i <= n; i++){
                ArrayList<Integer> tempList = new ArrayList<Integer>();
                tempList.add(i);
                resultList.add(tempList);
            }
            return;
        }
        combine(n, k - 1, resultList);
        ArrayList<ArrayList<Integer>> copyList = new ArrayList<ArrayList<Integer>>(resultList);
        resultList.clear();

        for(int index = 0; index < copyList.size(); index++){
            ArrayList<Integer> tempList = copyList.get(index);
            int lastVal = tempList.get(tempList.size() - 1);
            for(int i = lastVal + 1; i <= n; i++){
                ArrayList<Integer> newResultList = new ArrayList<Integer>(tempList);
                newResultList.add(i);
                resultList.add(newResultList);
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Combinations instance = new Combinations();
        int n = 4;
        int k = 1;
        System.out.println(instance.combine(n, k));
    }

}
