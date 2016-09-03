package com.joe007.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link FindDifference}.
 */
public class FindDifferenceTest {
    private FindDifference instance = new FindDifference();

    @Test
    public void findTheDifferenceTest() {
        String s = "abcd";
        String t = "abcde";
        char differentChar = instance.findTheDifference(s, t);
        Assert.assertEquals('e', differentChar);
    }


}
