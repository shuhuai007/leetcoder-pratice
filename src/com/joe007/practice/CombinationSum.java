package com.joe007.practice;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
 * @author zhoujie
 * Start Time : 2013/10/30 : 13:10
 * End   Time : 2013/10/30 : 14:21
 *
 */
public class CombinationSum {
    
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>>  resultList = new ArrayList<ArrayList<Integer>> ();
        if(candidates == null | candidates.length == 0){
            return resultList;
        }
        
        combinationSum(candidates, target, resultList, candidates.length);
        return resultList;
    }

    private void combinationSum(int[] candidates, int target, ArrayList<ArrayList<Integer>> resultList, int length) {
//        System.out.println("length:" + length);
        if(length == 0){
            return;
        }
        if(length == 1){
            int value = candidates[0];
            if(value > target){
                return;
            } else {
                // value <= target
                int repeatedTimes = 1;
                int repeatedValue = value;
                while(repeatedValue <= target){
                    if(repeatedValue == target){
                        ArrayList<Integer> tempList = new  ArrayList<Integer>();
                        for(int i = 0; i < repeatedTimes; i++){
                            tempList.add(value);
                        }
                        if(!resultList.contains(tempList)){
                            resultList.add(tempList);
                        }
                    } 
                    repeatedTimes++;
                    repeatedValue = value * repeatedTimes;
                }
            }
            return;
        }
        
        //
        combinationSum(candidates, target, resultList, length - 1);

        int lastValue = candidates[length - 1];
//        System.out.println("lastValue: " + lastValue);
        if(lastValue > target){
            return;
        } else {
            // lastValue <= target
            int repeatedTimes = 1;
            int repeatedValue = lastValue;
            while(repeatedValue <= target){
//                System.out.println("repeatedTimes:" + repeatedTimes);
                if(repeatedValue == target){
                    ArrayList<Integer> tempList = new  ArrayList<Integer>();
                    for(int i = 0; i < repeatedTimes; i++){
                        tempList.add(lastValue);
                    }
                    if(!resultList.contains(tempList)){
                        resultList.add(tempList);
                    }
                } else {
                    ArrayList<ArrayList<Integer>> resultListTemp = new ArrayList<ArrayList<Integer>>();
                    combinationSum(candidates, target - repeatedValue, resultListTemp, length - 1);
                    for(ArrayList<Integer> tempListOriginal : resultListTemp){
                        ArrayList<Integer> tempList = new ArrayList<Integer>(tempListOriginal);
                        for(int i = 0; i < repeatedTimes; i++){
                            tempList.add(lastValue);
                        }
                        Collections.sort(tempList);
                        if(!resultList.contains(tempList)){
                            resultList.add(tempList);
                        }
                    }
                }
                repeatedTimes++;
                repeatedValue = lastValue * repeatedTimes;
            }
        }
        
    }

    public static void main(String[] args) {
        CombinationSum instance = new CombinationSum();
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(instance.combinationSum(candidates , target));

    }

}
