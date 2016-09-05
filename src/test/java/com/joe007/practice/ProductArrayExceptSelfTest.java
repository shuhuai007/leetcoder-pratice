package com.joe007.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jiezhou on 9/5/16.
 */
public class ProductArrayExceptSelfTest {
    private ProductArrayExceptSelf instance = new ProductArrayExceptSelf();
    @Test
    public void productExceptSelfTest() {
        int[] nums = {1, 2, 3, 4};
        int[] productArr = instance.productExceptSelf(nums);
        int[] expected = {24, 12, 8, 6};
        Assert.assertArrayEquals(expected, productArr);
    }
}
