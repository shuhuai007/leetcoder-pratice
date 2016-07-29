package com.joe007.practice;

/**
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * @author zhoujie
 * Start Time : 2013/11/11 : 10:11
 * End   Time : 2013/11/11 : 15:34
 *
 */
public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {
		if (s == null || s.trim().length() == 0 || s.length() == 1) {
			return s;
		}

		char currentChar = s.charAt(s.length() - 1);
		String subStr = s.substring(0, s.length() - 1);

		String subLongestPalindrome = longestPalindrome(subStr);
		int subPalindromeLen = subLongestPalindrome.length();
		
		String lastSubStr = subStr.substring(subStr.length() - subPalindromeLen);

		// add the before char and the behind char
		String appendBehind = lastSubStr + currentChar;
		String appendBeforeBehind = appendBehind;
		if (subStr.length() != subPalindromeLen) {
			appendBeforeBehind = subStr.charAt(subStr.length() - subPalindromeLen - 1) + appendBehind;
			if (isPalindromic(appendBeforeBehind)) {
				return appendBeforeBehind;
			}
		}

		// add behind char
		if (isPalindromic(appendBehind)) {
			return appendBehind;
		}
		return subLongestPalindrome;
	}

	private boolean isPalindromic(String str) {
		if(str == null || str.length() == 1){
			return true;
		}
		int i = 0;
		for(i = 0; i < str.length()/2; i++){
			char otherStr = str.charAt(str.length() - 1 - i);
			if(str.charAt(i) != otherStr){
				return false;
			}
		}
		return (i == str.length()/2);
	}

	public static void main(String[] args) {
		LongestPalindromicSubstring instance = new LongestPalindromicSubstring();
		String s = "aba";
		System.out.println(instance.longestPalindrome(s));
	}

}
