package com.joe007.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/22 : 9:27
 * End   Time : 2013/10/22 : 9:40
 *
 */
public class SingleNumberII {
    
    public int singleNumber(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }

        if(A.length <= 3){
            return A[0];
        }

        Map<Integer, Integer> timesMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < A.length; i++){
            int element = A[i];
            if(!timesMap.containsKey(element)){
                timesMap.put(element, 1);
            } else {
                int times = timesMap.get(element);
                times++;
                timesMap.put(element, times);
            }

        }
        for(int key : timesMap.keySet()){
            int value = timesMap.get(key);
            if(value != 3){
                return key;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        SingleNumberII instance = new SingleNumberII();
        int[] A = {1,1,1,3,2,2,2,4,4,4};
        System.out.println(instance.singleNumber(A));
    }

}
