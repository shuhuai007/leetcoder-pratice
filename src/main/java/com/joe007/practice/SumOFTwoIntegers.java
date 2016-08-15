package com.joe007.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiezhou on 7/31/16.
 */

public class SumOFTwoIntegers {

    /**
     * Gets sum of a and b.
     *
     * @param a the first param
     * @param b the second param
     * @return int of sum
     */
    public int getSum(int a, int b) {
        List<Integer> binaryA = transform2ReversedBinaryList(a);
        List<Integer> binaryB = transform2ReversedBinaryList(b);
        print(binaryA);
        print(binaryB);
        int maxLength = binaryA.size() > binaryB.size() ? binaryA.size() : binaryB.size();
        int minLength = binaryA.size() > binaryB.size() ? binaryB.size() : binaryA.size();
        List<Integer> sumList = new ArrayList<Integer>(maxLength);
        int delta = 0;
        for (int i = 0; i <= maxLength - 1; i++) {
            int bitA = -1;
            int bitB = -1;
            if (i >= minLength) {
                if (binaryA.size() == minLength) {
                    bitA = 0;
                    bitB = binaryB.get(i);
                } else {
                    bitA = binaryA.get(i);
                    bitB = 0;
                }
            } else {
                bitA = binaryA.get(i);
                bitB = binaryB.get(i);
            }
            if (bitA == bitB) {
                sumList.add(i, delta);
                if (bitA == 1) {
                    delta = 1;
                } else {
                    delta = 0;
                }
            } else {
                sumList.add(i, (1 + delta) % 2);
            }
        }
        if (delta == 1) {
            sumList.add(delta);
        }
        print(sumList);
        int sum = reversedBinaryList2Decimal(sumList);
        return sum;
    }

    private int reversedBinaryList2Decimal(List<Integer> reversedBinaryList) {
        int sum = 0;
        for (int i = 0; i < reversedBinaryList.size(); i++) {
            int j = i;
            int temp = reversedBinaryList.get(i);
            while (j-- > 0) {
                temp = temp * 2;
            }
            sum += temp;
        }
        return sum;
    }

    private void print(List<Integer> binaryA) {
        for (int i : binaryA) {
            System.out.print(i);
        }
        System.out.println();
    }

    public List<Integer> transform2ReversedBinaryList(int i) {
        List<Integer> reversedList = new ArrayList<Integer>();
        if (i == 0 || i == 1) {
            reversedList.add(i);
            return reversedList;
        }
        int dividend = i;
        while (dividend >= 2) {
            int b = dividend % 2;
            reversedList.add(b);
            dividend = dividend / 2;
        }
        if (dividend == 1) {
            reversedList.add(1);
        }
        return reversedList;
    }
}


