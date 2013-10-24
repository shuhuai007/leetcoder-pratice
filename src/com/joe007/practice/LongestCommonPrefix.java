package com.joe007.practice;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author zhoujie
 * 
 * Start Time : 2013/10/24 : 15:03
 * End   Time : 2013/10/24 :
 *
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        
        
        return null;
    }
    
    public static void main(String[] args) {
        LongestCommonPrefix instance = new LongestCommonPrefix();
        String[] strs = {"good", "gomorning", "afternoon"};
        System.out.println(instance.longestCommonPrefix(strs));
    }

}
