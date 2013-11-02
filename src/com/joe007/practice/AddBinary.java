package com.joe007.practice;

/**
 * Given two binary strings, return their sum (also a binary string). 
 * For example, a = "11" b = "1" Return "100".
 * 
 * @author zhoujie
 * 
 * Start Time : 2013/11/02 : 11:18
 * End   Time : 2013/11/02 : 11:46
 */
public class AddBinary {

	public String addBinary(String a, String b) {
		
		if(isEmpty(a)){
			return b;
		}
		if(isEmpty(b)){
			return a;
		}
		
		int maxLen = a.length();
		if(b.length() > maxLen){
			maxLen = b.length();
		}
		
		int aIndex = 0;
		int bIndex = 0;
		int additionVal = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= maxLen; i++){
			aIndex = a.length() - i;
			bIndex = b.length() - i;
			int aDigit = 0;
			if(aIndex >= 0){
				aDigit = Integer.valueOf(String.valueOf(a.charAt(aIndex)));
			}
			int bDigit = 0;
			if(bIndex >=0){
				bDigit =  Integer.valueOf(String.valueOf(b.charAt(bIndex)));
			}
			
			int sumDigit = aDigit + bDigit + additionVal;
			if(sumDigit/2 > 0){
				sumDigit = sumDigit%2;
				additionVal = 1;
			} else {
				additionVal = 0;
			}
			sb.insert(0, sumDigit);
		}
		
		if(additionVal == 1){
			sb.insert(0, 1);
		}
		
		return sb.toString();
	}

	private boolean isEmpty(String b) {
		if(b == null || b.trim().equals("")){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		AddBinary instance = new AddBinary();
		String a = "1111";
		String b = "1111";
		System.out.println(instance.addBinary(a, b));
		
//		StringBuilder sb = new StringBuilder();
//		sb.insert(0, 1);
//		sb.insert(0, 2);
//		sb.insert(0, 3);
//		System.out.println(sb);
	}

}
