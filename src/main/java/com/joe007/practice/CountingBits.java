package com.joe007.practice;

/**
 * Created by jiezhou on 8/30/16.
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] bitsArr = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int bits = countBits4Int(i);
            bitsArr[i] = bits;
        }
        return bitsArr;
    }

    private int countBits4Int(int i) {
        if (i == 0) {
            return 0;
        }

        if (i == 1) {
            return 1;
        }
        if (i % 2 != 0) {
            return 1 + countBits4Int(i / 2);
        } else {
            return countBits4Int(i / 2);
        }
    }
}
