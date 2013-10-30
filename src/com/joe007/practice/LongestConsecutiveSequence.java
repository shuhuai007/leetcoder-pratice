package com.joe007.practice;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * @author zhoujie
 * Start Time : 2013/10/30 : 15:46
 * End   Time : 2013/10/30 : 17:06
 *
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0){
            return 0;
        }
        if(num.length == 1){
            return 1;
        }
        
        Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        map.put(num[0], new ArrayList<Integer>());
        for(int i = 1; i < num.length; i++){
            int currentVal = num[i];
            int previousVal = currentVal - 1;
            int nextVal = currentVal + 1;
            if(map.containsKey(currentVal)){
                continue;
            }

            if(map.containsKey(previousVal)){
                ArrayList<Integer> previousSet = map.get(previousVal);
                previousSet.add(currentVal);
            }
            if(map.containsKey(nextVal)){
                ArrayList<Integer> currentSet = new ArrayList<Integer>();
                currentSet.add(nextVal);
                map.put(currentVal, currentSet);
            }
            if(!map.containsKey(currentVal)){
                map.put(currentVal, new ArrayList<Integer>());
            }
        }
//        System.out.println(map);
        List<Integer> keySetCopy = new ArrayList<Integer>(map.keySet());
        
        for(int key : map.keySet()){
            ArrayList<Integer> valueSet = map.get(key);
            if(valueSet.isEmpty()){
                keySetCopy.remove(new Integer(key));
                continue;
            }
            if(keySetCopy.contains(key)){
                int checkKey = valueSet.get(valueSet.size()-1);
                while(map.keySet().contains(checkKey) && !map.get(checkKey).isEmpty()){
                    List<Integer> checkValList = map.get(checkKey);
                    valueSet.addAll(checkValList);
                    keySetCopy.remove(new Integer(checkKey));
                    checkKey = checkValList.get(checkValList.size() - 1);
                }
            }
        }
//        System.out.println(map);

        int maxValueListCount = 0;
        for(List<Integer> valueList : map.values()){
            int size = valueList.size();
            if(size > maxValueListCount){
                maxValueListCount = size;
            }
        }
        return (maxValueListCount + 1);
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence instance = new LongestConsecutiveSequence();
//        int[] num = {100, 4, 200, 1, 3, 2};
        int[] num = {1,3,5,2,4};
        System.out.println(instance.longestConsecutive(num));
    }

}
