package com.joe007.practice;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jiezhou on 8/22/16.
 */
public class MoveZeroesTest {
    private MoveZeroes instance = new MoveZeroes();

    @Test
    public void moveZerosWithNullArrayTest() {
        int[] nums = null;
        instance.moveZeroes(nums);
        Assert.assertNull(nums);
    }

    @Test
    public void moveZerosWithEmptyArrayTest() {
        int[] nums = {};
        instance.moveZeroes(nums);
        Assert.assertNotNull(nums);
        Assert.assertTrue(nums.length == 0);
    }

    @Test
    public void moveZerosWithOneElementTest() {
        int[] nums = {1};
        instance.moveZeroes(nums);
        Assert.assertNotNull(nums);

        int[] expectedNums = {1};
        Assert.assertArrayEquals(expectedNums, nums);

        int[] nums2 = {0};
        int[] expectedNums2 = {0};
        instance.moveZeroes(nums);
        Assert.assertArrayEquals(expectedNums2, nums2);
    }

    @Test
    public void moveZerosTest() {
        int[] nums = {0, 1, 0, 3, 12};
        instance.moveZeroes(nums);
        int[] expectedNums = {1, 3, 12, 0, 0};
        Assert.assertArrayEquals(expectedNums, nums);
    }

    @Test
    public void moveZeros3ElemsTest() {
        int[] nums = {0, 0, 1};
        instance.moveZeroes(nums);
        int[] expectedNums = {1, 0, 0};
        Assert.assertArrayEquals(expectedNums, nums);

    }


}