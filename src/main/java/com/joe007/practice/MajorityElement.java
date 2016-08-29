package com.joe007.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiezhou on 8/29/16.
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int threshold = nums.length / 2;

        Map<Integer, Integer> num2CountMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];
            int count = 1;
            if (num2CountMap.containsKey(element)) {
                count = num2CountMap.get(element) + 1;
            }
            num2CountMap.put(element, count);
            if (count > threshold) {
                return element;
            }
        }
        return 0;
    }
}
