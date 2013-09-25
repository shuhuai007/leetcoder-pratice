package com.joe007.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Question describe:
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
   For example:
   Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
 * @author zhoujie
 *
 */
public class PathSumII {

    public static void main(String[] args) {
        int sum =  22;
        // construct the binary tree
        int[] sampleArr = new int[]{5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 5, 1};
        // traverse the tree
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        traverseTree(resultList, sum, sampleArr, 0);
        System.out.println("-------------");
        for(List<Integer> itemList : resultList){
//            System.out.println(itemList.size());
            for(Integer item : itemList){
                System.out.println(item);
            }
        }

    }

    private static void traverseTree(List<List<Integer>> resultList, int sum, int[] arr, int index) {
        if(index >= arr.length){
            return;
        }
        System.out.println("sum:" + sum);
        if(sum < 0){
            return;
        } else {
            // add element's index to list<set>
            List<Integer> trackList = findTrackList(index, resultList);
            if(null == trackList || 0 == trackList.size()){
                trackList = new ArrayList<Integer>();
                trackList.add(index);
                resultList.add(trackList);
            } else {
                trackList.add(index);
            }
            
            sum -= countParticalSum(trackList, arr);
        }
        traverseTree(resultList, sum, arr, ++index);
    }

    private static int countParticalSum(List<Integer> trackList, int [] arr) {
        int result = 0;
        for(Integer index : trackList){
            result += arr[index];
        }
        return result;
    }

    private static List<Integer> findTrackList(int index, List<List<Integer>> resultList) {
        for(List<Integer> elementList : resultList){
            int parentIndex = (index - 1)/2;
            int lastone = elementList.get(elementList.size() - 1);
            if(parentIndex == lastone){
                return elementList;
            }
        }
        return null;
    }

}
