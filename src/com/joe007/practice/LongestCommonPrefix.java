package com.joe007.practice;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author zhoujie
 * 
 * Start Time : 2013/10/24 : 15:03
 * End   Time : 2013/10/24 : 15:24
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

        String commonStr = strs[0];
        for(int i = 1; i < strs.length; i++){
            String currentStr = strs[i];
            if(currentStr.equals("")){
                return "";
            }
            commonStr = compareStr(currentStr, commonStr);
            if(commonStr.equals("")){
                break;
            }
            
        }
        return commonStr;
    }

    private String compareStr(String currentStr, String commonStr) {
        int len1 = currentStr.length();
        int len2 = commonStr.length();
        int minLen = Math.min(len1, len2);
        int flagPos = -1;
        for(int i = 0; i < minLen; i++){
            if(currentStr.charAt(i) != commonStr.charAt(i)){
                break;
            } else {
                flagPos = i;
            }
        }
        if(flagPos == -1){
            return "";
        }
        String result = currentStr.substring(0, flagPos + 1);
        return result;
    }

    public static void main(String[] args) {
        LongestCommonPrefix instance = new LongestCommonPrefix();
        String[] strs = {"good", "goomorning", "goodfternoon"};
        System.out.println(instance.longestCommonPrefix(strs));
    }

}
