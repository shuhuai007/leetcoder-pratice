package com.joe007.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link ContainsDuplicate}.
 */
public class ContainsDuplicateTest {
    private ContainsDuplicate instance = new ContainsDuplicate();

    @Test
    public void containsDuplicateTest() {
        int[] nums = {1, 2, 3};
        boolean actualResult = instance.containsDuplicate(nums);
        Assert.assertFalse(actualResult);
    }

}
