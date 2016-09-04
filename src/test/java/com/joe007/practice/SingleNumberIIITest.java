package com.joe007.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link SingleNumberIII}.
 */
public class SingleNumberIIITest {
    private SingleNumberIII instance = new SingleNumberIII();

    @Test
    public void singleNumberTest() {
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] singleNumberArr = instance.singleNumber(nums);
        int[] expectedArr = {3, 5};
        for (int elem : singleNumberArr) {
            System.out.println(elem);
        }
        Assert.assertArrayEquals(expectedArr, singleNumberArr);


    }
}
