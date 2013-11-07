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
	
    public int numDistinct(String S, String T) {
    	
        return 0;
    }

	public static void main(String[] args) {
		DistinctSubsequences instance = new DistinctSubsequences();
		String S = "rabbbit";
		String T = "rabbit";
		System.out.println(instance.numDistinct(S, T));
	}

}
