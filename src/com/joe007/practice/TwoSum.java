package com.joe007.practice;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

startTime: 2013/09/29 14:43
  endTime: 2013/09/29 15:17

 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int smallValIndex = 0;
        int largeValIndex = 0;
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < numbers.length; i++){
            int number = numbers[i];
            if(indexMap.containsKey(number)){
                smallValIndex = indexMap.get(number);
                largeValIndex = i + 1;
                break;
            } else {
                int difference = target - number;
                indexMap.put(difference, i+1);
            }
        }
        int[] indexArr = new int[2];
        if(numbers[smallValIndex - 1] > numbers[largeValIndex - 1]){
            int tmp = smallValIndex;
            smallValIndex = largeValIndex;
            largeValIndex = tmp;
        }
        indexArr[0] = smallValIndex;
        indexArr[1] = largeValIndex;
        return indexArr;
    }

    public static void main(String[] args) {
        int[] testArr = {2,7,11,15};
        TwoSum instance = new TwoSum();
        int[] resultArr = instance.twoSum(testArr, 18);
        for(int index : resultArr){
            System.out.println(index);
        }
    }

}
