package com.joe007.practice;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcamnbcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * Start Time : 2013/10/08 14:17
 * End   Time : 2013/10/08 15:21
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    
    public int lengthOfLongestSubstring(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        char [] charArr = s.toCharArray();
        Queue<Character> tempQueue = new ArrayDeque<Character>();
        int maxCount = 0;
//        String maxSubStr = "";
        for(char element : charArr){
//            System.out.println("element: " + element);
            if(!tempQueue.contains(element)){
                tempQueue.add(element);
            } else {
//                System.out.println("exist: " + element);
                int tempCount = tempQueue.size();
                
                if(maxCount < tempCount){
                    maxCount = tempCount;
//                    maxSubStr = tempQueue.toString();
                }
                while(!tempQueue.peek().equals(element)){
                    tempQueue.remove();
                }
                if(tempQueue.peek().equals(element)){
                    tempQueue.remove();
                }
                tempQueue.add(element);
            }
        }
//        System.out.println("max subString: " + maxSubStr);
//        System.out.println("tempQueue size:" + tempQueue.size());
        maxCount = Math.max(maxCount, tempQueue.size());
        return maxCount;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters instance = new LongestSubstringWithoutRepeatingCharacters();

        String testStr = "abcabcf";
        testCase(instance, testStr, 4);

        testStr = "adbcamnocbb";
        testCase(instance, testStr, 7);

        testStr = "qopubjguxhxdipfzwswybgfylqvjzhar";
        testCase(instance, testStr, 12);

        testStr = "pppp";
        testCase(instance, testStr, 1);
    }

    private static void testCase(LongestSubstringWithoutRepeatingCharacters instance, String testStr, int expectedValue) {
        int actualValue = instance.lengthOfLongestSubstring(testStr);
        System.out.println("---testStr :" + testStr + " : output value : " + actualValue + "; expected value : " + expectedValue + "; Result : " + (actualValue == expectedValue));
    }

}
