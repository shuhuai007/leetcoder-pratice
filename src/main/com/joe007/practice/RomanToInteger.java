package com.joe007.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author zhoujie
 *
 * Start Time : 2013/10/11 : 14:04
 * End   Time : 2013/10/11 : 14:30
 * 
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        if(null == s || s.trim().equals("")){
            return 0;
        }
        s = s.trim();
        Map<Character, Integer> elementValMap = new HashMap<Character, Integer>();
        elementValMap.put('I', 1);
        elementValMap.put('V', 5);
        elementValMap.put('X', 10);
        elementValMap.put('L', 50);
        elementValMap.put('C', 100);
        elementValMap.put('D', 500);
        elementValMap.put('M', 1000);
        char[] chArr = s.toCharArray();
        int sum = elementValMap.get(chArr[chArr.length - 1]);
        System.out.println("sum:" + sum);
        if(chArr.length > 1){
            for(int i = chArr.length - 2; i >= 0; i--){
                char element = chArr[i];
                int value = elementValMap.get(element);
                int nextValue = elementValMap.get(chArr[i+1]);
                if(value >= nextValue){
                    sum += value;
                } else {
                    sum -= value;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        RomanToInteger instance = new RomanToInteger();
        // I V X C M
        String s = "VI";
        s = "MMMCMXCIX";
        System.out.println(instance.romanToInt(s));

    }

}
