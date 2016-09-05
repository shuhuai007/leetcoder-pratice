package com.joe007.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiezhou on 9/5/16.
 */
public class IntersectionTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        Map<Integer, Integer> valueToCountMap = new HashMap<Integer, Integer>();
        for (int element : nums1) {
            int count = 1;
            if (valueToCountMap.containsKey(element)) {
                count = valueToCountMap.get(element) + 1;
            }
            valueToCountMap.put(element, count);
        }

        List<Integer> integerList = new ArrayList<Integer>();
        for (int element : nums2) {
            if (valueToCountMap.containsKey(element)) {
                int count = valueToCountMap.get(element);
                if (count >= 1) {
                    integerList.add(element);
                    valueToCountMap.put(element, --count);
                }
            }
        }

        int[] intersectionArr = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            intersectionArr[i] = integerList.get(i);
        }

        return intersectionArr;
    }
}
