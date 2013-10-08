package com.joe007.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Start Time : 2013/10/08 19:23
 * End   Time : 2013/10/08 19:33
 */
public class SingleNumber {

    public int singleNumber(int[] A) {
        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
        for(int element : A){
            if(tempMap.containsKey(element)){
                int tempVal = tempMap.get(element);
                tempVal += 1;
                tempMap.put(element, tempVal);
            } else {
                tempMap.put(element, 1);
            }
        }
        for(int element : tempMap.keySet()){
            int times = tempMap.get(element);
            if(1 == times){
                return element;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int [] testArr = {1, 1, 3, 8, 3, 5, 5};
        SingleNumber instance = new SingleNumber();
        System.out.println(instance.singleNumber(testArr));
    }

}
