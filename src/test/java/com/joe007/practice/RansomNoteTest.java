package com.joe007.practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for {@link RansomNote}.
 */
public class RansomNoteTest {
    private RansomNote instance = new RansomNote();
    @Before
    public void before() {

    }

    @Test
    public void canConstructTest() {
        Assert.assertTrue(instance.canConstruct("aa", "aab"));
        Assert.assertFalse(instance.canConstruct("aaa", "aab"));
        Assert.assertFalse(instance.canConstruct("m", "aab"));
        Assert.assertFalse(instance.canConstruct("maab", "aab"));
    }
}
