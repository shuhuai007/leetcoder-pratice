package com.joe007.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link NimGame}.
 */
public class NimGameTest {
    private NimGame instance = new NimGame();

    @Test
    public void canWinNimTest() {
        int n = 4;
        Assert.assertFalse(instance.canWinNim(n));
        Assert.assertTrue(instance.canWinNim(3));
        Assert.assertTrue(instance.canWinNim(2));
        Assert.assertTrue(instance.canWinNim(1));
        Assert.assertTrue(instance.canWinNim(43));



    }
}
