package com.joe007.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link MajorityElement}.
 */
public class MajorityElementTest {
    MajorityElement instance = new MajorityElement();

    @Test
    public void majorityElementTest() {

        int[] nums = {1, 1, 2, 10, 2, 2, 2};
        int actualValue = instance.majorityElement(nums);
        Assert.assertEquals(2, actualValue);


    }

}
