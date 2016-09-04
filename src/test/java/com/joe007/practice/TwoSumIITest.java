package com.joe007.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link TwoSumII}.
 */
public class TwoSumIITest {
    private TwoSumII instance = new TwoSumII();

    @Test
    public void twoSumTest() {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] a = instance.twoSum(numbers, target);
        int[] expected = {1, 2};
        Assert.assertArrayEquals(expected, a);
    }
}
