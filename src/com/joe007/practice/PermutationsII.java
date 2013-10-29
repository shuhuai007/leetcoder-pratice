package com.joe007.practice;

import java.util.ArrayList;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
 * @author zhoujie
 *
 */
public class PermutationsII {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0){
            return resultList;
        }
        permute(num, num.length - 1, resultList);
        return resultList;
    }
    
    private void permute(int [] num, int lastIndex, ArrayList<ArrayList<Integer>> resultList){
//        System.out.println("lastIndex:" + lastIndex);

        if(lastIndex < 0){
            return;
        } else if(lastIndex == 0){
          ArrayList<Integer> itemList = new ArrayList<Integer>();
          itemList.add(num[0]);
          resultList.add(itemList); 
//          System.out.println("---resultList:" + resultList);
        } else {
            
            // >0
            permute(num, lastIndex-1, resultList);
//            System.out.println("resultList'size:" + resultList.size());
            ArrayList<ArrayList<Integer>> helpList = new  ArrayList<ArrayList<Integer>>(resultList);
            resultList.clear();
            for(int i = 0; i < helpList.size(); i++){
                ArrayList<Integer> itemList = helpList.get(i);
                for(int j = 0; j <= itemList.size(); j++){
                    ArrayList<Integer> permutationList = new ArrayList<Integer>(itemList);
                    if(j != itemList.size()){
                        permutationList.add(j, num[lastIndex]);
                    } else {
                        permutationList.add(num[lastIndex]);
                    }
                    if(!resultList.contains(permutationList)){
                        resultList.add(permutationList);
                    }
                }
            }

        }
    }

    public static void main(String[] args) {
        Permutations instance = new Permutations();
        int[] num = {1,2,2};
        System.out.println(instance.permute(num));

    }

}
