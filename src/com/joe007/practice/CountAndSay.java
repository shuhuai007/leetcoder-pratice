package com.joe007.practice;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.
Note: The sequence of integers will be represented as a string.
 * @author zhoujie
 * 
 * Start Time : 2013/10/29 : 15:23
 * End   Time : 2013/10/29 : 15:53
 *
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if(n <= 0){
            return "";
        }
        
        if(n == 1){
            return "1";
        }
        String previousStr = countAndSay(n - 1);

        int startIndex = 0;
        int endIndex = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= previousStr.length(); i++){
            char currentChar = 'a';
            char previousChar = previousStr.charAt(i - 1);
            if(i < previousStr.length() ){
                currentChar = previousStr.charAt(i);
            }
            
            if(currentChar == previousChar){
                // 
                endIndex = i;
            } else {
                // 
                int count = endIndex - startIndex + 1;
                sb.append(count).append(previousChar);
                startIndex = i;
                endIndex = i;
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        CountAndSay instance = new CountAndSay();
        System.out.println(instance.countAndSay(5));

    }

}
