package com.joe007.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by jiezhou on 9/22/14.
 *
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

 Each number in C may only be used once in the combination.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 A solution set is:
 [1, 7]
 [1, 2, 5]
 [2, 6]
 [1, 1, 6]
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] num, int target) {

        return combinationSum2(num, num.length, target);
    }

    private List<List<Integer>> combinationSum2(int[] num, int length, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(target <= 0 || length == 0){
            return result;
        }

        int lastVal = num[length - 1];
        //System.out.println("lastVal:" + lastVal);
        if(target < lastVal){
            return combinationSum2(num, length - 1, target);
        } else {
            // choose the lastVal
            //System.out.println(":" + (target - lastVal));
            List<List<Integer>> previousList = combinationSum2(num, length - 1, target - lastVal);
            if(previousList.isEmpty() && target == lastVal){
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(lastVal);
                result.add(temp);
            } else {
                for(List<Integer> item : previousList){
                    item.add(lastVal);
                    result.add(item);
                }
            }

           // System.out.println("previousList:" + previousList);
            // not choose the lastVal
            List<List<Integer>> notChooseCurrentList = combinationSum2(num, length - 1, target);
            //System.out.println("notChooseCurrentList:" + notChooseCurrentList);
            for(List<Integer> item : notChooseCurrentList){
                result.add(item);
            }

            return result;
        }

    }

    public static void main(String[] args) {
        CombinationSumII instance = new CombinationSumII();
        int[] num = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(instance.combinationSum2(num, target));
    }

}
