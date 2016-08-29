package com.joe007.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiezhou on 8/29/16.
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> num2CountMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            if (num2CountMap.containsKey(element)) {
                return true;
            }
            num2CountMap.put(element, 1);
        }
        return false;
    }
}
