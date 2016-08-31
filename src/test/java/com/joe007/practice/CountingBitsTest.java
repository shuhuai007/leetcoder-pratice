package com.joe007.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link CountingBits}.
 */
public class CountingBitsTest {
    private CountingBits instance = new CountingBits();

    @Test
    public void countBitsTest() {
        int num = 5;
        int[] bitArr = instance.countBits(num);
        Assert.assertTrue(bitArr.length == 6);

        for (int i : bitArr) {
            System.out.println(i + " ");
        }
    }

}
