package com.joe007.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by jiezhou on 9/4/16.
 */
public class IntersectionTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (isEmpty(nums1) || isEmpty(nums2)) {
            return null;
        }

        Set<Integer> num1Set = new HashSet<Integer>();
        for (int element : nums1) {
            num1Set.add(element);
        }
        Set<Integer> intersectionSet = new HashSet<Integer>();
        for (int element : nums2) {
            if (num1Set.contains(element)) {
                intersectionSet.add(element);
            }
        }

        int[] intersectionArr = new int[intersectionSet.size()];
        int index = 0;
        Iterator<Integer> iterator = intersectionSet.iterator();
        while(iterator.hasNext()){
            intersectionArr[index++] = iterator.next();
        }

        return intersectionArr;
    }

    private boolean isEmpty(int[] nums1) {
        return nums1 == null || nums1.length == 0;
    }
}
