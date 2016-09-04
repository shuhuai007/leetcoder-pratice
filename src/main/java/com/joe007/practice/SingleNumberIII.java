package com.joe007.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by jiezhou on 9/4/16.
 */
public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<Integer> singleNumberList = new ArrayList<Integer>();
        Map<Integer, Integer> numCountMap = new HashMap<Integer, Integer>();
        for (int element : nums) {
            int count = 1;
            if (numCountMap.containsKey(element)) {
                count = numCountMap.get(element) + 1;
            }
            numCountMap.put(element, count);
        }
        for (int element : numCountMap.keySet()) {
            int value = numCountMap.get(element);
            if (value == 1) {
                singleNumberList.add(element);
            }
        }
        int[] singleNumberArr = new int[singleNumberList.size()];
        for (int i = 0; i < singleNumberList.size(); i ++) {
            singleNumberArr[i] = singleNumberList.get(i);
        }

        return singleNumberArr;
    }
}
