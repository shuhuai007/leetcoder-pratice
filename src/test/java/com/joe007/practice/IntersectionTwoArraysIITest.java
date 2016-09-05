package com.joe007.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link IntersectionTwoArraysII}.
 */
public class IntersectionTwoArraysIITest {
    private IntersectionTwoArraysII instance = new IntersectionTwoArraysII();

    @Test
    public void intersectTest() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersection = instance.intersect(nums1, nums2);
        int[] expected = {2, 2};
        Assert.assertArrayEquals(expected, intersection);
    }
}
