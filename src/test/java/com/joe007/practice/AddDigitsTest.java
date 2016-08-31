package com.joe007.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Test class for {@link AddDigits}.
 */
public class AddDigitsTest {
    private AddDigits instance = new AddDigits();

    @Test
    public void addDigitsTest() {
        int num = 38;
        Assert.assertEquals(2, instance.addDigits(num));

    }
}
