package com.joe007.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link UglyNumber}.
 */
public class UglyNumberTest {
    private UglyNumber instance = new UglyNumber();

    @Test
    public void isUglyTest() {
        int num = 1;
        Assert.assertTrue(instance.isUgly(num));

        num = 6;
        Assert.assertTrue(instance.isUgly(num));

        num = 8;
        Assert.assertTrue(instance.isUgly(num));

        num = 14;
        Assert.assertFalse(instance.isUgly(num));

        num = 0;
        Assert.assertFalse(instance.isUgly(num));


    }

}
