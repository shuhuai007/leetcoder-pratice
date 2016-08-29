package com.joe007.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link ValidAnagram}.
 */
public class ValidAnagramTest {

    private ValidAnagram instance = new ValidAnagram();

    @Test
    public void isAnagramTest() {
        String s = "anagram";
        String t = "nagarma";
        boolean result = instance.isAnagram(s, t);
        Assert.assertTrue(result);
    }

}