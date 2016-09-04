package com.joe007.practice;

/**
 * Created by jiezhou on 9/4/16.
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int[] indexArr = new int[2];
        for (int i = 0; i < numbers.length - 1; i ++) {
            for (int j = i + 1; j < numbers.length; j ++) {
                if (numbers[i] + numbers[j] == target) {
                    indexArr[0] = i + 1;
                    indexArr[1] = j + 1;
                    return indexArr;
                }
            }
        }

        return indexArr;
    }
}
