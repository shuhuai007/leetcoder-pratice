package com.joe007.practice;

/**
 * Created by jiezhou on 8/4/16.
 */
public class AddDigits {
    public int addDigits(int num) {

        String numStr = String.valueOf(num);
        if (numStr.length() == 1) {
            return Integer.valueOf(numStr);
        }
        int sum = 0;
        for (char bit : numStr.toCharArray()) {
            int bitNum = Integer.valueOf(String.valueOf(bit));
            sum += bitNum;
        }

        return addDigits(sum);
    }
}
