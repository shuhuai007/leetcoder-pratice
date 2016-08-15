package com.joe007.practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Unit test for {@link SumOFTwoIntegers}.
 */
public class SumOFTwoIntegersTest {
    private SumOFTwoIntegers instance = null;

    @Before
    public void before() {
        instance = new SumOFTwoIntegers();
    }

    @Test
    public void getSumTest() {
        int a = 20;
        int b = 30;
        int result = instance.getSum(a, b);
        Assert.assertEquals(50, result);
    }

    private void print(List<Integer> binaryA) {
        for (int i : binaryA) {
            System.out.print(i);
        }
        System.out.println();
    }

    @Test
    public void transform2ReversedBinaryListTest() {
        int i = 1;
        List<Integer> iList = instance.transform2ReversedBinaryList(i);
        Assert.assertEquals(1, iList.size());
        Assert.assertTrue(1 == iList.get(0));

        i = 8;
        print(instance.transform2ReversedBinaryList(i));
    }
}
