package com.joe007.practice;

import java.util.Arrays;

/**
 * Created by jiezhou on 9/5/16.
 */
public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) {
            return nums;
        }

        int[] frontProduct = new int[nums.length];
        frontProduct[0] = 1;
        int[] backProduct = new int[nums.length];
        backProduct[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            int element = nums[i - 1];
            frontProduct[i] = frontProduct[i - 1] * element;
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            int element = nums[j + 1];
            backProduct[j] = backProduct[j + 1] * element;
        }

        int[] product = new int[nums.length];
        for (int k = 0; k < nums.length; k++) {
            product[k] = frontProduct[k] * backProduct[k];
        }
        return product;
    }

    private void print(int[] frontProduct) {
        for (int elem : frontProduct) {
            System.out.print(elem + ",");
        }
        System.out.println();
    }
}
