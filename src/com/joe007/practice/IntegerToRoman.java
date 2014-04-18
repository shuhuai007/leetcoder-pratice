package com.joe007.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be
 * within the range from 1 to 3999.
 * 
 * @author zhoujie
 * 
 *         Start Time : 2013/10/14 : 10:40 End Time : 2013/10/14 :
 * 
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        String result = "";
        int base[] = { 1000, 500, 100, 50, 10, 5, 1, 0 };
        char baseC[] = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
        int basen = 0;
        while (num > 0) {
            if (basen % 2 == 0 && num / base[basen] == 4) {
                result += baseC[basen];
                result += baseC[basen - 1];
                num -= base[basen] * 4;
            } else if (num >= base[basen]) {
                result += baseC[basen];
                num -= base[basen];
            } else if (basen % 2 == 0 && num / base[basen + 2] == 9) {
                result += baseC[basen + 2];
                result += baseC[basen];
                num -= base[basen + 2] * 9;
            } else {
                basen++;
            }
        }
        return result;
    }

    // private String intToRoman(int num, Map<Integer, Character> elementValMap,
    // int[] regionArr) {
    // if(num == 0){
    // return "";
    // }
    // if(num == 1){
    // return "I";
    // }
    //
    // int beginIndex = -1;
    // for(int i = 0; i < regionArr.length; i++){
    // if(num < regionArr[i]){
    // beginIndex = i;
    // break;
    // }
    // }
    // System.out.println("beginIndex:" + beginIndex + "; num:" + num);
    // if(beginIndex == -1){
    // beginIndex = regionArr.length - 1;
    // }
    //
    // if(num >= 1000){
    // int trader = num / 1000;
    // int remainder = num % 1000;
    // StringBuilder sb = new StringBuilder();
    // for(int i = 1; i <= trader; i ++){
    // sb.append("M");
    // }
    // return sb.toString() + intToRoman(remainder, elementValMap, regionArr);
    // } else {
    // int difference = 0;
    // if(regionArr[beginIndex] == 5 || regionArr[beginIndex] == 50 ||
    // regionArr[beginIndex] == 500){
    // difference = regionArr[beginIndex]/5;
    // } else {
    // difference = regionArr[beginIndex]/10;
    // }
    // if(difference == 0){
    // difference =1;
    // }
    //
    // // System.out.println("beginIndex:" + beginIndex);
    // System.out.println("regionArr[beginIndex]:" + regionArr[beginIndex]);
    // System.out.println("difference:" + difference);
    // if(num + difference >= regionArr[beginIndex]){
    // // get roman char
    // String str = String.valueOf(elementValMap.get(regionArr[beginIndex]));
    // // sustract
    // return intToRoman(regionArr[beginIndex] - num, elementValMap, regionArr)
    // + str;
    // } else {
    // String str = String.valueOf(elementValMap.get(regionArr[beginIndex -
    // 1]));
    // return str + intToRoman(num - regionArr[beginIndex - 1], elementValMap,
    // regionArr);
    // }
    //
    // }
    // }

    public static void main(String[] args) {

        // int testNum = 1000;
        // System.out.println(800/testNum + ";" + 800%testNum);

        IntegerToRoman instance = new IntegerToRoman();
        int num = 1001;
        System.out.println(instance.intToRoman(num));

    }

}
