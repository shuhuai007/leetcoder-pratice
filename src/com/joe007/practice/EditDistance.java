package com.joe007.practice;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.
You have the following 3 operations permitted on a word:
a) Insert a character
b) Delete a character
c) Replace a character
 * @author zhoujie
 * Start Time : 2013/11/06 : 16:37
 * End   Time : 2013/11/06 : 17:23
 *
 */
public class EditDistance {

	public int minDistance(String word1, String word2) {
		if(word1 == null || word1.trim().equals("")){
			return len(word2);
		}
		
		if(word2 == null || word2.trim().equals("")){
			return len(word1);
		}
		
		if(word1.equals(word2)){
			return 0;
		}
		
		int steps = 0;
//		int word1Index = 0;
		int i = 0;
		for(i = 0; i < word2.length(); i++){
			char currentChar = word2.charAt(i);
			System.out.println("i:" + i + "; currentChar:" + currentChar);
			if(i > word1.length() - 1){
				// should insert
				steps++;
				word1 = word1 + currentChar;
			} else {
				// word1 char
				char word1Char = word1.charAt(i);
				if(word1Char == currentChar){
					continue;
				} else {
					if(existInStr(word2, i, word1Char)){
						// insert currentChar
						steps++;
						word1 = word1.substring(0, i) + currentChar + word1.substring(i, word1.length());
					} else {
						// replace currentChar
						steps++;
						word1 = word1.substring(0, i) + currentChar + word1.substring(i + 1, word1.length());
					}
				}
			}
			
		}
		
		System.out.println("steps:" + steps + "; i:" + i);
		if(i < word1.length()){
			steps += (word1.length() - i);
		}
		
		return steps;
	}
	
	private String findMaxChildStr(String word1, String word2){
		int word1Len = word1.length();
		int word2Len = word2.length();
		int i = 0;
		int j = 0;
		while(i <= word1Len - 1 && j <= word2Len){
			
			
			
			
		}
		
		
		return null;
	}

	private boolean existInStr(String word2, int i, char word1Char) {
		word2 = word2.substring(i);
		return word2.contains(String.valueOf(word1Char));
	}

	private int len(String word2) {
		if(word2 == null){
			return 0;
		}
		return word2.length();
	}

	public static void main(String[] args) {
		EditDistance instance = new EditDistance();
		String word1 = "sea";
		String word2 = "eat";
		
		System.out.println("max child str: " + instance.findMaxChildStr(word1, word2)); 
//		System.out.println(instance.minDistance(word1, word2));
		
//		char a= 'b';
//		String teststr = "hello";
//		System.out.println(teststr + a);

	}

}
