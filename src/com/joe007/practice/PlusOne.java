package com.joe007.practice;

import java.util.Arrays;


/**
 * Given a number represented as an array of digits, plus one to the number.
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/10/15 : 15:25
 * End   Time : 2013/10/15 : 16:10
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return null;
        }

        int currentPoint = digits.length - 1;
        System.out.println("currentPoint:" + currentPoint);
        int plus = 1;
        while(currentPoint >= 0){
            System.out.println("while---currentPoint:" + currentPoint);
            int digitVal = digits[currentPoint];
            digits[currentPoint] = (digitVal + plus)%10;
            if(digitVal + plus < 10){
                plus = 0;
                break;
            }
            currentPoint--;
            
        }
        int[] resultArr = null;
        if(currentPoint < 0 && plus != 0){
            resultArr = new int[digits.length + 1];
            resultArr[0] = 1;
            for(int i = 0; i <= digits.length - 1; i++) {
                resultArr[i + 1] = digits[i];
            }
        } else {
            resultArr = digits;
            
        }
        return resultArr;
    }

    public static void main(String[] args) {
//        System.out.println("max:" + Integer.MAX_VALUE);
        PlusOne instance = new PlusOne();
        int[] digits = {9, 9, 9};
        int[] testArr = instance.plusOne(digits);
        
        if(null != testArr){
            for(int item : testArr){
                System.out.print(item);
            }
        }

    }

}
