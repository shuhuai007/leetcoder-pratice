package com.joe007.practice;

/**
 * Created by jiezhou on 8/30/16.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }

        if (num == 0) {
            return false;
        }

        if (num % 2 == 0) {
            return isUgly(num / 2);
        } else if (num % 3 == 0) {
            return isUgly(num / 3);
        } else if (num % 5 == 0) {
            return isUgly(num / 5);
        } else {
            return false;
        }
    }
}
