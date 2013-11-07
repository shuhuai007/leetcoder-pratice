package com.joe007.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
 * @author zhoujie
 * 
 * Start Time : 2013/11/07 : 13:17
 * End   Time : 2013/11/07 : 14:02
 *
 */
public class LetterCombinationsOfAPhoneNumber {

	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> resultList = new ArrayList<String>();
		if(digits == null){
			return resultList;
		}
		if(digits.equals("")){
			resultList.add("");
			return resultList;
		}
		
		Map<String, String> map = constructDigit2StrMap();
		
		resultList = letterCombinations(digits, map);

		return resultList;
	}

	private ArrayList<String> letterCombinations(String digits, Map<String, String> map) {
		ArrayList<String> resultList = new ArrayList<String>();
		if(digits.length() == 1){
			String letter = map.get(String.valueOf(digits.charAt(0)));
			for(int i = 0; i < letter.length(); i++){
				String elem = String.valueOf(letter.charAt(i));
				resultList.add(elem);
			}
			return resultList;
		}
		String currentDigit = String.valueOf(digits.charAt(digits.length()-1));
		String currentLetters = map.get(currentDigit);
		String subStr = digits.substring(0, digits.length()-1);
		ArrayList<String> subResultList = letterCombinations(subStr, map);
		for(int i = 0; i < subResultList.size(); i++){
			String subResultStr = subResultList.get(i);
			for(int j = 0; j < currentLetters.length(); j++){
				String currentLetter = String.valueOf(currentLetters.charAt(j));
				resultList.add(subResultStr + currentLetter);
			}
		}
		return resultList;
	}

	private Map<String, String> constructDigit2StrMap() {
		Map<String, String> map = new HashMap<String, String>();
		char startChar = 'a';
		for(int i = 2; i <= 9; i++){
			if(i == 7 || i == 9){
				char[] arr = new char[4];
				arr[0] = startChar;
				arr[1] = (char)(++startChar);
				arr[2] = (char)(++startChar);
				arr[3] = (char)(++startChar);
				map.put(String.valueOf(i), String.valueOf(arr));
			} else {
				char[] arr = new char[3];
				arr[0] = startChar;
				arr[1] = (char)(++startChar);
				arr[2] = (char)(++startChar);
				map.put(String.valueOf(i), String.valueOf(arr));
			}
			startChar++;
		}
		return map;
	}

	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber instance = new LetterCombinationsOfAPhoneNumber();
		String digits = "234";
		System.out.println(instance.letterCombinations(digits));
	}

}
