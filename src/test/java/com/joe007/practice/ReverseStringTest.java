package com.joe007.practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit class for {@link ReverseString}.
 */
public class ReverseStringTest {
    private ReverseString reverseString;

    @Before
    public void before() {
        reverseString = new ReverseString();
    }

    @Test
    public void reverseStringWithEmptyStrTest() {
        String s = "";
        Assert.assertEquals("", reverseString.reverseString(s));
        s = " ";
        Assert.assertEquals(" ", reverseString.reverseString(s));
    }

    @Test
    public void reverseStringWithOneCharTest() {
        String s = "h";
        Assert.assertEquals("h", reverseString.reverseString(s));
    }

    @Test
    public void reverseStringWithNormalStrTest() {
        String s = "hello";
        String resultStr = reverseString.reverseString(s);
        Assert.assertEquals("not equal", "olleh", resultStr);

        s = "abcd";
        Assert.assertEquals("dcba", reverseString.reverseString(s));
    }

}
