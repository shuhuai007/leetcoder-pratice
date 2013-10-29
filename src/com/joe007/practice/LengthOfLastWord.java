package com.joe007.practice;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * @author zhoujie
 * 
 * Start Time : 2013/10/29 : 13:38
 * End   Time : 2013/10/29 : 13:46
 */
public class LengthOfLastWord {
    
    public int lengthOfLastWord(String s) {
        if(s == null || s.trim().equals("")){
            return 0;
        }
        
        s = s.trim();
        
        String[] strArr = s.split(" ");
        return strArr[strArr.length - 1].length();
    }

    public static void main(String[] args) {
        LengthOfLastWord instance = new LengthOfLastWord();
        

    }

}
