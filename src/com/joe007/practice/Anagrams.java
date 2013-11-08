package com.joe007.practice;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array of strings, return all groups of strings that are anagrams.
Note: All inputs will be in lower-case.
 * @author zhoujie
 * Start Time : 2013/11/08 : 13:30
 * End   Time : 2013/11/08 : 14:49
 *
 */
public class Anagrams {

//	public ArrayList<String> anagrams(String[] strs) {
//		ArrayList<String> resultList = new ArrayList<String>();
//		if(strs == null || strs.length == 0){
//			return resultList;
//		}
//		
//		ArrayList<Integer> tagList = new ArrayList<Integer>();
//		for(int i = 0; i < strs.length; i++){
//			if(tagList.contains(i)){
//				continue;
//			}
//			String currentStr = strs[i];
////			System.out.println("currentStr:" + currentStr);
//			ArrayList<String> currentList = getAnagrams(currentStr);
////			System.out.println("currentList:" + currentList);
//			boolean exist = false;
//			for(int j = i+1; j < strs.length; j++){
//				if(currentStr.length() == strs[j].length() && currentList.contains(strs[j]) && !resultList.contains(strs[j])){
//					resultList.add(strs[j]);
//					tagList.add(j);
//					exist = true;
//				}
//			}
//			if(exist){
//				resultList.add(currentStr);
//			}
//		}
//
//		return resultList;
//	}
	
	public ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> resultList = new ArrayList<String>();
		if(strs == null || strs.length == 0){
			return resultList;
		}
		
		ArrayList<Integer> tagList = new ArrayList<Integer>();
		for(int i = 0; i < strs.length; i++){
			if(tagList.contains(i)){
				continue;
			}
			String currentStr = strs[i];
//			System.out.println("currentStr:" + currentStr);
//			System.out.println("currentList:" + currentList);
			boolean exist = false;
			for(int j = i+1; j < strs.length; j++){
				if(isAnagrams(currentStr, strs[j]) && !resultList.contains(strs[j])){
					resultList.add(strs[j]);
					tagList.add(j);
					exist = true;
				}
			}
			if(exist){
				resultList.add(currentStr);
			}
			
		}

		return resultList;
	}

	private boolean isAnagrams(String currentStr, String str) {
		if(currentStr.length() == str.length()){
			char[] currentArr = currentStr.toCharArray();
			char[] arr = str.toCharArray();
			Arrays.sort(currentArr);
			Arrays.sort(arr);
			int i = 0;
			for(i = 0; i < arr.length; i++){
				if(currentArr[i] != arr[i]){
					break;
				}
			}
			if(i == arr.length){
				return true;
			}
		}
		return false;
	}

	private ArrayList<String> getAnagrams(String currentStr) {
		ArrayList<String> resultList = new ArrayList<String>();
		if(currentStr == null){
			return resultList;
		}
		
		if(currentStr.length() <= 1){
			resultList.add(currentStr);
			return resultList;
		}
		String lastChar = String.valueOf(currentStr.charAt(currentStr.length() - 1));
		ArrayList<String> subResultList = getAnagrams(currentStr.substring(0, currentStr.length()-1));
		for(String str : subResultList){
			if(!resultList.contains(lastChar + str)){
				resultList.add(lastChar + str);
			}
			for(int i = 1; i < str.length(); i++){
				String leftStr = str.substring(0, i);
				String rightStr = str.substring(i);
				String newStr = leftStr + lastChar + rightStr;
				if(!resultList.contains(newStr)){
					resultList.add(newStr);
				}
			}
			if(!resultList.contains(str + lastChar)){
				resultList.add(str + lastChar);
			}
		}
		return resultList;
	}

	public static void main(String[] args) {
		Anagrams instance = new Anagrams();
//		String[] strs = {"abc", "ba", "cba", "ab", "mmm"};
		String[] strs = {"dog","cat","god","tac"};
		
		System.out.println(instance.anagrams(strs));

	}

}
