package com.joe007.practice;

import java.util.ArrayList;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]
 * @author zhoujie
 * Start Time : 2013/11/06 : 19:10
 * End   Time : 2013/11/06 : 
 *
 */
public class PalindromePartitioning {
	
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> resultList = new ArrayList<ArrayList<String>>();
		
		if(s == null || s.length() == 0){
			return resultList;
		}

		if(s.length() == 1){
			ArrayList<String> partitionList = new ArrayList<String>();
			partitionList.add(s);
			resultList.add(partitionList);
			return resultList;
		}
		
		for(int i = s.length() - 1; i > 0; i--){
			String checkString = s.substring(0, i);
			String lastStr = s.substring(i);
			if(!isPalindrome(lastStr)){
				continue;
			}
			palindrome(checkString, lastStr, resultList);
		}
		
		if(isPalindrome(s)){
			ArrayList<String> selfList = new ArrayList<String>();
			selfList.add(s);
			if(!resultList.contains(selfList)){
				resultList.add(selfList);
			}
		}

		return resultList;
	}

	private void palindrome(String checkString, String lastStr, ArrayList<ArrayList<String>> resultList) {
		String currentLastChar = lastStr;
		ArrayList<ArrayList<String>> subResultList = partition(checkString);
		for(ArrayList<String> partitionList : subResultList){
			ArrayList<String> newPartitionList = new ArrayList<String>(partitionList);
			newPartitionList.add(currentLastChar);
			resultList.add(newPartitionList);
			
			String lastElement = partitionList.get(partitionList.size() - 1);
			String lastElementExtend = lastElement + currentLastChar;
			if(isPalindrome(lastElementExtend)){
				partitionList.remove(partitionList.size() - 1);
				partitionList.add(lastElementExtend);
				resultList.add(partitionList);
			}
		}
	}

	private boolean isPalindrome(String str) {
		if(str == null || str.length() <= 1){
			return true;
		}
		int len = str.length();
		for(int i = 0; i <= len/2; i++){
			char leftChar = str.charAt(i);
			char rightChar = str.charAt(len - 1 - i);
			if(leftChar != rightChar){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromePartitioning instance = new PalindromePartitioning();
		String s = "abbab";
		s="abcba";
		System.out.println(instance.partition(s));
	}

}
