package com.joe007.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link IntersectionTwoArrays}.
 */
public class IntersectionTwoArraysTest {
    private IntersectionTwoArrays instance = new IntersectionTwoArrays();

    @Test
    public void intersectionTest() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] intersection = instance.intersection(nums1, nums2);
        int[] expected = {2};
        Assert.assertArrayEquals(expected, intersection);

    }
}
