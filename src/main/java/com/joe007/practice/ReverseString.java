package com.joe007.practice;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 * Subscribe to see which companies asked this question
 */
public class ReverseString {

    public String reverseString(String s) {
        if (s == null || s.trim().isEmpty()) {
            return s;
        }
        char[] resultArr = new char[s.length()];
        int middleIndex = s.length() / 2;
        for (int i = 0; i < middleIndex; i ++) {
            int j = s.length() -1 - i;
            resultArr[i] = s.charAt(j);
            resultArr[j] = s.charAt(i);
        }

        if (isOdd(s.length())) {
            resultArr[(middleIndex)] = s.charAt(middleIndex);
        }
        return new String(resultArr);
    }

    private boolean isOdd(int number) {
        return number % 2 != 0;
    }
}
