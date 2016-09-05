package com.joe007.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link IntegerBreak}.
 */
public class IntegerBreakTest {
    private IntegerBreak instance = new IntegerBreak();

    @Test
    public void integerBreakTest() {
        int n = 10;
        Assert.assertEquals(36, instance.integerBreak(n));
        Assert.assertEquals(1, instance.integerBreak(2));
        Assert.assertEquals(2, instance.integerBreak(3));
        Assert.assertEquals(4, instance.integerBreak(4));
        Assert.assertEquals(6, instance.integerBreak(5));
    }
}
