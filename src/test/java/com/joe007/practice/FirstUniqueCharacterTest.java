package com.joe007.practice;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for {@link FirstUniqueCharacter}.
 */
public class FirstUniqueCharacterTest {

    private FirstUniqueCharacter instance = new FirstUniqueCharacter();

    @Test
    public void firstUniqCharTest() {
        String s = "leetcode";
        int actualIndex = instance.firstUniqChar(s);
        Assert.assertEquals(0, actualIndex);

        s = "loveleetcode";
        Assert.assertEquals(2, instance.firstUniqChar(s));
    }
}
