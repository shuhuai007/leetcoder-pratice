package com.joe007.practice;

/**
 * 
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows.
 * How should you handle such cases?
 * Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).
 * Start Time : 2013/10/08 20:00
 * End   Time : 2013/10/08
 */
public class ReverseInteger {

    public int reverse(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        String digitStr = String.valueOf(x);
        System.out.println("digitStr:" + digitStr);
        
        char [] digitCharArr = digitStr.toCharArray();
        char [] inversedDigitCharArr = new char[digitCharArr.length];
        int minI = 0;
        if(x < 0){
            minI = 1;
        }
        int j = minI;
        for(int i = digitCharArr.length - 1; i >= minI; i--){
            inversedDigitCharArr[j ++] = digitCharArr[i];
        }
        if(minI == 1){
            inversedDigitCharArr[0] = '-';
        }
//        System.out.println("inversedDigitCharArr:" + inversedDigitCharArr[inversedDigitCharArr.length - 1]);
        
        int inversedInt = Long.valueOf(String.valueOf(inversedDigitCharArr)).intValue();
        System.out.println("inversedInt: " + inversedInt);
//        System.out.println("max: " + Integer.MAX_VALUE);
        return inversedInt;
    }

    public static void main(String[] args) {
        int testDigit = -1000000003 ;
        ReverseInteger instance = new ReverseInteger();
        System.out.println(instance.reverse(testDigit));
    }

}
