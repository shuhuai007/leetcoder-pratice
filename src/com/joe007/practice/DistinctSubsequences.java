package com.joe007.practice;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 
Here is an example:
 S = "rabbbit", T = "rabbit" 
Return 3. 
 * @author zhoujie
 * Start Time : 2013/11/07 : 19:00
 * End   Time : 2013/11/07 :
 *
 */
public class DistinctSubsequences {
	
//    public int numDistinct(String S, String T) {
//    	
//    	int sLen = S.length();
//    	int tLen = T.length();
//    	
//    	int[][] matrix = new int[sLen + 1][tLen + 1];
//    	for(int i = 0; i <= sLen; i ++ ){
//    		matrix[i][0] = 0;
//    	}
//    	for(int j = 0; j <= tLen; j ++){
//    		matrix[0][j] = 1;
//    	}
//    	matrix[0][0] = 1;
//    	
//    	for(int i = 1; i <= sLen; i++){
//    		for(int j = 1; j <= tLen; j++){
//    			if(S.charAt(i-1)==T.charAt(j-1)){
//    				matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j];
//    			} else {
//    				matrix[i][j] = matrix[i-1][j];
//    			}
//    		}
//    	}
//    	
//        return matrix[sLen][tLen];
//    }
	
	public int numDistinct(String S, String T) {
		  if(S==null || T==null)return 0;
		  int occu[]=new int[T.length()];
		  for(int i=S.length()-1;i>=0;i--){
		      for(int j=0;j<T.length();j++){
		          if(S.charAt(i)==T.charAt(j)){
		              if(j==(T.length()-1))occu[j]++;
		              else occu[j]+=occu[j+1];
		          }
		      }
		  }
		  return occu[0];
		 }

	public static void main(String[] args) {
		DistinctSubsequences instance = new DistinctSubsequences();
		String S = "rabbbit";
		String T = "rabbit";
		System.out.println(instance.numDistinct(S, T));
	}

}
