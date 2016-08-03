package com.joe007.practice;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 * @author zhoujie
 * Start Time : 2013/11/13 : 15:00
 * End   Time : 2013/11/13 : 15:53
 */
public class ValidPalindrome {
	
	public boolean isPalindrome(String s) {
		if (s == null || s.trim().equals("")) {
			return true;
		}

		int beginIndex = 0;
		int endIndex = s.length() - 1;
		
		while(beginIndex < endIndex){
			char beginChar = s.charAt(beginIndex);
			char endChar = s.charAt(endIndex);
			if(!isAlphanumeric(beginChar)){
				beginIndex++;
				continue;
			}
			if(!isAlphanumeric(endChar)){
				endIndex--;
				continue;
			}
			if(!checkEqual(beginChar, endChar)){
				return false;
			} else {
				beginIndex++;
				endIndex--;
			}
		}
		return true;
	}
	
	

	private boolean checkEqual(char beginChar, char endChar) {
		if(beginChar == endChar){
			return true;
		}
		
		if(!isDigit(beginChar) && !isDigit(endChar) && Math.abs(beginChar - endChar) == 32){
			return  true;
		}
		
		return false;
	}
	
	private boolean isDigit(char testChar) {
		if(testChar >= 48 && testChar <= 57){
			return true;
		}
		
		return false;
	}


	private boolean isAlphanumeric(char testChar) {
		if(testChar >= 97 && testChar <= 122){
			return true;
		}
		
		if(testChar >= 65 && testChar <= 90){
			return true;
		}
		
		if(testChar >= 48 && testChar <= 57){
			return true;
		}
		
		return false;
	}



	public static void main(String[] args) {
		ValidPalindrome instance = new ValidPalindrome();
		String s = "A man, a plan, a canal: Panama";
		s = "race a car";
		System.out.println(instance.isPalindrome(s));
		
//		int x = 'a';
//		System.out.println("a" + x);
//		x = 'z';
//		System.out.println("z" + x);
//		x = 'A';
//		System.out.println("A" + x);
//		x = 'Z';
//		System.out.println("Z" + x);
//		x = '0';
//		System.out.println("0" + x);
//		x = '9';
//		System.out.println("0" + x);
	}

}
